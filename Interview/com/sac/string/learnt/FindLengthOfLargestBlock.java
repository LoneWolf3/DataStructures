package com.sac.string.learnt;
/**
 * Algo===
 * 
 *Loop through the length of string and check if char at [i]==char[i+1]
 *
 *if yes then block++;
 *
 *if block length is greater the longest block then 
 *
 *longest block=length
 *
 *else initiate length again.
 *
 * @author ssachdev
 *
 */
public class FindLengthOfLargestBlock {
	public static void main(String[] args) {
		System.out.println(getLength("xxaaabb"));
	}

	static Integer getLength(String str) {
		if (str.isEmpty()) {
			return 0;
		}
		int longest = 0;
		int length = 1;
		for (int i = 0; i < str.length() - 1; i++) {
			if (str.charAt(i) == str.charAt(i + 1)) {
				++length;
				if (length > longest) {
					longest = length;
				}
			} else {
				length = 1;
			}
		}
		if (length > longest) {
			longest = length;
		}
		return longest;
	}
}
