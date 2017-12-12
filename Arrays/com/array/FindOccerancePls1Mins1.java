package com.array;

/**
 * amazon-interview-questions 2 of 2 votes 62 Answers
 * 
 * Consider an array of integers wherein each element is +1 or -1 its preceding
 * element. Given a number, find the first occurence of this number (index) in
 * this array without using linear search.
 * 
 * For example, consider the array : 4 5 6 5 6 7 8 9 10 9 10 (each element in
 * this array is +1 or -1 its preceding element)
 * 
 * Input : 10 (find first occurence of 10 without using linear search) Output :
 * 8
 * 
 * @author ssachdev
 * 
 */
public class FindOccerancePls1Mins1 {
	public static int findElementInArray(int[] input, int expected) {
		int current = 0;
		int difference = Math.abs(input[current] - expected);

		while (difference != 0 && current < input.length) {
			difference = Math.abs(input[current] - expected);
			current += difference;
		}

		if (difference == 0) {
			return current;
		}

		return -1;
	}

	public static void main(String[] args) {
		int[] a = new int[] { 4, 5, 6, 5, 6, 7, 8, 9, 10, 9, 10 };
		System.out.println(findElementInArray(a, 10));

	}
}
