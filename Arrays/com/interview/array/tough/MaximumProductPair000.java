package com.interview.array.tough;

/**
 * An Efficient Solution can solve the above problem in single traversal of
 * input array. The idea is to traverse the input array and keep track of
 * following four values. a) Maximum positive value b) Second maximum positive
 * value c) Maximum negative value i.e., a negative value with maximum
 * Math.absolute value d) Second maximum negative value. At the end of the loop,
 * compare the products of first two and last two and print the maximum of two
 * products. Below is C++ implementation of this idea.
 * 
 * http://www.geeksforgeeks.org/return-a-pair-with-maximum-product-in-array-of-
 * integers/
 * 
 * @author ssachdev
 * 
 */
public class MaximumProductPair000 {
	static void maxProduct(int arr[], int n) {
		if (n < 2) {
			System.out.println("No pairs exists");
			return;
		}

		if (n == 2) {
			System.out.println(arr[0] + " " + arr[1]);
			return;
		}

		// Iniitialize maximum and second maximum
		int posa = Integer.MIN_VALUE, posb = Integer.MIN_VALUE;

		// Iniitialize minimum and second minimum
		int nega = Integer.MIN_VALUE, negb = Integer.MIN_VALUE;

		// Traverse given array
		for (int i = 0; i < n; i++) {
			// Update maximum and second maximum if needed
			if (arr[i] > posa) {
				posb = posa;
				posa = arr[i];
			} else if (arr[i] > posb)
				posb = arr[i];

			// Update minimum and second minimum if needed
			if (arr[i] < 0 && Math.abs(arr[i]) > Math.abs(nega)) {
				negb = nega;
				nega = arr[i];
			} else if (arr[i] < 0 && Math.abs(arr[i]) > Math.abs(negb))
				negb = arr[i];
		}

		if (nega * negb > posa * posb)
			System.out.println("Max product pair is {" + nega + ", " + negb + "}");
		else
			System.out.println("Max product pair is {" + posa + ", " + posb + "}");
	}

	// Driver program to test above function
	public static void main(String[] args) {
		int arr[] = { 1, 9, -3, -9, -6 };
		int n = arr.length;
		maxProduct(arr, n);
	}
}
