package com.sac.misc.learnt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Date 07/10/2015
 * 
 * @author Tushar Roy
 *
 *         Given an input and total print all combinations with repetitions in
 *         this input which sums to given total. e.g input - {2,3,5} total - 10
 *
 *         Output [2,2,2,2,2], [2,2,3,3], [2,3,5], [5,5]] Reference
 *         https://leetcode.com/problems/combination-sum/
 */
public class PrintSumCombination {

	public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

		if (candidates == null || candidates.length == 0)
			return result;

		ArrayList<Integer> current = new ArrayList<Integer>();
		Arrays.sort(candidates);

		combinationSum(candidates, target, 0, current, result);

		return result;
	}

	public void combinationSum(int[] candidates, int target, int initialLength, ArrayList<Integer> curr,
			ArrayList<ArrayList<Integer>> result) {
		if (target == 0) {
			ArrayList<Integer> temp = new ArrayList<Integer>(curr);
			result.add(temp);
			return;
		}

		for (int i = initialLength; i < candidates.length; i++) {
			if (target < candidates[i])
				return;

			curr.add(candidates[i]);
			combinationSum(candidates, target - candidates[i], i, curr, result);
			curr.remove(curr.size() - 1);
		}
	}

	public static void main(String args[]) {
		int input[] = { 2, 3, 5 };
		PrintSumCombination psc = new PrintSumCombination();
		List<ArrayList<Integer>> result = psc.combinationSum(input, 10);
		result.forEach(r -> {
			r.forEach(r1 -> System.out.print(r1 + " "));
			System.out.println();
		});
	}
}
