package com.sac.misc.learnt;

public class Convert0inRowtoAll0 {

	
	
public static void main(String[] args) {
	
	int n1 =3;
	int[][] matrix1 =  new int[][] {
			{ 1, 1, 1 },
			{ 0, 1, 1 }, 
			{ 1, 1, 1 }
			};
	boolean[] row = new boolean[n1];
	boolean[] column = new boolean[n1];
	for (int i = 0; i < n1; i++) {
		for (int j = 0; j < n1; j++) {
			if (matrix1[i][j] == 0) {
				row[i] = true;
				column[j] = true;
			}
		}
	}

	for (int i = 0; i < n1; i++) {
		for (int j = 0; j < n1; j++) {
			if (row[i] || column[j]) {
				matrix1[i][j] = 0;
			}
		}
	}
	System.out.println("Matrix After Setting zero:-");
	printaray(matrix1);
	

}

public static void printaray(int[][] a) {
	for (int i = 0; i < a.length; ++i) {
		for (int j = 0; j < a.length; ++j) {
			System.out.print(a[i][j] + "");
		}
		System.out.println("");
	}
}
	
}
