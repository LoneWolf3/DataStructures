package com.interview.array.tough;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * http://karmaandcoding.blogspot.in/2012/01/find-largest-subset-of-numbers-in-
 * array.html
 * 
 * @author ssachdev
 * 
 */
public class ConsectiveSubarray0000 {
	public static void main(String[] args) {
		int a[] = { 4, -1, 1, 6, 5,7 };
		System.out.println(Arrays.toString(longestConsecutiveSequence(a)));
	}

	public static int[] longestConsecutiveSequence(int[] a) {
		int first = Integer.MAX_VALUE; // the first number of the maximum
										// consecutive sequence
		int length = 0; // the length of the maximum consecutive sequence
		Map<Integer, Integer> table = new HashMap<Integer, Integer>();
		// Iterate over array.
		for (int i : a) {
			if (!table.containsKey(i)) {
				int start = i;
				int end = i;
				// Map contains number +1 as a key then assign that key to end
				// pointer.
				if (table.containsKey(i + 1) && table.get(i + 1) >= i + 1) {
					end = table.get(i + 1);

				}
				// If map contains number- 1 as key then assign start pointer to
				// it.
				if (table.containsKey(i - 1) && table.get(i - 1) <= i - 1) {
					start = table.get(i - 1);
					;
				}
				table.put(start, end);
				table.put(end, start);
				if (end - start + 1 > length) {
					first = start;
					length = end - start + 1;
				}
			}
		}
		System.out.println(table);
		System.out.println(length);
		int[] s = new int[length];
		for (int i = 0; i < length; i++)
			s[i] = first + i;
		return s;
	}
}