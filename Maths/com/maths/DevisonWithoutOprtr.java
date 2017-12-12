package com.maths;

/**
 * http://careercup.com/question?id=6332980792393728
 * 
 * @author ssachdev
 *
 */
public class DevisonWithoutOprtr {
	private static int binaryDivide(int dividend, int divisor) {
		int current = 1;
		int denom = divisor;
		// This step is required to find the biggest current number which can be
		// divided with the number safely.
		while (denom <= dividend) {
			current <<= 1;
			denom <<= 1;
		}
		// Since we may have increased the denomitor more than dividend
		// thus we need to go back one shift, and same would apply for current.
		denom >>= 1;
		current >>= 1;
		int answer = 0;
		// Now deal with the smaller number.
		while (current != 0) {
			if (dividend >= denom) {
				dividend -= denom;
				answer |= current;
			}
			current >>= 1;
			denom >>= 1;
		}
		return answer;
	}
}
