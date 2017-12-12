package com.sac.tough;

/****
 * first add the k columns of each row like in robinkarp resulting in (m-k+1)*n;
 * now add the k rows of each column resulting in (m-k+1)(n-k+1); find the
 * highest element indx; that will be the starting index of k*k matrix with
 * highest sum O(m*n)
 * 
 * 
 * 3 2 1
 * 
 * 5 6 4
 * 
 * 1 2 3
 * 
 * sum columns
 * 
 * 5 3
 * 
 * 11 10
 * 
 * 3 5
 * 
 * sum rows
 * 
 * 16 13
 * 
 * 14 15
 * 
 * find max -> 16
 * 
 * 
 * 
 * @author ssachdev
 * 
 */

public class MaximumSubmatrixInMatrix {

	public static void main(String[] args) {
		int[][] a = { { 3, 2, 1 }, { 5, 6, 4 }, { 1, 2, 3 } };
		findMaximumSubMatrix(a);
	}

	private static void findMaximumSubMatrix(int[][] a) {
		int windowSize = 2;
		int[][] columnMatrix = generateColumnMatrix(windowSize, a);
		int[][] rowMatrix = generateRowMatrix(windowSize, columnMatrix);
		getMaxSubMatrix(rowMatrix, a);
	}

	private static void getMaxSubMatrix(int[][] rowMatrix, int[][] a) {
		int[] maxIndex = getMaxNumberIndexinMatrix(rowMatrix);
		printSubMatrix(maxIndex, a);
	}

	private static void printSubMatrix(int[] maxIndex, int[][] a) {
		System.out.println("--------------Max Sub Matrix IS----------------");
		for (int i = 0; i < 2; ++i) {
			for(int j=0;j<2;++j){
				System.out.print(a[maxIndex[0]+i][maxIndex[1] + j]);
				System.out.print(" ");
			
			}
			System.out.println();
			
		}

	}

	private static int[][] generateRowMatrix(int windowSize,
			int[][] columnMatrix) {
		int[][] rowMatrix = new int[2][2];
		for (int i = 0; i < columnMatrix.length - 1; ++i) {
			for (int j = 0; j < windowSize; j++) {

				rowMatrix[i][j] = columnMatrix[i][j] + columnMatrix[i + 1][j];
			}
		}
		System.out.println("--------Row Matrix------");
		System.out.println();
	//	MaxPathLenghtTop2Right.printArray(rowMatrix);
		return rowMatrix;

	}

	private static int[][] generateColumnMatrix(int windowSize, int[][] a) {
		int[][] columnMatrix = new int[3][2];
		for (int i = 0; i < a.length; ++i) {
			for (int j = 0; j < windowSize; j++) {
				columnMatrix[i][j] = a[i][j] + a[i][j + 1];

			}
		}
		System.out.println("--------Column Matrix------");
		System.out.println();
		//MaxPathLenghtTop2Right.printArray(columnMatrix);
		return columnMatrix;
	}

	public static int[] getMaxNumberIndexinMatrix(int[][] rowMatrix) {
		int max = 0;
		int[] maxIndex = new int[2];
		for (int i = 0; i < rowMatrix.length; i++) {
			for (int j = 0; j < rowMatrix.length; ++j) {
				if (max > rowMatrix[i][j]) {
					max = rowMatrix[i][j];
					maxIndex[0] = i;
					maxIndex[1] = j;
				}
			}
		}
		return maxIndex;

	}
}