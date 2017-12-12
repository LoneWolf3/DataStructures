package com.maths;
public class ConsectivePrimeSum {
	static int sum = 0;
	static int i;
	static int previousSum;
	static int finalOutput;

	public static void main(String[] args) {
		for (i = 0; i <= 1000; i++) {
			if (isPrime(i)) {
				previousSum = sum;
				System.out.println(previousSum);
				if (isPrime(previousSum)) {
					System.out.println("prime----"+previousSum);
					finalOutput = sum;
				}

				sum = sum + i;
				
				if (sum >= 1000) {
					
					break;
				}
			}
		}
		System.out.println(finalOutput);
	}

	public static boolean isPrime(int number) {

		boolean isPrime = true;

		if (number == 1) {
			return false;
		} else if (number == 2) {
			return true;
		} else if (number % 2 == 0) {
			return false;
		} else {
			for (int i = 3; isPrime && i <= Math.sqrt(number); i += 2) {
				if (number % i == 0) {
					isPrime = false;
				}
			}
		}

		return isPrime;

	}
}
