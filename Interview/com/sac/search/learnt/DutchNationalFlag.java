package com.sac.search.learnt;

/**
 * Dutch national flag is sort 012 in O(n)
 * ex=11020
 * while(lo2<=high)
 * Case (0) swap a[Lo] and a[lo2]; Lo++; lo2++
 * 
 * Case (1) lo2++
 * 
 * Case (2) swap a[lo2] and a[Hi]; Hi-- complexity o(n)
 * 
 * 
 */

public class DutchNationalFlag {

	// Sort the input array, the array is assumed to
	// have values in {0, 1, 2}
	static void sort012(int a[], int arr_size) {
		int lo = 0;
		int hi = arr_size - 1;
		int lo2 = 0, temp = 0;
		while (lo2 <= hi) {
			switch (a[lo2]) {
			case 0: {
				temp = a[lo];
				a[lo] = a[lo2];
				a[lo2] = temp;
				lo++;
				lo2++;
				break;
			}
			case 1:
				lo2++;
				break;
			case 2: {
				temp = a[lo2];
				a[lo2] = a[hi];
				a[hi] = temp;
				hi--;
				break;
			}
			}
		}
	}

	/* Utility function to print array arr[] */
	static void printArray(int arr[], int arr_size) {
		int i;
		for (i = 0; i < arr_size; i++)
			System.out.print(arr[i] + " ");
		System.out.println("");
	}

	/* Driver function to check for above functions */
	public static void main(String[] args) {
		int arr[] = { 0,1, 1, 0, 2, 0 };
		int arr_size = arr.length;
		sort012(arr, arr_size);
		System.out.println("Array after seggregation ");
		printArray(arr, arr_size);
	}
}