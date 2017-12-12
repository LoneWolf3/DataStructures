package com.interview.array.tough;

import java.util.Scanner;

//======================================================================================================================================================
/*Given an array containing both negative and positive integers. Find the contiguous sub-array with maximum sum.
Input:
The first line of input contains an integer T denoting the number of test cases. 
The description of T test cases follows. 
The first line of each test case contains a single integer N denoting the size of array. The second line contains N space-separated integers 
A1, A2, ..., AN denoting the elements of the array.
Output:
Print the maximum sum of the contiguous sub-array in a separate line for each test case */
//==========================================================================================================================================================

public class MaximumSubarykedan000000 {

	public static void main(String[] args) {

		int mArray[] = { -2, -3, 4, -1, -2, 1, 5, -3 };
		int length = mArray.length;
		System.out.println(maxSumContigiousSubarray(mArray,length));
	}

	static int maxSumContigiousSubarray(int a[], int size) {
		int max_so_far = a[0];
		int curr_max = a[0];

		for (int i = 1; i < size; i++) {
			curr_max = Math.max(a[i], curr_max + a[i]);
			max_so_far = Math.max(max_so_far, curr_max);
		}
		return max_so_far;
	}

}