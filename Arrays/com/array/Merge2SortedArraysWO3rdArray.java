package com.array;

/**
 * Algorithm to merge two sorted arrays without additional array, provided one
 * of the two arrays has the size of the combination sizes of two arrays
 * 
 * @author Sachin
 * 
 */
public class Merge2SortedArraysWO3rdArray {

	public void mergeArrays(int[] aArr, int aSize, int[] bArr, int bSize,
			int[] cArr) {
		// pointer to end of the first sorted array
		int aIdx = aArr.length - 1;
		// pointer to end of the second sorted array  bArr)
		int bIdx = bArr.length - 1;
		// pointer to end of the extra array.
		int cIdx = cArr.length - 1;

		/**
		 * whichever is higher in two arrays, place that element in last
		 * position of the another array.
		 * Length of that array is reduced whose value is greater.
		 * 
		 */
		while (aIdx >= 0 && bIdx >= 0) {
			if (aArr[aIdx] > bArr[bIdx]) {
				cArr[cIdx--] = aArr[aIdx--];
			} else {
				cArr[cIdx--] = bArr[bIdx--];
			}
		}

	}

	public static void main(String[] args) {
		Merge2SortedArraysWO3rdArray mergeArrays = new Merge2SortedArraysWO3rdArray();
		int[] aArr = { 0,1,2,3,4,5,6,7,8 };
		int[] bArr = { 0,1,2 };
		int[] cArr = new int[(aArr.length + bArr.length)-1];
		mergeArrays.mergeArrays(aArr, aArr.length, bArr, bArr.length, cArr);

		for (int i : cArr) {
			System.out.print(" " + i);
		}
	}
}