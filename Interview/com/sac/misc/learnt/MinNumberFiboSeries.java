package com.sac.misc.learnt;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * http://www.careercup.com/question?id=5090409931866112
 * 
 * cache is list of 2 fib numbers 0 f1 and 1 f2
 * 
 * 1) while( f2 < n)
 * 
 * 
 * 2)If index < cache size { means list of fig numbers has been build and we
 * need to work on sum - f1
 * 
 * }
 * 
 * else{ we are building list for number less then the sum }
 * 
 * return f1;
 *
 * 
 * @author ssachdev
 *
 */
public class MinNumberFiboSeries {

	private List<Integer> cache = new ArrayList<Integer>();

	public MinNumberFiboSeries() {
		cache.add(0);
		cache.add(1);
	}

	/**
	 * Returns the highest Fibonacci number lower than n.
	 * 
	 * @param n
	 * @return
	 */
	private int getHighestFibNumber(int n) {
		int index = 0;
		int f1 = cache.get(index);
		int f2 = cache.get(index + 1);
		int temp;
		while (f2 <= n) {
			if (index < cache.size() - 2) {
				f1 = f2;
				f2 = cache.get(index + 2);
			} else {
				temp = f1;
				f1 = f2;
				f2 = temp + f1;
				cache.add(f2);
			}
			index++;
		}
		return f1;
	}

	public List<Integer> split(int n) {
		if (n == 0)
			return new LinkedList<Integer>();
		int f = getHighestFibNumber(n);
		List<Integer> result = split(n - f);
		result.add(f);
		return result;
	}

	public static void main(String[] args) {
		MinNumberFiboSeries fib = new MinNumberFiboSeries();
	//	System.out.println(fib.split(7)); // [2, 5]
		System.out.println(fib.split(70)); // [2, 13, 55]
		//System.out.println(fib.split(2583)); // [2, 5, 13, 34, 89, 233, 610, 1597]
	}

}