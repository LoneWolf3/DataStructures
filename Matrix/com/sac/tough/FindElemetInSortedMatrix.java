package com.sac.tough;



/***
 * Find an element in matrix using stepped linear search
 * 
 * Input
 * 
 * 1 2 3
 * 
 * 4 5 6
 * 
 * 7 8 9
 * 
 * Output 9 exists in matrix.
 * ***/
public class FindElemetInSortedMatrix {

	public static void main(String[] args)

	{
		int[][] a = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		printMatrix(a);

		int elementtoBeFound = 8;

		for (int i = 0; i < a.length; ++i) {
			for (int j = a.length - 1; j > 0; --j) {
				if (elementtoBeFound > a[i][j]) {
					break;
				} else if (elementtoBeFound < a[i][j]) {
				} else {
					System.out.println("Element " + a[i][j]
							+ "found at postion a[" + i + "][" + j + "]");
					break;

				}
			}
		}

	}

	public static void printMatrix(int[][] a) {
		for (int i = 0; i < a.length; ++i) {
			for (int j = 0; j < a.length; ++j) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println("");
		}
	}

}
