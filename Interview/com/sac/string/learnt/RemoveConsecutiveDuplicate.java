package com.sac.string.learnt;

/**
 * Remove consecutive duplicate characters e.g AABBCDDAAB -> ABCDAB ABBBCCD ->
 * ABCD Test cases Empty string all unique all duplicates duplicates at certain
 * different places
 */
public class RemoveConsecutiveDuplicate {

	public String removeDuplicates(String s) {

		s = s + " "; // Adding a space at the end of the word
		int l = s.length(); // Finding the length of the word
		String ans = ""; // Variable to store the final result
		char ch1, ch2;

		for (int i = 0; i < l - 1; i++) {
			ch1 = s.charAt(i); // Extracting the first character
			ch2 = s.charAt(i + 1); // Extracting the next character

			// Adding the first extracted character to the result if the current
			// and the next characters are different

			if (ch1 != ch2) {
				ans = ans + ch1;
			}
		}
		return ans;
	}

	public static void main(String args[]) {
		String str = "sacahhin";
		char input[] = str.toCharArray();
		RemoveConsecutiveDuplicate rcd = new RemoveConsecutiveDuplicate();
		System.out.println(rcd.removeDuplicates(str));
	}
}
