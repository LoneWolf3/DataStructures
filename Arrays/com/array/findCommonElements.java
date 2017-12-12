package com.array;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

/**
 * Using hash map will cost O(nlgn). There is a more efficient way to do it in
 * O(n). As the integers are 8 bit so keep an int array of constant size 256.
 * Now, make a pass through first array and use the element of the first array
 * as the index of this array to update the count. Now make a pass to the second
 * array and for each element check if this array contains positive count at the
 * index=element.
 * 
 * @author ssachdev
 * 
 */
public class findCommonElements {

	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 5 };
		int[] b = { 5, 6, 7, 8 };
		findCommonElement(a, b);
	}

	public static void displayCommonElements(int[] a1, int[] a2) {
		Hashtable<Integer, Integer> temp = new Hashtable<Integer, Integer>();
		for (int i : a1)
			temp.put(i, 0);
		for (int i : a2)
			if (temp.containsKey(i))
				System.out.print(i + " ");
	}

	public static Set<Integer> findCommonElement(int[] a, int[] b) {
		int count[] = new int[256];
		Set common = new HashSet();

		for (int i = 0; i < a.length; i++)
			count[a[i]]++;

		for (int i = 0; i < b.length; i++)
			if (count[b[i]] > 0)
				common.add(b[i]);

		return common;
	}

}
