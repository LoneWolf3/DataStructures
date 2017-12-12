package com.maths;
public class tribonacciSeries {

	static boolean test(int m) {
		int a = 1, b = 1, c = 1;
		/***
		 * Fibonncai serires is a peroaidc series and same as tribonacci
		 * series.*** 1 ,1, 1 repeats at regular interval
		 **/
		while (true) {
			int d = (a + b + c) % m;
			if (d == 0)
				return false;
			a = b;
			b = c;
			c = d;
			System.out.println(a);
			System.out.println(b);
			System.out.println(c);
			System.out.println("=====================");
			if (a == b && b == c) {
				break;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		int t = 17;
		int todo = 1;
		while (todo > 0) {
			t = t + 2;
			if (test(t))
				todo--;
		}
		System.out.println(t);

	}

}