package com.sac.string.learnt;

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class RemoveDuplicateFromS1andS2 {
	static String removeDirtyChars(String s1, String s2) {
		// Create a boolean array
		boolean bit[] = new boolean[256];
		// Assign true for all the charcters present in string 2
		for (int i = 0; i < s2.length(); i++)
			bit[s2.charAt(i)] = true;

		char[] str = new char[s1.length()];

		// loop through all the charcters of string 1 and skip all the charcters
		// that is prent in boolean array created above
		for (int i = 0 , j = 0; i < s1.length(); i++)
			if (bit[s1.charAt(i)] == false) {
				str[j] = s1.charAt(i);
				j++;
			}
		return new String(str);
	}

	public static void main(String[] args) throws java.lang.Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s1 = "saachin";
		String s2 = "bcdx";
		s1 = removeDirtyChars(s1, s2);
		System.out.println(s1);
	}
}