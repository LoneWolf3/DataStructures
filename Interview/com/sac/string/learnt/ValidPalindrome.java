package com.sac.string.learnt;

/**
 **
 * 1) Get two pointers start and end
 * 
 * 2)If char at start is not alphanumeric start ++;
 * 
 * 3) If char at end is not alphanumeric end--;
 * 
 * 4)main logic char(start) != char(end) return false ;
 * 
 * 5)start ++ , end --;
 */
public class ValidPalindrome {

	public static void main(String[] args) {
		System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
	}

	public static boolean isPalindrome(String s) {
		int start = 0;
		int end = s.length() - 1;
		// Iterate through string
		while (start < end) {
			// check if it is alpha numeric then increemt
			if (!isAlphaNum(s.charAt(start))) {
				start++;
				// check if end is alpha numeric increment
			} else if (!isAlphaNum(s.charAt(end))) {
				end--;
			} else {

				// main logic if end and start are not same return false.
				if (Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) {
					return false;
				}
				start++;
				end--;
			}
		}
		return true;
	}

	private static boolean isAlphaNum(char ch) {
		if ((ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
			return true;
		}
		return false;
	}
}