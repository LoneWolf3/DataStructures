package com.sac.tough;

/**
 * facebook-interview-questions 4 of 4 votes 39 Answers
 * 
 * Given an m x n matrix where each row element is sorted, but the columns do
 * not appear in sorted order, write a function to print each matrix element in
 * sorted order.
 * 
 * Example matrix: matrix = [ [20, 40, 80], [5, 60, 90], [45, 50, 55] ]
 * 
 * Your function should print 5, 20, 40, 45, 50, 55, 60, 80, 90.
 * 
 * @author ssachdev
 * 
 */
public class SortMatrix {
	/*
	 * 
	 * Simple solution: Use MinHeap.
	 * 
	 * Add all the elements of first column to the heap and min heapify, print
	 * the root, remove and put the next from the same row. Repeat.
	 */
}
