package com.array;

import java.util.Arrays;

public class AddingArrays {
	static int[] a = { 1, 2, 3, 4 };
	static int[] b = { 9, 1, 7, 8 };

	public static void main(String[] args) {

		int carry = 0;
		int l = a.length;
		int[] result = new int[l + 1];
		int p = l;
		result[0] = 0;
		for (int j = a.length - 1; j >= 0; j--) {
			int sum = a[j] + b[j] + carry;
			int digit = sum % 10;
			carry = sum / 10;
			result[p] = digit;
			p--;
		}

		if (carry != 0)
			result[p] = carry;

		System.out.println();
		for (int i = 0; i <= l; i++)
			System.out.print(result[i] + "\t");
		System.out.println();
	}

	static void b() {
		System.out.println(Arrays.toString(a));
	}

	static void c() {
		System.out.println(Arrays.toString(a));
	}
}