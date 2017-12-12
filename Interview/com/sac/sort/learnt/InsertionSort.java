package com.sac.sort.learnt;

/**
 * Take the first element as a sorted sub-array.
 * 
 * Insert the second element into the sorted sub-array (shift elements if
 * needed).
 * 
 * Insert the third element into the sorted sub-array. Repeat until all elements
 * are inserted.
 * 
 * @author ssachdev
 *
 */

public class InsertionSort {
	public static void insertionSort(Integer[] bucketArray) {
		for (int i = 1; i < bucketArray.length; i++) {
			// a temporary copy of the current element
			int tmp = bucketArray[i];
			int j;

			// find the position for insertion
			for (j = i; j > 0; j--) {
				if (bucketArray[j - 1] < tmp)
					break;
				// shift the sorted part to right
				bucketArray[j] = bucketArray[j - 1];
			}

			// insert the current element
			bucketArray[j] = tmp;
		}
	}
}
