package com.sac.string.learnt;

import java.util.HashSet;
import java.util.Set;

/**
 * 1)Loop through the length of string.
 * 
 * 2)Insert each charcter in Set to get unique char.
 * 
 * 3)once the duplicate char is found remove all the charcter starting from 0
 * till the first occurance of duplicate charcter.
 * 
 * References
 * http://www.geeksforgeeks.org/length-of-the-longest-substring-without-repeating-characters/
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
public class LongestSubstringWithoutRepetingCharacter {

	public int lengthOfLongestSubstring(String s) {
		Set<Character> uniqueSet = new HashSet<>();
		int maxSize = 0;
		int start = 0;
		for (int i = 0; i < s.length(); i++) {
			if (!uniqueSet.contains(s.charAt(i))) {
				uniqueSet.add(s.charAt(i));
				if (uniqueSet.size() > maxSize) {
					maxSize = uniqueSet.size();
				}
			} else {
				while (s.charAt(start) != s.charAt(i)) {
					uniqueSet.remove(s.charAt(start));
					start++;
				}
				start++;
			}
		}
		return maxSize;
	}

	public static void main(String args[]) {
		LongestSubstringWithoutRepetingCharacter lsw = new LongestSubstringWithoutRepetingCharacter();
		System.out.println(lsw.lengthOfLongestSubstring("ABCDCFGH"));
	}
}
