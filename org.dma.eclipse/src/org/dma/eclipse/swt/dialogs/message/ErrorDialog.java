/*******************************************************************************
 * 2008-2014 Public Domain
 * Contributors
 * Marco Lopes (marcolopes@netc.pt)
 *******************************************************************************/
package org.dma.eclipse.swt.dialogs.message;

import org.dma.java.array.ArrayUtils;
import org.dma.java.array.MessageList;

public class ErrorDialog extends CustomDialog {

	/*
	 * Error
	 */
	public static boolean open(String operation, String...message) {
		return open(operation, ArrayUtils.concat(message,"\n"), TYPE.ERROR);
	}

	public static boolean open(String operation, MessageList list) {
		return open(operation, list.toArray());
	}

	public static boolean open(String message) {
		return open(null, message);
	}

	public static boolean open(MessageList list){
		return open(null, list.toArray());
	}


}