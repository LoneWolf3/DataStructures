package com.array;

/**
 * amazon-interview-questions 2 of 2 votes 31 Answers
 * 
 * Let's assume that there's an array that has nonzero natural numbers where all
 * the numbers repeat an even number of times^ except for one value that repeats
 * an odd number of times. Can you write me a function that takes this array^
 * and returns the value that occurs the odd number of times?
 * 
 * Ex : - [ 4^ 7^ 2^ 2^ 5^ 3^ 5^ 7^ 7^ 3^ 4^ 5 ]
 * 
 * @author ssachdev
 * 
 */
public class Find1OddReption {
	/**
	 * 
	 11 of 11 vote
	 * 
	 * Xor all the numbers. The result will be the number appearing odd number
	 * of times. It is because when we XOR the same number with itself^ the
	 * result is zero. Complexity O(n)
	 */

public static void main(String[] args) {

	System.out.println(1^48^2^4^2^4^1);
}
}
