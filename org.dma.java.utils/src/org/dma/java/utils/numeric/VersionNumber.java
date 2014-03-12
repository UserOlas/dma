/*******************************************************************************
 * 2008-2014 Public Domain
 * Contributors
 * Marco Lopes (marcolopes@netc.pt)
 *******************************************************************************/
package org.dma.java.utils.numeric;

import org.dma.java.utils.Debug;
import org.dma.java.utils.array.ArrayUtils;

public final class VersionNumber {

	public final int major;
	public final int minor;
	public final int macro;

	public VersionNumber(int major, int minor, int macro){
		this.major = major;
		this.minor = minor;
		this.macro = macro;
	}

	public VersionNumber(String version) {
		String[] array=ArrayUtils.numbers(version.split("\\."));
		major=array.length>=1 ? Integer.valueOf(array[0]) : 0;
		minor=array.length>=2 ? Integer.valueOf(array[1]) : 0;
		macro=array.length>=3 ? Integer.valueOf(array[2]) : 0;
	}


	/**
	 * Checks if the current version is smaller than VERSION
	 * @return
	 * TRUE if the current version is SMALLER;
	 * FALSE if the current version is EQUAL of GREATER
	 */
	public boolean smallerThan(VersionNumber version) {

		Debug.out(version);

		if (major>version.major)
			return false;
		else if (major<version.major)
			return true;
		else if (minor>version.minor)
			return false;
		else if (minor<version.minor)
			return true;
		else if (macro>version.macro)
			return false;
		else if (macro<version.macro)
			return true;

		return false; //equal!

	}


	public boolean equals(VersionNumber version) {
		return major==version.major &&
				minor==version.minor &&
				macro==version.macro;
	}


	public int[] toArray(){
		return new int[]{major,minor,macro};
	}



	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString(){
		return String.valueOf(major)+"."+
			String.valueOf(minor)+"."+
			String.valueOf(macro);
	}

	@Override
	public int hashCode() {
		return toString().hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return hashCode()==obj.toString().hashCode();
	}


}