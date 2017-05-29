/*******************************************************************************
 * 2008-2017 Public Domain
 * Contributors
 * Marco Lopes (marcolopes@netc.pt)
 *******************************************************************************/
package org.dma.eclipse.ui;

import java.io.PrintStream;

import org.dma.java.util.Debug;

import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleManager;
import org.eclipse.ui.console.MessageConsole;

public class DebugConsole {

	private final static IConsoleManager manager=ConsolePlugin.getDefault().getConsoleManager();

	private final MessageConsole console;
	private final PrintStream stream;
	private final PrintStream systemOut=System.out; // standard output stream
	private final PrintStream systemErr=System.err; // error output stream

	public DebugConsole(String name) {
		Debug.out();
		this.console=new MessageConsole(name, null);
		this.stream=new PrintStream(console.newMessageStream());
		manager.addConsoles(new IConsole[]{console});
	}


	public void start() {
		System.setOut(stream);
		System.setErr(stream);
	}


	public void stop() {
		System.setOut(systemOut);
		System.setErr(systemErr);
	}


	public void openConsole() {
		start();
		manager.showConsoleView(console);
	}


	public void closeConsole() {
		stop();
		manager.removeConsoles(new IConsole[]{console});
	}



	/*
	 * Getters and setters
	 */
	public MessageConsole getConsole() {
		return console;
	}


}