package com.sac.sorting.linear;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.sac.sorting.nsaquer.InsertionSort;

public class BucketSort {
	private static final int DEFAULT_BUCKET_SIZE = 9;

	public static Integer[] sort(Integer[] array) {
		return sort(array, DEFAULT_BUCKET_SIZE);
	}

	public static void main(String[] args) {
		Integer a[] = new Integer[] { 93, 42, 69, 90, 52, 51, 22, 29, 27 };
		System.out.println(Arrays.toString(sort(a)));
	}

	public static Integer[] sort(Integer[] array, int bucketSize) {

		// Determine minimum and maximum values
		Integer minValue = array[0];
		Integer maxValue = array[0];
		for (int i = 1; i < array.length; i++) {
			if (array[i] < minValue) {
				minValue = array[i];
			} else if (array[i] > maxValue) {
				maxValue = array[i];
			}
		}

		// Initialise buckets
		int bucketCount = (maxValue - minValue) / bucketSize + 1;
		List<List<Integer>> buckets = new ArrayList<List<Integer>>(bucketCount);
		for (int i = 0; i < bucketCount; i++) {
			buckets.add(new ArrayList<Integer>());
		}

		// Distribute input array values into buckets
		for (int i = 0; i < array.length; i++) {
			buckets.get((array[i] - minValue) / bucketSize).add(array[i]);
		}

		// Sort buckets and place back into input array
		int currentIndex = 0;
		for (int i = 0; i < buckets.size(); i++) {
			Integer[] bucketArray = new Integer[buckets.get(i).size()];
			bucketArray = buckets.get(i).toArray(bucketArray);
			Arrays.sort(bucketArray);
			for (int j = 0; j < bucketArray.length; j++) {
				array[currentIndex++] = bucketArray[j];
			}

		}
		return array;
	}
}
