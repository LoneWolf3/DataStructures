package com.sac.string.learnt;

public class CycleLeaderIteration {
	/**
	 * WAP to convert a1b2c3 into abc123
	 * 
	 * ALGO
	 * 
	 * Take two string builder Odd and Even
	 * 
	 * Iterate over length string if(i%2==0) {
	 * 
	 * stringBuilderEVEN.append(array[i]);
	 * 
	 * } else {
	 * 
	 * stringBuilderOdd.append(array[i]); }
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		// TODO Auto-generated method stub

		CycleLeaderIteration.transformString("a1b2c3");

	}

	public static void transformString(String s1) {

		char array[] = s1.toCharArray();

		int i = 0;

		StringBuilder stringBuilderODD = new StringBuilder();

		StringBuilder stringBuilderEVEN = new StringBuilder();

		while (i < array.length) {

			if (i % 2 == 0) {

				stringBuilderEVEN.append(array[i]);

			} else {

				stringBuilderODD.append(array[i]);

			}

			i++;

		}

		System.out.println("The String " + s1 + " tranformed to " + stringBuilderEVEN.append(stringBuilderODD));

	}

}