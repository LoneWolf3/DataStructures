package com.sac.string.learnt;

/**
 * Start a loop from last char till 0; Create a reverse string using = { rev =
 * rev+str.charat(len-1)} if rev.equal(str) then it is pallindrom
 * 
 * @author ssachdev
 *
 */
public class CheckIfStringIspallindrome {

	public static final String reverseStringWithXOR(String string) {
	        char[] array = string.toCharArray();
	        int length = array.length;
	        int half = (int) Math.floor(array.length / 2);
	        for (int i = 0; i < half; i++) {
	            array[i] ^= array[length - i - 1];
	            array[length - i - 1] ^= array[i];
	            array[i] ^= array[length - i - 1];
	        }
	        return String.valueOf(array);
	    }

	public static void main(String[] args) {
		String a = "madam";

		String b;
		String reverse = "";
		for (int len = a.length(); len - 1 >= 0; len--) {
			reverse = reverse + a.charAt(len - 1);
		}
		System.out.println(reverse.equals(a));

	}

}
