package com.sac.search.learnt;

import java.util.Arrays;

public class PushAllZerosBack {
	public static void main(String[] args) {
		int[] arr = { 0, 1, 0, 1, 2 };
		if (arr.length < 2)
			return;
		int point1 = 0;
		int point2 = 1;
		while (point2 < arr.length) {
			if (arr[point1] == 0 && arr[point2] != 0) {
				arr[point1] = arr[point1] ^ arr[point2]; // now a is 6 and b is
															// 4
				arr[point2] = arr[point1] ^ arr[point2]; // now a is 6 but b is
															// 2 (original value
															// of a)
				arr[point1] = arr[point1] ^ arr[point2]; // now a is 4 and b is
															// 2, numbers are
															// swapped
			}

			if (arr[point1] != 0)
				point1++;

			point2++;
		}

		System.out.println(Arrays.toString(arr));
	}
}