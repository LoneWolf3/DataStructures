package com.sac.search.learnt;

/**
 * 
 * -4, -3, -2, -1, 6, 5, 4
 * 
 * 
 * Use binary search to find the index of that element for which mid is greater
 * then left and mid is greater then right
 * 
 * if mid is greater then left and mid is less then right then low = mid+1
 * 
 * if mid is less then left and mid is greater then right then high= mid -1
 * 
 * @author ssachdev
 *
 */
public class FindIndexofPositiveNum {
	static void Search(int A[], int n) {
		int first = 0;
		int last = n - 1;
		int mid;
		while (first <= last) {
			// if the current array has size 1

			mid = (first + last) / 2;
			if (A[mid - 1] < A[mid] && A[mid] > A[mid + 1]) {
				System.out.println(A[mid]);
				break;
			} else if (A[mid - 1] < A[mid] && A[mid] < A[mid + 1])
				first = mid + 1;
			else if (A[mid - 1] > A[mid] && A[mid] > A[mid + 1])
				last = mid - 1;

		} // end of else

	}

	public static void main(String[] args) {
		int a1[] = { -4, -3, -2, -1, 6, 5, 4 };
		Search(a1, a1.length);
	}

}
