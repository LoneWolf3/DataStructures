package com.sac.search.learnt;

public class FloorAndCeilingInSortedArray {

	static /* Function to print floor and ceil of x in arr[low..high] */
	void floorCeilSearch(int arr[], int n, int x) {
		int i, floor = -1, ceil = -1;

		for (i = 0; i < n; i++) {
			/*
			 * if x is same as current element then floor = ceil = arr[i] and
			 * break from loop
			 */
			if (arr[i] == x) {
				floor = ceil = arr[i];
				break;
			}
			/*
			 * if x is greater than the current element is a possible candidate
			 * for floor so set floor = arr[i] and keep searching for a more
			 * exact value of floor
			 */
			else if (arr[i] < x) {
				floor = arr[i];
			}
			/*
			 * if x is smaller than the current element then set ceil = arr[i],
			 * when the first greater value than x is found then no need to
			 * search further so break here
			 */
			else if (arr[i] > x) {
				ceil = arr[i];
				break;
			}
		}
		// this code prints -1 if floor or ceil doesn't exist
		System.out.println("floor =" + floor + "Ciel" + ceil);
	}

	public static void main(String[] args) {
		int arr[] ={1, 2, 8, 10, 10, 12, 19};
		int n = arr.length;
		int x = 5;
		floorCeilSearch(arr, n, x);
	}

}