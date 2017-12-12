package com.sac.tough;

import java.util.Stack;

/**
 * http://n00tc0d3r.blogspot.in/2013/04/maximum-rectangle.html?view=classic
 * 
 * @author ssachdev
 * 
 */
public class LargestSubMatrix1 {

	private int maxRectangle(int[] histogram) {
		Stack<Integer> ss = new Stack<Integer>();
		int maxArea = 0, i = 0;
		while (i < histogram.length) {
			if (ss.isEmpty() || histogram[i] >= histogram[ss.peek()]) {
				ss.push(i++);
			} else {
				maxArea = Math.max(maxArea, histogram[ss.pop()]
						* (ss.isEmpty() ? i : (i - ss.peek() - 1)));
			}
		}
		while (!ss.isEmpty()) {
			maxArea = Math.max(maxArea,
					histogram[ss.pop()] * (ss.isEmpty() ? i : (i - ss.peek() - 1)));
		}
		return maxArea;
	}

	public int maximalRectangle(char[][] matrix) {
		int rows = matrix.length;
		if (rows == 0)
			return 0;
		int columns = matrix[0].length;
		// lenTable[i][j] = k means matrix[i][j] - matrix[i][j+k-1] are all
		// '1's.
		int[][] lenTable = new int[rows][columns];
		// initialize the table
		for (int h = 0; h < columns; ++h) {
			if (matrix[0][h] == '1')
				lenTable[0][h] = 1;
		}
		for (int w = 1; w < rows; ++w) {
			for (int h = 0; h < columns; ++h) {
				if (matrix[w][h] == '0')
					continue;
				lenTable[w][h] = lenTable[w - 1][h] + 1;
			}
		}
		// find the max rect area
		int maxArea = 0;
		for (int i = 0; i < rows; ++i) {
			maxArea = Math.max(maxArea, maxRectangle(lenTable[i]));
		}
		return maxArea;
	}
}
