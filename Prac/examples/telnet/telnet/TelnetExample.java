/*
 * @(#)TelnetExample.java
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

import com.jscape.inet.telnet.*;
import java.io.*;

public class TelnetExample extends TelnetAdapter {

	private Telnet telnet = null;
	private OutputStream output = null;
	private static BufferedReader reader = null;
	private boolean connected = false;

	public TelnetExample(String hostname) throws IOException, TelnetException {

		String input = null;
		// create new Telnet instance
		telnet = new Telnet(hostname);

		// register this class as TelnetListener
		telnet.addTelnetListener(this);

		// establish Telnet connection
		telnet.connect();
		connected = true;

		// get output stream
		output = telnet.getOutputStream();

		// sends all data entered at console to Telnet server
		while ((input = reader.readLine()) != null) {
			if (connected) {
				((TelnetOutputStream) output).println(input);
			} else {
				break;
			}
		}
	}

	/** 
	 * Invoked when Telnet socket is connected.
	 * @see TelnetConnectedEvent
	 * @see Telnet#connect
	 */
	public void connected(TelnetConnectedEvent event) {
		System.out.println("Connected");
	}

	/** 
	 * Invoked when Telnet socket is disconnected. Disconnect can
	 * occur in many circumstances including IOException during socket read/write.
	 * @see TelnetDisconnectedEvent
	 * @see Telnet#disconnect
	 */
	public void disconnected(TelnetDisconnectedEvent event) {
		connected = false;
		System.out.print("Disconnected.  Press enter key to quit.");
	}

	/**
	 * Invoked when Telnet server requests that the Telnet client begin performing specified <code>TelnetOption</code>.
	 * @param event a <code>DoOptionEvent</code>
	 * @see DoOptionEvent
	 * @see TelnetOption
	 */
	public void doOption(DoOptionEvent event) {
		// refuse any options requested by Telnet server
		telnet.sendWontOption(event.getOption());
	}

	/**
	 * Invoked when Telnet server offers to begin performing specified <code>TelnetOption</code>.
	 * @param event a <code>WillOptionEvent</code>
	 * @see WillOptionEvent
	 * @see TelnetOption
	 */
	public void willOption(WillOptionEvent event) {
		// refuse any options offered by Telnet server
		telnet.sendDontOption(event.getOption());
	}

	/**
	 * Invoked when data is received from Telnet server.
	 * @param event a <code>TelnetDataReceivedEvent</code>
	 * @see TelnetDataReceivedEvent
	 */
	public void dataReceived(TelnetDataReceivedEvent event) {
		// print data recevied from Telnet server to console
		System.out.print(event.getData());
	}

	/**
	 * Main method for launching program
	 * @param args program arguments
	 */
	public static void main(String[] args) {
		try {
			reader = new BufferedReader(new InputStreamReader(System.in));

			// prompt user for Telnet server hostname
			System.out.print("Enter Telnet server hostname (e.g. 10.0.0.1): ");
			String hostname = reader.readLine();

			// create new TelnetExample instance
			TelnetExample example = new TelnetExample(hostname);

		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}

}
