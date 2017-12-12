package com.sac.misc.learnt;

/**
 * amazon-interview-questions 3 of 7 votes 40 Answers
 * 
 * given an input array of integers where each integer represent the maximum
 * amount of jump a frog can take.Frog has to reach the end of the array in
 * minimum number of jumps. Example:[1 5 4 6 9 3 0 0 1 3] answer is 3 for this.
 * [2 8 3 6 9 3 0 0 1 3] answer is 2 for this. Any DP solution for this?
 * 
 * @author ssachdev
 * 
 */
import java.util.*;

public class MaximumHopesFrog {
	static int Jump(int ar[]) {
		int len = ar.length;
		int tot[] = new int[len];
		tot[0] = 0;
		for (int i = 1; i < len; i++)
			tot[i] = 999;
		for (int i = 1; i < len; i++) {
			for (int j = 0; j < i; j++) {
				if (j + ar[j] >= i && tot[i] > tot[j] + 1)
					tot[i] = tot[j] + 1;
			}
		}
		return tot[len - 1];
	}

	public static void main(String args[]) {
		int ar[] = { 2 ,8, 3, 6, 9, 3, 0, 0, 1, 3};
		System.out.println(Jump(ar));

	}
}