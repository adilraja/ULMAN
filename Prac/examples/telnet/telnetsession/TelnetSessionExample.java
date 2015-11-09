/*
 * @(#)TelnetSessionExample.java
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

import com.jscape.inet.telnet.*;

public class TelnetSessionExample extends TelnetAdapter {
	
	// define telnet prompts .. these must match exactly those provided by telnet server
	private String shellPrompt = "$";
	private String loginPrompt = "login:";
	private String passwordPrompt = "Password:";
	
	// variable for connection info
	private String hostname;
	private String username;
	private String password;
	private TelnetSession session;
	
	/**
	 * Constructs a new TelnetSessionExample instance
	 * @param hostname the telnet hostname
	 * @param username the telnet username
	 * @param password the telnet password
	 */
	public TelnetSessionExample(String hostname, String username, String password) {
		this.hostname = hostname;
		this.username = username;
		this.password = password;
		session = new TelnetSession(hostname);
		session.setShellPrompt(shellPrompt);
		session.setLoginPrompt(loginPrompt);
		session.setPasswordPrompt(passwordPrompt);
		session.addTelnetListener(this);
	}
	
	/**
	 * Connects to server, logs in and performs UNIX directory listing command
	 * @throws TelnetException
	 */
	public void printDirListing() throws TelnetException {
		session.connect(username,password);
		String dirListing = session.send("ls -l");
		System.out.println(dirListing);
		session.disconnect();		
	}
	
	public void connected(TelnetConnectedEvent evt) {
		System.out.println("Connected to host: " + evt.getHost());
	}
	
	public void disconnected(TelnetDisconnectedEvent evt) {
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
			TelnetSessionExample ts = new TelnetSessionExample(tmpHost,tmpUser,tmpPass);
			ts.printDirListing();					
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
