package com.array;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

/**
 * put each element in map as key and its value as frequency. e.g 1=1 2=1
 * 3=2.......
 * 
 * @author ssachdev
 *
 */
public class DuplicateElements {

	static void printRepeating(int arr[], int size) {
		int i;
		System.out.println(("The repeating elements are: \n"));
		for (i = 0; i < size; i++) {
			if (arr[Math.abs(arr[i])] >= 0)
				arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])];
			else
				System.out.println((" " + Math.abs(arr[i])));
		}
	}
	// 2 using map

		 static void MapDup() {
			int[] names = { 1, 3, 2, 4, 3, 5 };

			// Third solution : using Hash table data structure to find duplicates
			System.out.println("Duplicate elements from array using hash table");
			Map<Integer, Integer> nameAndCount = new HashMap<Integer, Integer>();

			// build hash table with count
			for (Integer name : names) {
				Integer count = nameAndCount.get(name);
				if (count == null) {
					nameAndCount.put(name, 1);
				} else {
					nameAndCount.put(name, ++count);
				}
			}

			// Print duplicate elements from array in Java
			Set<Entry<Integer, Integer>> entrySet = nameAndCount.entrySet();
			for (Entry<Integer, Integer> entry : entrySet) {

				if (entry.getValue() > 1) {
					System.out.println("Duplicate element from array : " + entry.getKey());
				}

			}

		}
	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 1, 3, 6, 6,6 };
		int arr_size = arr.length;
		MapDup();
	}
}
