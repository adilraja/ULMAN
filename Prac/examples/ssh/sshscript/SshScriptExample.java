/*
 * @(#)SshScriptExample.java
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

import com.jscape.inet.ssh.*;
import com.jscape.inet.ssh.util.SshParameters;
import java.io.*;

public class SshScriptExample extends SshAdapter {
    
    
    private Ssh ssh = null;
    private SshScript script = null;
    private OutputStream output = null;
    private static BufferedReader reader = null;
    
    public SshScriptExample(String hostname, String username, String password) throws IOException, SshException {
    	
    	// assumes that SSH shell prompt is "$" .. this MUST match exactly 
        String shellPrompt = "$";
        
        // the two commands to execute
        String command = "ls -al";
        String command2 = "pwd";
        
        // create new Ssh instance
        SshParameters sshParams = new SshParameters(hostname,username,password);
        ssh = new Ssh(sshParams);
        
        // register for events
        ssh.addSshListener(this);
        
        // create new script
        script = new SshScript(ssh);
        
        // build tasks
        
        // build tasks to execute
        SshTask commandTask = new SshTask(shellPrompt,command,shellPrompt);
		SshTask command2Task = new SshTask(shellPrompt,command2,shellPrompt);
        
        // add all tasks to script
        script.addTask(commandTask);
		script.addTask(command2Task);
        
        
        // connect to SSH server and execute script
        ssh.connect();
        
        // wait until last task is complete
        while(!command2Task.isComplete()) {
            try {
                
                Thread.sleep(1000);
            } catch(Exception e) {}
            
        }
        
        // disconnect from server
        ssh.disconnect();
        
    }  
    
	/**
	 * Invoked when SSH connection is established.
	 *
	 * @param event a SshConnectedEvent
	 * @see SshConnectedEvent
	 * @see Ssh#connect
	 */
	public void connected(SshConnectedEvent event) {
		System.out.println("Connected to host: " + event.getHost());
	}

	/**
	 * Invoked when SSH connection is released.
	 * Disconnect can occur in many circumstances including IOException during socket
	 * read/write or manually invoking the <code>Ssh#disconnect</code> method.
	 *
	 * @param event a SshDisconnectedEvent
	 * @see SshDisconnectedEvent
	 * @see Ssh#disconnect
	 */
	public void disconnected(SshDisconnectedEvent event) {
		System.out.println("Disconnected from host: " + event.getHost());
	}

	/**
	 * Invoked when data is received from Telnet server.
	 *
	 * @param event a <code>SshDataReceivedEvent</code>
	 * @see SshDataReceivedEvent
	 */
	public void dataReceived(SshDataReceivedEvent event) {
		System.out.print(event.getData());
	}   
    
    /**
     * Runs example
     * @param args
     */
    public static void main(String[] args) {
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("SSH hostname: ");
            String hostname = reader.readLine();
			System.out.print("SSH username: ");
			String username = reader.readLine();
			System.out.print("SSH password: ");
			String password = reader.readLine();            
            SshScriptExample example = new SshScriptExample(hostname,username,password);
        } catch(Exception e) {
            e.printStackTrace(System.out);
        }
    }
    
}

