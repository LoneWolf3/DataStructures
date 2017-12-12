package com.interview.array.tough;

/**
 * 
 http://prismoskills.appspot.com/lessons/Arrays/Divide_into_two_equal_sums.jsp
 * 
 * @author ssachdev
 * 
 */
import java.util.Arrays;

public class TwoSetsWithEqualSums {

	public static void main(String args[]) {
		int arr[] = { 2, 3, 1, 4 };
		int set1[] = new int[(1 + arr.length) / 2];
		int set2[] = new int[(1 + arr.length) / 2];

		divideInEqualSums(arr, set1, set2);
	}

	private static void divideInEqualSums(int[] arr, int[] set1, int[] set2) {
		int setSize = set1.length;
		Arrays.sort(arr);
		int pos1 = 0;
		int pos2 = 0;
		int i = arr.length - 1;
		int sum1 = 0;
		int sum2 = 0;
		while (pos1 < setSize && pos2 < setSize) {
			if (sum1 < sum2) {
				set1[pos1] = arr[i];
				pos1++;
				sum1 += arr[i];
			} else {
				set2[pos2] = arr[i];
				pos2++;
				sum2 += arr[i];
			}
			i--;
		}

		while (i >= 0) {
			if (pos1 < setSize)
				set1[pos1++] = arr[i];
			else
				set2[pos2++] = arr[i];
			i--;
		}

		printArrayWithSum(arr);
		printArrayWithSum(set1);
		printArrayWithSum(set2);
	}

	static void printArrayWithSum(int arr[]) {
		int sum1 = 0;
		for (int i = 0; i < arr.length; i++) {
			sum1 += arr[i];
			System.out.print(arr[i] + ",");
		}
		System.out.println(" = " + sum1);
	}
}
