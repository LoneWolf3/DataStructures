package com.array;

/**
 * While the approach is clear, the implementation could be made a little more
 * readable, in my opinion, by using two helper methods: int[] getMaxThree(int[]
 * arr), which returns the greatest 3 numbers in decreasing order (from greatest
 * to smallest), and int[] getMinTwo(int[] arr), which returns the smallest 2
 * numbers in increasing order (even though it's not strictly necessary). By
 * doing so, the main method is reduced to:
 * 
 * @author ssachdev
 * 
 */
public class MaxProductofThree {

	public static void main(String[] args) {
		int arr[] = { 1, -2, -3, 0, 7, -8, -2 };
		System.out.println("Maximum Sub array product is " + max_prod_three(arr));
	}

	public static int max_prod_three(int[] A) {
		int maxOne = Integer.MIN_VALUE, maxTwo = Integer.MIN_VALUE, maxThree = Integer.MIN_VALUE, minOne = Integer.MAX_VALUE,
				minTwo = Integer.MAX_VALUE;
		int len = A.length;

		for (int i = 0; i < len; i++) {
			if (A[i] >= maxOne) {
				maxThree = maxTwo;
				maxTwo = maxOne;
				maxOne = A[i];
			} else if (A[i] >= maxTwo) {
				maxThree = maxTwo;
				maxTwo = A[i];
			} else if (A[i] >= maxThree) {
				maxThree = A[i];
			}

			if (A[i] <= minOne) {
				minTwo = minOne;
				minOne = A[i];
			} else if (A[i] <= minTwo) {
				minTwo = A[i];
			}
		}

		return Math.max(maxOne * maxTwo * maxThree, maxOne * minOne * minTwo);
	}
}
