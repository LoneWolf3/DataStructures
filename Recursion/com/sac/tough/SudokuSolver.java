package com.sac.tough;

/**
 * Find row, col of an unassigned cell
 * 
 * If there is none, return true
 * 
 * For digits from 1 to 9 a) If there is no conflict for digit at row,col assign
 * digit to row,col and recursively try fill in rest of grid
 * 
 * b) If recursion successful, return true
 * 
 * c) Else, remove digit and try another
 * 
 * If all digits have been tried and nothing worked, return false
 * 
 * @author ssachdev
 *
 */
public class SudokuSolver {

	public static int ar[][] = {

			{ 3, 0, 6, 5, 0, 8, 4, 0, 0 },

			{ 5, 2, 0, 0, 0, 0, 0, 0, 0 },

			{ 0, 8, 7, 0, 0, 0, 0, 3, 1 },

			{ 0, 0, 3, 0, 1, 0, 0, 8, 0 },

			{ 9, 0, 0, 8, 6, 3, 0, 0, 5 },

			{ 0, 5, 0, 0, 9, 0, 6, 0, 0 },

			{ 1, 3, 0, 0, 0, 0, 2, 5, 0 },

			{ 0, 0, 0, 0, 0, 0, 0, 7, 4 },

			{ 0, 0, 5, 2, 0, 6, 3, 0, 0 }

	};

	public static void printGrid() {
		for (int i = 0; i < ar.length; i++) {

			for (int j = 0; j < ar.length; j++) {
				System.out.print(ar[i][j] + " ");
			}
			System.out.println("");
		}
	}

	/*
	 * Takes a partially filled-in grid and attempts to assign values to all
	 * unassigned locations in such a way to meet the requirements for Sudoku
	 * solution (non-duplication across rows, columns, and boxes)
	 */
	public static boolean solve() {

		// find unsiigned column,row

		int[] temp = findUn();

		if (temp != null) {
			int row = temp[0];
			int col = temp[1];

			// System.out.println("Empty place is "+row+" "+col);
			for (int i = 1; i <= 9; i++) {
				if (isSafe(row, col, i)) {
					// System.out.println("Its safe "+row +" "+col+" for "+i);

					ar[row][col] = i;
					if (solve()) {
						return true;
					}
					ar[row][col] = 0;
				}
			}
		} else
			return true;
		return false;// this triggers backtracking

	}

	/*
	 * Returns a boolean which indicates whether it will be legal to assign num
	 * to the given row,col location.
	 */

	public static boolean isSafe(int row, int col, int num) {

		return checkRow(row, col, num) && checkCol(row, col, num) /*&& checkGrid(row, col, num)*/;
	}

	/*
	 * Returns a boolean which indicates whether any assigned entry in the
	 * specified row matches the given number.
	 */
	public static boolean checkRow(int row, int col, int num) {

		for (int i = 0; i < ar.length; i++) {
			if (ar[row][i] == num) {
				return false;
			}
		}
		return true;
	}

	/*
	 * Returns a boolean which indicates whether any assigned entry in the
	 * specified column matches the given number.
	 */
	public static boolean checkCol(int row, int col, int num) {

		for (int i = 0; i < ar.length; i++) {
			if (ar[i][col] == num) {
				return false;
			}
		}

		return true;
	}

	/*
	 * Returns a boolean which indicates whether any assigned entry within the
	 * specified 3x3 box matches the given number.
	 */

	public static boolean checkGrid(int row, int col, int num) {
		row = row - (row % 3);
		col = col - (col % 3);

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (ar[i + row][j + col] == num) {
					return false;
				}
			}
		}
		return true;

	}

	/*
	 * Searches the grid to find an entry that is still unassigned. If found,
	 * the reference parameters row, col will be set the location that is
	 * unassigned, and true is returned. If no unassigned entries remain, false
	 * is returned.
	 */
	public static int[] findUn() {

		int[] t = new int[2];
		for (int i = 0; i < ar.length; i++) {

			for (int j = 0; j < ar.length; j++) {
				if (ar[i][j] == 0) {
					t[0] = i;
					t[1] = j;
					return t;
				}
			}
		}
		return null;
	}

	public static void main(String[] args) {

		System.out.println("unsolved sudoku\n\n");
		printGrid();
		System.out.println("\n\nSolved sudoku\n\n");
		if (solve()) {
			printGrid();
		}
	}

}