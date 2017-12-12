package com.sac.binarysearch;

/**
 * An element is a majority if it appears more than /2times. Give and algorithm
 * takes an array of element as argument and identifies a majority (if it
 * exists).
 * 
 * @author ssachdev
 *
 */
public class MjortyNumbr {
	int MajorityNum(int[] A, int n) {
		int majNum, count;
		int element = -1;
		count = 0;
		for (int i = 0; i < n; i++) {
			// If the counter is 0 then set the current candidate to majority
			// num and
			// we set the counter to 1.
			if (count == 0) {
				element = A[i];

				count = 1;
			} else if (element == A[i]) {
				// Increment counter If the counter is not 0 and
				// element is same as current candidate.
				count++;
			} else {
				// Decrement counter If the counter is not 0 and
				// element is different from current candidate.
				count--;
			}
		}
		return element;
	}
}
