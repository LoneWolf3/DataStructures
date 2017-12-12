package com.sac.search.learnt;

public class FindMissingNumber {

	/* getMissingNo takes array and size of array as arguments */
	static int getMissingNo(int a[], int n) {
		int i;
		int x1 = a[0]; /* For xor of all the elements in array */
		int x2 = 1; /* For xor of all the elements from 1 to n+1 */

		for (i = 1; i < n; i++)
			x1 = x1 ^ a[i];

		for (i = 2; i <= n + 1; i++)
			x2 = x2 ^ i;

		return (x1 ^ x2);
	}

	/* program to test above function */
	public static void main(String[] args) {
		int a[] = { 1, 2, 4, 5, 6 };
		System.out.println(getMissingNo(a, 5));
		;
	}

	{

	}
}
