package com.array;

import java.util.Arrays;
import java.util.Comparator;

class MyComparator implements Comparator<Integer> {
	public int compare(Integer a, Integer b) {

		String xy = a.toString() + b.toString();
		String yx = b.toString() + a.toString();

		if (xy.compareTo(yx) > 0)
			return -1;
		else
			return 1;
	}
}

public class HighestNumberInrray {

	static void arrangeGivenNumbersToFormTheBiggestNumbers(int[] arr) {
		int n = arr.length;

		Integer[] arr1 = new Integer[n];

		for (int i = 0; i < n; i++)
			arr1[i] = arr[i];

		Arrays.sort(arr1, new MyComparator());
		System.out.println(Arrays.toString(arr1));
		for (int i = 0; i < n; i++)
			arr[i] = arr1[i];

		for (int i = 0; i < n; i++)
			System.out.print(arr[i]);
		System.out.println();
	}

	static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	public static void main(String[] args) {
		int[] arr = { 1, 34, 3 };

		printArray(arr);

		arrangeGivenNumbersToFormTheBiggestNumbers(arr);
	}
}