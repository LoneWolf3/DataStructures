/*Copyright (c) Dec 21, 2014 CareerMonk Publications and others.
 * E-Mail           	: info@careermonk.com 
 * Creation Date    	: 2015-01-10 06:15:46 
 * Last modification	: 2006-05-31 
               by		: Narasimha Karumanchi 
 * Book Title			: Data Structures And Algorithms Made In Java
 * Warranty         	: This software is provided "as is" without any 
 * 							warranty; without even the implied warranty of 
 * 							merchantability or fitness for a particular purpose. 
 * 
 */
package com.sac.sorting.logn;

/**
 * find a prtition such that all the element on left of partion is less then it
 * and greater then on right. method for partion is p = partition(A,start,end)
 * 
 * do quick sort for qs(A,start,p-1) do quick sort for qs(A,p+1,end)
 * 
 * @author ssachdev
 *
 */
public class QuickSort {

	static int A[] = { 7, 2, 1, 6, 8, 5, 3, 4 };

	public static void quickSort(int A[], int start, int end) {
		int pivot;
		// Termination condition!
		if (start < end) {
			pivot = Partition(A, start, end);
			quickSort(A, start, pivot - 1);
			quickSort(A, pivot + 1, end);
		}
	}

	private static int Partition(int[] A, int start, int end) {
		int pivot_item = A[end];
		int pIndex = start;
		for (int i = start; i < end; i++) {
			if (A[i] <= pivot_item) {
				swap(A, i, pIndex);
				pIndex = pIndex + 1;
			}
		}
		swap(A, pIndex, end);
		return pIndex;

	}

	private static void swap(int[] A, int left, int right) {
		int temp = 0;
		temp = A[left];
		A[left] = A[right];
		A[right] = temp;
	}

	public static void main(String[] args) {
		quickSort(A, 0, 7);
		for (int i = 0; i < A.length; i++) {
			System.out.print(A[i] + ", ");
		}
	}

}