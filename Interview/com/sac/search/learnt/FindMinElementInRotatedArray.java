/**
 * Do binary search
 * 
 * if mid > high , low = mid +1 
 * 
 * else high = mid 
 * 
 * return low
 */

package com.sac.search.learnt;

public class FindMinElementInRotatedArray {
	static int findMinimum(int arr[], int low, int high) {

		// always restrict the search to the unsorted
		// sub-array. The min is always there.
		while (arr[low] > arr[high]) {
			// find mid of array.
			int mid = (low + high) / 2;
			// decide which sub-array to continue with.
			if (arr[mid] > arr[high]) {
				low = mid + 1;
			} else {
				high = mid;
			}
		}
		return arr[low];
	}

	public static void main(String[] args) {
		int a[] = { 4, 5, 6, 3, 2, 1 };
		int size = a.length;

		System.out.println("\n Minimum element : " + findMinimum(a, 0, size - 1));

	}
}
