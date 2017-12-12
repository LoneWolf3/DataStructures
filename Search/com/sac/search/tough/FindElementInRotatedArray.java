package com.sac.search.tough;

public class FindElementInRotatedArray {
	static int findElementInSortedRotatedArray(int A[], int N, int key) {
		int L = 0;
		int R = N - 1;

		while (L <= R) {
			// Avoid overflow, same as M=(L+R)/2
			int M = (L + R) / 2;
			if (A[M] == key)
				return M;

			// the bottom half is sorted
			if (A[L] <= A[M]) {
				if (A[L] <= key && key < A[M])
					R = M - 1;
				else
					L = M + 1;
			}
			// the upper half is sorted
			else {
				if (key <= A[R] && A[M] < key)
					L = M + 1;
				else
					R = M - 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {

		int a[] = { 9, 8, 7, 6 , 1, 2,  4,};
		int size = a.length;

		int e = findElementInSortedRotatedArray(a, size, 2);
		System.out.println("\nElement found at postion : " + e);
	}
}
