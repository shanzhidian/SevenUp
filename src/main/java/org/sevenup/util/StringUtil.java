package org.sevenup.util;

/**
 * 
 * @author steven
 * 
 */
public class StringUtil {
	public static boolean isEmpty(String theString) {
		boolean isEmpty = true;
		if ((null != theString) && (theString.trim().toString().length() > 0)) {
			isEmpty = false;
		}
		return isEmpty;
	}

	public static boolean isNotEmpty(String theString) {
		boolean isNotEmpty = true;
		if (theString == null || theString.trim().equals("")) {
			isNotEmpty = false;
		}
		return isNotEmpty;
	}
}
