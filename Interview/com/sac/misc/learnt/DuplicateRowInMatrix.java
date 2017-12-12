package com.sac.misc.learnt;

import java.util.Arrays;

/***
 * 
 * Remove a duplicate row from matrix.
 * 
 * Input
 * 
 * 1 1 0 0 0 1
 * 
 * 1 0 1 0 0 1
 * 
 * 1 1 0 0 0 1
 * 
 * 1 1 1 1 1 1
 * 
 * Output
 * 
 * 1 1 0 0 0 1
 * 
 * 1 0 1 0 0 1
 * 
 * 1 1 1 1 1 1
 * 
 * ALGO Compute hash code of each row and then eliminate the row that has same
 * hash code.
 * 
 * .hashcode gives the hashcode of object we need to convert it in string .
 * 
 * ArrayObject.toString() will give haxadecimal repsresentation of hash code
 * hence will be diffrent for same row.
 * 
 * Array.toString method will use integer values to create hash code and hence
 * same row has same hash code.
 * 
 * @author ssachdev
 * 
 */
public class DuplicateRowInMatrix {

	public static void main(String[] args) {
		int[][] a = new int[][] { { 1, 1, 0 }, { 0, 1, 1 }, { 1, 1, 0 },
				{ 1, 1, 1 } };
		int[] binaryToDecimal = new int[5];
		for (int i = 0; i < a.length; ++i) {
			binaryToDecimal[i] = Arrays.toString(a[i]).hashCode();

		}
		for (int i = 0; i < binaryToDecimal.length; ++i) {
			System.out.println(binaryToDecimal[i]);
		}
	}

}
