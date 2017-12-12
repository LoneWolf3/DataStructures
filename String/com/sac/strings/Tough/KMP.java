
package com.sac.strings.Tough;

/**
 * Date 09/22/2014
 * 
 * @author tusroy
 * 
 *         Do pattern matching using KMP algorithm
 * 
 *         Runtime complexity - O(m + n) where m is length of text and n is
 *         length of pattern Space complexity - O(n)
 */
public class KMP {

	/**
	 * Slow method of pattern matching
	 */
	public boolean hasSubstring(char[] text, char[] pattern) {
		int i = 0;
		int j = 0;
		int k = 0;
		while (i < text.length && j < pattern.length) {
			if (text[i] == pattern[j]) {
				i++;
				j++;
			} else {
				j = 0;
				k++;
				i = k;
			}
		}
		if (j == pattern.length) {
			return true;
		}
		return false;
	}

	/**
	 * Compute temporary array to maintain size of suffix which is same as
	 * prefix Time/space complexity is O(size of pattern)
	 */
	private int[] computeTemporaryArray(char pattern[]) {
		int[] temp = new int[pattern.length];
		int j = 0;
		for (int i = 1; i < pattern.length;) {
			if (pattern[i] == pattern[j]) {
				temp[i] = j + 1;
				j++;
				i++;
			} else {
				if (j != 0) {
					j = temp[j - 1];
				} else {
					temp[i] = 0;
					i++;
				}
			}
		}
		return temp;
	}

	/**
	 * KMP algorithm of pattern matching.
	 */
	public boolean match(char[] text, char[] pattern) {

		int temp[] = computeTemporaryArray(pattern);
		int i = 0;
		int j = 0;
		while (i < text.length && j < pattern.length) {
			if (text[i] == pattern[j]) {
				i++;
				j++;
			} else {
				if (j != 0) {
					j = temp[j - 1];
				} else {
					i++;
				}
			}
		}
		if (j == pattern.length) {
			return true;
		}
		return false;
	}

	public static void main(String args[]) {

		String str = "abxabcabcaby";
		String subString = "abcaby";
		KMP ss = new KMP();
		boolean result = ss.match(str.toCharArray(), subString.toCharArray());
		System.out.print(result);

	}
}
