package com.array;

public class FindMissingNumber {
	static int findMissingNumber(int A[]) {
		int i, X = 0, Y = 0;
		for (i = 0; i < 9; i++)
			X ^= A[i];
		for (i = 1; i <= 10; i++)
			Y ^= i;
		// In fact, one variable is enough.
		return X ^ Y;
	}
	
	public static void main(String[] args) {
		int a[] = {2,1,3,4,7};
		System.out.println(findMissingNumber(a));
	}
}
