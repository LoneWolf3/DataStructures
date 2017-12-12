package com.sac.strings.Tough;

import java.util.HashMap;
import java.util.Map;

/**
 * http://www.careercup.com/question?id=5389078581215232 Given two strings tells
 * if anagram of first is substring of another
 * 
 * anagram is word wich means order of words does not matter.
 * 
 * ALGO
 * 
 * Create smallByteArray map of characters for string 1 using increment and
 * count.
 * 
 * Iterate over second string, and find character mapping in map of chars using
 * containsAndUpdate()
 * 
 * If found increment index++ and current++
 * 
 * if current++ == str.lenght return true.
 * 
 */
public class AnagramOfFirstAsSubstring {

	public static void main(String[] args) {
		String str1 = "DCBA";
		String str2 = "ABC";
		hasAnagramSubstring(str1, str2);
	}

	public static void hasAnagramSubstring(String largeString, String smallString) {
		int largeCount[] = new int[128];
		int smallCount[] = new int[128];

		for (int i = 0; i < smallString.length(); i++) {
			largeCount[largeString.charAt(i)]++;
			smallCount[smallString.charAt(i)]++;
		}

		for (int i = smallString.length(); i < largeString.length(); i++) {
			if (compareArr(largeCount, smallCount) == true)
				System.out.print((i - smallString.length()) + " ");

			largeCount[(int)largeString.charAt(i)] = largeCount[(int)largeString.charAt(i)] + 1;
			largeCount[(int)largeString.charAt(i - smallString.length())]=largeCount[(int)largeString.charAt(i - smallString.length())]-1;
		}

		if (compareArr(largeCount, smallCount) == true) {
			System.out.print((largeString.length() - smallString.length()) + " ");
		}
	}

	static boolean compareArr(int[] largeCount, int[] smallCount) {
		for (int i = 0; i < largeCount.length; i++) {
			if (largeCount[i] != smallCount[i])
				return false;
		}
		return true;
	}

}
