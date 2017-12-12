package com.sac.string.learnt;

/**
 * Check if char is digit if yes store in digit and add it to sum
 */

public class SumDigits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "1a3sdf4a5fggt";
		char[] arr = s.toCharArray();
		int sum = 0;
		String localDigit = "";
		for (int i = 0; i < arr.length; i++) {
			// check if char is digigt
			if (Character.isDigit(arr[i])) {
				localDigit = localDigit + arr[i];

			} else {
				if (localDigit != "")
					sum = sum + Integer.parseInt(String.valueOf(localDigit));
				localDigit = "";
			}
		}
		System.out.println(sum);
	}

}