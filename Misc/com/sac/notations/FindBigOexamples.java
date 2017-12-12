package com.sac.notations;

public class FindBigOexamples {
	void Function(int n) {
		int i = 1;
		int s = 1;
		// s is increasing not at rate 1 but i
		while (s <= n) {
			i++;

			s = s + i;

		}
	}
	/*
	 * We can define the terms according to the relation = The value of
	 * increases by one for each iteration. So the value contained in at the
	 * iteration is the sum of the first positive integers. If is the total
	 * number of iterations taken by the program, then the while loop terminates
	 * once. so sum of s is 1+2+3...n = n(n+1)/2 = so npow2 = T(k) means time
	 * complexity is underootK
	 */

	void Function1(int n) {
		int i, count = 0;
		;
		for (i = 1; i * i <= n; i++)
			count++;
	}

	/* time complexity is underootK */

	void function(int n) {
		int i, j, k, count = 0;

		// outer loop execute n/2 times
		for (i = n / 2; i <= n; i++)
			// Middle loop executes n/2 times
			for (j = 1; j + n / 2 <= n; j = j++)
				// outer loop execute logn times
				for (k = 1; k <= n; k = k * 2)
					count++;
	}

	/** The complexity of the above function is npow2logn **/

	void function4(int n) {
		int i, j, k, count = 0;
		// outer loop execute n/2 times
		for (i = n / 2; i <= n; i++)
			// Middle loop executes logn times
			for (j = 1; j <= n; j = 2 * j)
				// outer loop execute logn times
				for (k = 1; k <= n; k = k * 2)
					count++;
	}
	/* The complexity of the above function is nlogpow2n */

	void function5(int n) {
		// constant time
		if (n == 1)
			return;
		// outer loop execute times
		for (int i = 1; i <= n; i++) {
			// inner loop executes only time due to statement.
			for (int j = 1; j <= n; j++) {

				break;
			}
		}
	}
	/*
	 * The complexity of the above function is n . Even though the inner loop is
	 * bounded by n , but due to the break statement it is executing only once.
	 */

}
