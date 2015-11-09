/*
 * @(#)SshExample.java
 *
 * Copyright (c) 2004 JSCAPE
 * 1147 S. 53rd Pl., Mesa, Arizona, 85206, U.S.A.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * JSCAPE. ("Confidential Information").  You shall not disclose such
 * Confidential Information and shall use it only in accordance with
 * the terms of the license agreement you entered into with JSCAPE.
 */
import com.jscape.inet.ssh.*;
import com.jscape.inet.ssh.util.SshParameters;
import java.io.*;

public class SshExample implements SshListener {
	
	// state of SSH connection
	private boolean connected = false;

	/**
	 * Creates a new SshExample instance.
	 *
	 */
	public SshExample() {
		String hostname = null;
		String username = null;
		String password = null;
		Ssh ssh = null;		

		try {
			BufferedReader bin =
				new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Enter SSH hostname: ");
			hostname = bin.readLine();

			System.out.print("Enter SSH username: ");
			username = bin.readLine();

			System.out.print("Enter SSH password: ");
			password = bin.readLine();

			// create new Ssh instance
			SshParameters params = new SshParameters(hostname,username,password);
			ssh = new Ssh(params);
			
			// register to capture events
			ssh.addSshListener(this);
			
			System.out.println("Connecting please wait...");
			
			// connect
			ssh.connect();

			// get output stream for writing data to SSH server
			OutputStream out = ssh.getOutputStream();

			// holds line entered at console
			String line = null;

			// read data from console
			while (connected && (line = bin.readLine()) != null) {
				// send line with LF to SSH server
				line += "\n";
				try {
				  out.write(line.getBytes());
				  out.flush();
				} catch(Exception ioe){
				  connected = false;
				}	
			}			
		} catch (Exception e) {
			e.printStackTrace();			
		} finally {
			try {
				if(connected) {
				  ssh.disconnect();	
				}
			} catch(Exception e) {
				
			}			
		}
	}

	/**
	 * Captures SshConnectedEvent
	 */
	public void connected(SshConnectedEvent ev) {
		System.out.println("Connected: " + ev.getHost());
		connected = true;
	}

	/**
	 * Captures SshDataReceivedEvent
	 */
	public void dataReceived(SshDataReceivedEvent ev) {
		// send data received to console
		System.out.print(ev.getData());
	}

	/**
	 * Captures SshDisconnectedEvent
	 */
	public void disconnected(SshDisconnectedEvent ev) {
		System.out.println("Disconnected: " + ev.getHost() + ". Press Enter to exit");
		connected = false;
	}

	/**
	 * Main method for SshExample
	 * @param args
	 */
	public static void main(String[] args) {
		SshExample test = new SshExample();
	}

}
