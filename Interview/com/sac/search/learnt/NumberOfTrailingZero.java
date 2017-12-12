package com.sac.search.learnt;

/**
 * A trailing zero is always produced by prime factors 2 and 5. NUmber of 5 is
 * equal to number of 0;
 * 
 * or example if we consider 28!, we get one extra 5 and number of 0s become 6.
 * Handling this is simple, first divide n by 5 and remove all single 5s, then
 * divide by 25 to remove extra 5s and so on. Following is the summarized
 * formula for counting trailing 0s.
 * 
 * find prime factor of factorial . then count number of 5
 * 
 * @author ssachdev
 *
 */
public class NumberOfTrailingZero {
	static int NumberOfTrailingZerosInNumber(int n) {
		int i, count = 0;
		if (n < 0)
			return -1;
		for (i = 5; n / i > 0; i =i* 5)
			count =count + n / i;
		return count;
	}

	public static void main(String[] args) {
		int a = 25;
		System.out.println(NumberOfTrailingZerosInNumber(a));
	}
}
