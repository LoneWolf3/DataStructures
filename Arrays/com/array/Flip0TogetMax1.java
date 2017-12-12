package com.array;

/**
 * Let us use a window covering from index wL to index wR. Let the number of
 * zeros inside the window be zeroCount. We maintain the window with at most m
 * zeros inside.
 * 
 * The main steps are: – While zeroCount is no more than m: expand the window to
 * the right (wR++) and update the count zeroCount. – While zeroCount exceeds m,
 * shrink the window from left (wL++), update zeroCount; – Update the widest
 * window along the way. The positions of output zeros are inside the best
 * window
 * 
 * @author ssachdev
 *
 */
public class Flip0TogetMax1 {

	static // m is maximum of number zeroes allowed to flip
	// n is size of array
	void findZeroes(int arr[], int n, int m) {
		// Left and right indexes of current window
		int wL = 0, wR = 0;

		// Left index and size of the widest window
		int bestL = 0, bestWindow = 0;

		// Count of zeroes in current window
		int zeroCount = 0;

		// While right boundary of current window doesn't cross
		// right end
		while (wR < n) {
			// If zero count of current window is less than m,
			// widen the window toward right
			if (zeroCount <= m) {
				if (arr[wR] == 0)
					zeroCount++;
				wR++;
			}

			// If zero count of current window is more than m,
			// reduce the window from left
			if (zeroCount > m) {
				if (arr[wL] == 0)
					zeroCount--;
				wL++;
			}

			// Updqate widest window if this window size is more
			if (wR - wL > bestWindow) {
				bestWindow = wR - wL;
				bestL = wL;
			}
		}

		// Print positions of zeroes in the widest window
		for (int i = 0; i < bestWindow; i++) {
			if (arr[bestL + i] == 0)
				System.out.println(bestL + i + " ");
		}
	}

	// Driver program
	public static void main(String[] args) {

		int arr[] = { 1, 0, 1, 1, 0, 0, 1, 1 };
		int m = 2;
		int n = arr.length;
		System.out.println("Indexes of zeroes to be flipped are ");
		findZeroes(arr, n, m);

	}
}