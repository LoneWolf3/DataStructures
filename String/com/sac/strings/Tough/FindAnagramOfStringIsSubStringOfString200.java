package com.sac.strings.Tough;


import java.util.Arrays;

public class FindAnagramOfStringIsSubStringOfString200 {
	public static void main(String args[]) {
		String a = "ba";
		String b = "abcdefg";
		System.out.println(substringAnagram(a, b));
	}

	static boolean substringAnagram(String a, String b) {
		int[] table = new int[256];
		Arrays.fill(table, 0);
		int[] orig_table = new int[256];
		Arrays.fill(orig_table, 0);

		for (int i = 0; i < a.length(); i++) {
			table[a.charAt(i)]++;
			orig_table[a.charAt(i)]++;
		}

		int count = 0;
		for (int i = 0; i < b.length(); i++) {
			if (table[b.charAt(i)] != 0) {
				table[b.charAt(i)]--;
				count++;
				if (count == a.length()) { // match found
					return true;
				}
			} else if (count > 0) { // reset
				count = 0;
				table = orig_table.clone();
			}

			// else do nothing

		}
		return false;
	}
}