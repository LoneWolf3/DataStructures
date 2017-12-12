package com.sac.search.tough;

public class FindIndexofFisrtOcurnce {
	
	
	public int BinarySearchFirstOccurrence(int A[], int n, int low, int high, int data) 
	{ 
	 int mid; 
	 if (high >= low) 
	 { 
	  mid = low + (high-low) / 2; 
	  if ((mid == low && A[mid] == data) || (A[mid] == data && A[mid - 1] < data)) 
	   return mid; 
	  // Give preference to left half of the array 
	  else if (A[mid] >= data) 
	   return BinarySearchFirstOccurrence (A, n, low, mid - 1, data); 
	  else 
	   return BinarySearchFirstOccurrence (A, n, mid + 1, high, data); 
	 } 
	 return -1; 
	}
	 
}