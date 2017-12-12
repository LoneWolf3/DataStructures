package com.sac.search.learnt;

/**
 *
 * Do binary search
 *
 * ex 1, 2, 2, 2, 2, 2, 5, 7, 7
 * 
 * if mid == number and mid-1 < number return mid
 *
 * if mid < number , low = mid+1
 *
 *
 * if mid > number , high = mid -1
 */
public class FirstOccurrenceOfNumberInSortedArray {

	public int firstOccurrence(int input[], int x) {
		int low = 0;
		int high = input.length - 1;

		while (low <= high) {
			int middle = (low + high) / 2;
			if (input[middle] == x &&  input[middle - 1] < x) {
				return middle;
			} else if (input[middle] < x) {
				low = middle + 1;
			} else {
				high = middle - 1;
			}
		}
		return -1;
	}

	public static void main(String args[]) {
		FirstOccurrenceOfNumberInSortedArray fos = new FirstOccurrenceOfNumberInSortedArray();
		int input[] = { 1, 2, 2, 2, 2, 2, 5, 7, 7 };
		System.out.println(fos.firstOccurrence(input, 7));
	}

}
