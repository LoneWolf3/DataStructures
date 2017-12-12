/***
 * This program finds the Continuos String pattren in Matrix.
 * 
 * Q R X
 * 
 * Q A X
 * 
 * P Q T
 * 
 * Ex. rat is there.
 * 
 * ***/
package com.sac.tough;

class PattrenMatchInMatrix {
	public static void main(String[] args) {
		char[][] matrix = new char[][] { 
				{ 'A', 'N', 'L', 'Y', 'S' },
				{ 'I', 'S', 'D', 'E', 'S' }, 
				{ 'I', 'G', 'N', 'D', 'E' } };
		String word = "DES";
		PattrenMatchInMatrix mw = new PattrenMatchInMatrix(matrix, word);
		mw.findWords();
	}

	private char[][] matrix;
	private String word;

	public PattrenMatchInMatrix(char[][] matrix, String word) {
		this.matrix = matrix;
		this.word = word;
	}

	public void findWords() {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				findNext(i, j, 0, "");
			}
		}
	}

	private void findNext(int x, int y, int idx, String positions) {
		if (x < 0 || x >= matrix.length || y < 0 || y >= matrix[x].length)
			return;

		if (matrix[x][y] != word.charAt(idx))
			return;

		positions += (word.charAt(idx) + " - [" + x + ", " + y + "], ");

		if (idx < word.length() - 1) {
			findNext(x - 1, y - 1, idx + 1, positions);
			findNext(x, y - 1, idx + 1, positions);
			findNext(x + 1, y - 1, idx + 1, positions);
			findNext(x - 1, y + 1, idx + 1, positions);
			findNext(x, y + 1, idx + 1, positions);
			findNext(x + 1, y + 1, idx + 1, positions);
			findNext(x + 1, y, idx + 1, positions);
			findNext(x - 1, y, idx + 1, positions);
		} else {
			System.out.println(positions);
		}
	}

}
