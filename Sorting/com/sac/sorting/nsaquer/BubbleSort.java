package com.sac.sorting.nsaquer;

import java.util.Arrays;

/**
 * Scan the array, swapping adjacent pair of elements if they are not in
 * relative order. This bubbles up the largest element to the end. Scan the
 * array again, bubbling up the second largest element. Repeat until all
 * elements are in order.
 * 
 * 
 * @author ssachdev
 *
 */
public class BubbleSort {

	public static void bubbleSort(int[] data) {
		for (int i = data.length - 1; i >= 0; i--) {
			// bubble up
			for (int j = 0; j <= i - 1; j++) {
				if (data[j] > data[j + 1]) {
					int temp;
					temp = data[j];
					data[j] = data[j + 1];
					data[j + 1] = temp;
				}
			}

		}
	}

	public static void main(String[] args) {
		int[] input = { 4, 2, 9, 6, 1, 3 };
		bubbleSort(input);
		System.out.println(Arrays.toString(input));

	}

}