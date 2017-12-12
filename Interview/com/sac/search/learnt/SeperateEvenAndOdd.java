package com.sac.search.learnt;

import java.util.Arrays;

/**
 * 12, 34, 45, 9, 8, 10, 3
 * Given an array [ ],write a function that segregates even and odd numbers.
 * The functions should put all even numbers first, and then odd numbers.
 * 
 * Initialize two index variables left and right: left =0; right = n-1;)
 * 
 * 2) Keep incrementing left index until we see an odd number.
 * 
 * 3) Keepdecrementing right index until we see an even number.
 * 
 * 4) Ifleft<right then swap a[left] and a[right]
 * 
 * 5)instead of modulus operator use equal to 0 and 1 for 0,1 sorting.
 * 
 * @author ssachdev
 *
 */
public class SeperateEvenAndOdd {
	static void seperate(int A[], int n) {
		/* Initialize left and right indexes */
		int left = 0, right = n - 1;
		while (left < right) {
			/* Increment left index while we see 0 at left */
			while (A[left] % 2 == 0 && left < right)
				left++;
			/* Decrement right index while we see 1 at right */
			while (A[right] % 2 == 1 && left < right)
				right--;
			if (left < right) {
				/* Swap A[left] and A[right] */
				swap(A[left], A[right]);
				left++;
				right--;
			}
		}
	}

	private static void swap(int low, int high) {
		int temp = low;
		low = high;
		high = temp;
	}

	public static void main(String[] args) {
		int[] a = { 12, 34, 45, 9, 8, 10, 3 };
		int n = a.length;
		seperate(a, n);
		System.out.println(Arrays.toString(a));
	}
}
