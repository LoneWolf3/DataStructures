package com.sac.misc.learnt;

/**
 * Given an n-by-n matrix of 0's and 1's where all 1's in each row come before
 * all 0's, find the most efficient way to return the row with the maximum
 * number of 0's.
 * 
 * {1,1,1,0},
 * 
 * {1,1,0,0},
 * 
 * {1,0,0,0},
 * 
 * {1,1,0,0},
 * 
 * 
 * answer:3
 * 
 * @author ssachdev
 * 
 */
public class RowWithMax0 {
	public static void main(String[] args) {
		Integer[][] arr = new Integer[][] {

				{ 1, 1, 1, 0 },

				{ 1, 1, 0, 0 },

				{ 1, 1, 1, 0 },

				{ 1, 0, 0, 0 }

		};
		int rownum = 0;
		int ROW = 4;
		int COL = 4;
		int i = 0, j = COL - 1;
		while (i < ROW && j > 0) {
			if (arr[i][j] == 0) {
				j--;
				rownum = i;
			} else
				i++;
		}
		System.out.println(rownum);

	}

}
