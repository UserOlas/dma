/*******************************************************************************
 * 2008-2012 Public Domain
 * Contributors
 * Marco Lopes (marcolopes@netc.pt)
 *******************************************************************************/
package org.dma.java.utils.numeric;

import java.util.Comparator;

public class IntegerSorter implements Comparator<Integer> {

	public int compare(Integer int1, Integer int2){
		return int1.compareTo(int2);
	}


}
