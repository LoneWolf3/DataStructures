package com.array;

import java.util.Arrays;
import java.util.BitSet;

/*****
 * This program will find missing number in an array user need to enter the
 * number of elements in array.
 * 
 * Divide and conquer with time complexity O(lgn)
 * 
 * 
 * @author ssachdev
 * 
 */
public class MissingNumberMoreThen1 {
	public static void main(String[] args) {
		// In the below code: Array Size = 8 and n = 10.
		// So 2 missing numbers!
		int n = 10;
		int[] intArr = new int[] { 3, 1, 2, 5, 4, 7, 10, 8 };

		
		int[] missingNums = findMissingNumber(intArr, n);

		for (int i = 0; i < missingNums.length; i++) {
			System.out.println("Missing Number " + (i + 1) + " : "
					+ missingNums[i] + "  ");
		}
	}

	private static int[] findMissingNumber(int[] intArray, int totalNum) {
		int numOfMissingNums = totalNum - intArray.length;
		BitSet bitSet = new BitSet();

		for (int i : intArray) {
			bitSet.set(i - 1);
		}

		int[] missingNums = new int[numOfMissingNums];
		for (int k = 0; k < numOfMissingNums; k++) {
			int index = (k == 0) ? 0 : (missingNums[k - 1]);
			missingNums[k] = (bitSet.nextClearBit(index) + 1);
		}

		return missingNums;
	}
}