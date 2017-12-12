package com.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * http://www.lifeincode.net/programming/leetcode-two-sum-3-sum-3-sum-closest-
 * and-4-sum-java/
 * 
 * 
 * Map Entry = {{20=0, 7=3, 11=2, 15=1}} target-number[i]
 * 
 * @author ssachdev
 * 
 */
public class ThreeSum0000 {
	public static void main(String[] args) {
		int a[] = { 1, 11, 15, 7, 2 };

		int target = 9;
		System.out.println(Arrays.toString(twoSum(a, target)));
	}

	public static int[] twoSum(int[] numbers, int target) {
		HashMap<Integer, Integer> map = new HashMap();
		for (int i = 0; i < numbers.length; i++) {
			map.put(target - numbers[i], i);
			System.out.println(target - numbers[i] + "," + i);
		}

		for (int i = 0; i < numbers.length; i++) {
			if (map.containsKey(numbers[i])) {
				if (map.get(numbers[i]) != i) {
					return new int[] { i, map.get(numbers[i]) };
				}
			}
		}
		return new int[2];

	}

	public static List<List<Integer>> threeSum(int[] num) {
		Arrays.sort(num);
		LinkedList<List<Integer>> ret = new LinkedList();
		HashSet<List<Integer>> set = new HashSet();
		for (int i = 0; i < num.length - 2; i++) {
			int start = i + 1;
			int end = num.length - 1;
			while (start < end) {
				if (num[i] + num[start] + num[end] == 0) {
					LinkedList<Integer> oneResult = new LinkedList();
					oneResult.add(num[i]);
					oneResult.add(num[start]);
					oneResult.add(num[end]);
					set.add(oneResult);
					start++;
					end--;
				} else {
					if (num[i] + num[start] + num[end] < 0)
						start++;
					else
						end--;
				}
			}
		}
		ret.addAll(set);
		return ret;
	}

	public static int threeSumClosest(int[] num, int target) {
		int closest = num[0] + num[1] + num[2];
		int diff = Math.abs(closest - target);
		Arrays.sort(num);
		for (int i = 0; i < num.length - 2; i++) {
			int start = i + 1;
			int end = num.length - 1;
			while (start < end) {
				int sum = num[i] + num[start] + num[end];
				int newDiff = Math.abs(sum - target);
				if (newDiff < diff) {
					diff = newDiff;
					closest = sum;
				}
				if (sum < target)
					start++;
				else
					end--;
			}
		}
		return closest;
	}

	public static int[] threeMap(int[] num, int target) {
		Map m = new HashMap();
		int[] result = new int[2];
		int n = num.length;
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < n; j++) {
				m.put(num[i] + num[j], 1);
			}
		}
		for (int k = 1; k < n; k++) {
			int temp = -num[k];
			if (m.get(temp) != null) {
				int index = (Integer) m.get(temp);
				result[0] = index + 1;
				result[1] = k + 1;
			}
		}
		return result;
	}

}