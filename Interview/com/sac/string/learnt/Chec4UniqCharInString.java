package com.sac.string.learnt;
/**
 * Algo
 * 
 * Create a boolean array and enter every char in it.
 * if array contains chr then it returns true else false.
 * @author ssachdev
 *
 */
public class Chec4UniqCharInString {
	/** assume char set is ASCII ***/
	public static boolean isUniqueChars2(String str) {
		boolean[] char_set = new boolean[100];
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i);
			if (char_set[val])
				return false;
			char_set[val] = true;
		}
		return true;
	}

	public static void main(String[] args) {
		String s = "AB";
		System.out.println(isUniqueChars2(s));
	}
}
