package com.array;
/**
 * a) take a byte array of same length as of array.
 * b) Initally byte array is zero .
 * c)check byte array for array integer if 0 then set it as 1 print no beep.
 * d)check byte array for array integer if 1 then set it as 0 and print beep. 
 * @author ssachdev
 *
 */
public class BeedWithOdd {
	public static void main(String[] args) {
		
		byte[] a = new byte[10];
		int[] num = { 1, 4, 2, 4, 2, 3 };
		int n = num.length;
		for (int i = 0; i < n; i++) {
			if (a[num[i]] == 0) {
				System.out.println("beep ");
				a[num[i]] = 1;
			} else if (a[num[i]] == 1) {
				System.out.println("NoBeep ");
				a[num[i]] = 0;
			}
		}
	}
}
