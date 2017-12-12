package com.sac.selections;

public class HeapSelect {
	/***********************************************************************
	 * Author: Isai Damier Title: Find Kth Greatest Value Project: geekviewpoint
	 * Package: algorithms
	 *
	 * Statement: Given a list of values, find the kth top score. Assume the
	 * highest score is the 1st not the 0th.
	 *
	 * Time Complexity: O(n log n)
	 * 
	 * Sample Input: {21,3,34,5,13,8,2,55,1,19}; 4 Sample Output: 19
	 * 
	 * Technical Details: This is a selection algorithm, where the task is to
	 * select an elite out of a group. In the sample input, for instance, we are
	 * to select the 4th greatest number in the list; which happens to be 13
	 * since 55, 34, and 21 are all greater than 13.
	 * 
	 * Generally, selection algorithms are modified sort algorithms; where
	 * instead of sorting the whole list, we sort up to the kth value. Hence, a
	 * selection algorithm is bounded by whatever sort algorithm is used to
	 * implement it.
	 * 
	 * Here for example we are using heapselect to find the kth largest value.
	 * Consequently, this algorithm is bounded by heapsort; leading to a worse
	 * case time complexity of O( n log n).
	 * 
	 * Note: Finding the kth largest is essentially the same as finding the kth
	 * smallest.
	 * 
	 * If you really want to reduce the call to moveDown() you can use the
	 * following code instead:
	 * 
	 * int limit = last - k; int i = last; for (; i > limit; i--) if (A[0] >
	 * A[i]) { swap(A, 0, i); moveDown(A, 0, i - 1); } return A[i+1];
	 * 
	 **********************************************************************/
	public int heapselect(int A[], int k) {
		int last = A.length - 1;
		// convert array to heap in O(n)
		int youngestParent = last / 2;// l = 2*p+1: p=(l-1)/2
		for (int i = youngestParent; i >= 0; i--) {
			moveDown(A, i, last);
		}
		// sort up to k (i.e. find the kth)
		int limit = last - k + 1;
		for (int i = last; i > limit; i--) {
			if (A[0] > A[i]) {
				swap(A, 0, i);
				moveDown(A, 0, i - 1);
			}
		}
		return A[0];
	}// findKthLargest(int[], int)

	private void moveDown(int[] A, int first, int last) {
		int largest = 2 * first + 1;
		while (largest <= last) {
			if (largest < last && A[largest] < A[largest + 1]) {
				largest++;
			}
			if (A[first] < A[largest]) {
				swap(A, first, largest);
				first = largest;
				largest = 2 * first + 1;
			} else {
				return;
			}
		}
	}

	private void swap(int[] G, int x, int y) {
		int tmp = G[x];
		G[x] = G[y];
		G[y] = tmp;
	}

}
