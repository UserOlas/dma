/*******************************************************************************
 * 2008-2017 Public Domain
 * Contributors
 * Marco Lopes (marcolopes@netc.pt)
 *******************************************************************************/
package org.dma.eclipse.swt.validation.field;

public interface IFieldRules {

	/** No automatic validation */
	public static final int DEFAULT = 0;

	/** Field will be disabled */
	public static final int READONLY = 1 << 0;

	/** Field cannot be edited */
	public static final int NOTEDITABLE = 1 << 1;

	/** Field cannot be empty / must have elements */
	public static final int NOTEMPTY = 1 << 2;

	/** Field cannot be ZERO / must have selection */
	public static final int NOTZERO = 1 << 3;

	/** Field length must be exact */
	public static final int LIMITMATCH = 1 << 4;


}