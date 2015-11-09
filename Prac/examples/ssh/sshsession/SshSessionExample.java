/*
 * @(#)SshSessionExample.java
 *
 * Copyright (c) 2001-2002 JScape
 * 1147 S. 53rd Pl., Mesa, Arizona, 85206, U.S.A.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * JScape. ("Confidential Information").  You shall not disclose such
 * Confidential Information and shall use it only in accordance with
 * the terms of the license agreement you entered into with JScape.
 */
import java.io.*;

import com.jscape.inet.ssh.*;
import com.jscape.inet.ssh.util.SshParameters;

public class SshSessionExample extends SshAdapter {
	
	// define SSH prompts .. these must match exactly those provided by SSH server
	private String shellPrompt = "$";
	
	// variable for connection info
	private String hostname;
	private String username;
	private String password;
	private SshSession session;
	
	/**
	 * Constructs a new SshSessionExample instance
	 * @param hostname the SSH hostname
	 * @param username the SSH username
	 * @param password the SSH password
	 */
	public SshSessionExample(String hostname, String username, String password) throws SshException {
		this.hostname = hostname;
		this.username = username;
		this.password = password;
		SshParameters sshParams = new SshParameters(hostname,username,password);
		session = new SshSession(sshParams);
		session.setShellPrompt(shellPrompt);
		session.addSshListener(this);
	}
	
	/**
	 * Connects to server, logs in and performs UNIX directory listing command
	 * @throws TelnetException
	 */
	public void printDirListing() throws SshException {
		session.connect();
		String dirListing = session.send("ls -l");
		System.out.println(dirListing);
		session.disconnect();		
	}
	
	public void connected(SshConnectedEvent evt) {
		System.out.println("Connected to host: " + evt.getHost());
	}
	
	public void disconnected(SshDisconnectedEvent evt) {
		System.out.println("Disconnected from host: " + evt.getHost());
	}
	
	/**
	 * Runs example
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			String tmpHost = null;
			String tmpUser = null;
			String tmpPass = null;
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Hostname: ");
			tmpHost = reader.readLine();
			System.out.print("Username: ");
			tmpUser = reader.readLine();
			System.out.print("Password: ");
			tmpPass = reader.readLine();
			SshSessionExample ss = new SshSessionExample(tmpHost,tmpUser,tmpPass);
			ss.printDirListing();					
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
