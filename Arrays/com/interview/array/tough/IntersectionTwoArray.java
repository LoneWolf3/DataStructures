package com.interview.array.tough;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * http://stackoverflow.com/questions/17863319/java-find-intersection-of-two-
 * arrays
 * 
 * @author ssachdev
 * 
 */
public class IntersectionTwoArray {
	/**
	 * check for retain all implimentation
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array1 = new int[] { 1, 2, 3 };
		int[] array2 = new int[] { 1, 2, 3 };
		Set<Integer> s1 = new HashSet(Arrays.asList(array1));
		Set<Integer> s2 = new HashSet(Arrays.asList(array2));
		s1.retainAll(s2);

		Integer[] result = s1.toArray(new Integer[s1.size()]);
	}
}
