package com.sac.tough;

/****
 * 
 * given m x n matrix print all the possible paths top to down.
 * 
 * Example
 * 
 * 1 2 3
 * 
 * 4 5 6
 * 
 * 7 8 9
 * 
 * path for root(0,0) 1 1-4-7
 * 
 * 1-4-8
 * 
 * 1-5-7
 * 
 * 1-5-8
 * 
 * 1-5-9
 * 
 * 
 * 
 * 
 * 
 * @author ssachdev
 * 
 */
public class MatrixPath {

	public static void printpaths(int[][] matrix) {
		int[] path = new int[matrix.length];
		for (int i = 0; i < matrix[0].length; i++)
			printpaths(matrix, path, 0, 0, i);
	}

	private static void printpaths(int[][] matrix, int[] path, int index,
			int row, int column) {
		path[index++] = matrix[row][column];
		row++;
		if (row == matrix.length)
			print(path);
		else if (row < matrix.length) {
			for (int i = column - 1; i <= column + 1; i++)
				if (i > -1 && i < matrix[0].length)
					printpaths(matrix, path, index, row, i);
		}
	}

	private static void print(int[] path) {
		for (int i = 0; i < path.length; i++)
			System.out.print(path[i] + " ");
		System.out.println();
	}

	public static void main(String args[]) {
		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		// MaxPathLenghtTop2Right.printArray(matrix);
		System.out.println("==============================");
		printpaths(matrix);
	}
}