package com.sac.misc.learnt;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two integers �n� and �m�, find all the stepping numbers in range [n,
 * m]. A number is called stepping number if all adjacent digits have an
 * absolute difference of 1. 321 is a Stepping Number while 421 is not.
 * 
 * Examples:
 * 
 * 
 * Input : n = 10, m = 15 Output : 10, 12
 * 
 * @author ssachdev
 * 
 */
// A Java program to find all the Stepping Number in [n, m]
public class SteepingNumber {
	// This Method checks if an integer n
	// is a Stepping Number
	public static boolean isStepNum(int n) {
		// Initalize prevDigit with -1
		int prevDigit = -1;

		// Iterate through all digits of n and compare
		// difference between value of previous and
		// current digits
		while (n > 0) {
			// Get Current digit
			int curDigit = n % 10;

			// Single digit is consider as a
			// Stepping Number
			if (prevDigit != -1) {
				// Check if absolute difference between
				// prev digit and current digit is 1
				if (Math.abs(curDigit - prevDigit) != 1)
					return false;
			}
			n /= 10;
			prevDigit = curDigit;
		}
		return true;
	}

	// A brute force approach based function to find all
	// stepping numbers.
	public static void displaySteppingNumbers(int n, int m) {
		// Iterate through all the numbers from [N,M]
		// and check if it is a stepping number.
		for (int i = n; i <= m; i++)
			if (isStepNum(i))
				System.out.print(i + " ");
	}

	// Driver code
	public static void main(String args[]) {
		int n = 0, m = 21;

		// Display Stepping Numbers in the range [n,m]
		displaySteppingNumbers(n, m);
	}
}