package com.sac.hash.problems;
import java.util.HashMap;
import java.util.Map;

public class CheckTwoArraySimilar {

	public static void main(String[] args) throws Exception {
		int[] ary = { 1, 2, 3, 4, 5, 6 };
		int[] ary1 = { 1, 3, 2, 4, 5, 6 };
		Map<Integer, Integer> nameAndCount = new HashMap<Integer, Integer>();
		for (Integer name : ary) {
			Integer count = nameAndCount.get(name);
			if (count == null) {
				nameAndCount.put(name, 1);
			} else {
				nameAndCount.put(name, ++count);
			}
		}
		for (Integer name : ary1) {
			Integer count = nameAndCount.get(name);
			if (count == null) {
				nameAndCount.put(name, 1);
			} else {
				nameAndCount.put(name, --count);
			}
		}
	}
}
