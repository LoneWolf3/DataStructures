package com.sac.string.learnt;

import java.util.HashSet;

/**
 * facebook-interview-questions 3 of 3 votes 40 Answers
 * 
 * You're given a dictionary of strings, and a key. Check if the key is composed
 * of an arbitrary number of concatenations of strings from the dictionary. For
 * example:
 * 
 * dictionary: "world", "hello", "super", "hell" key: "helloworld" --> return
 * true key: "superman" --> return false key: "hellohello" --> return true
 * 
 * @author ssachdev
 * 
 * 
 *         =============Algo=========
 *
 *         1) Add all the words in hash set.
 *
 *         2) create boolean table t such that t[0]=true;
 * 
 *         3)take two pointers p1 and p2 on string.
 *
 *         4)Such that p1=0 and till len and p2=p1 till p1>=0;
 *
 *         5)find sub string (p2,p1+1)
 *
 *         6)if hashSet contains subword then check if table at t[p2] contains
 *         subwrd move and add true in table at t[i+1]
 */
public class DictonryConcantentationOfStrings {
	static String[] dic = { "world", "hello", "super", "hell" };

	static boolean isConcantentationOfOtherStrings(String word) {
		HashSet<String> hs = new HashSet<String>();

		for (String s : dic)
			hs.add(s);
		int len = word.length();

		boolean[] table = new boolean[len + 1];
		table[0] = true;

		for (int i = 0; i < len; i++) {
			for (int j = i; j >= 0; j--) {
				String subWord = word.substring(j, i + 1);
				if (hs.contains(subWord)) {
					if (table[j])
						table[i + 1] = true;
				}
			}
		}

		return table[len];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isConcantentationOfOtherStrings("hellworld"));

	}

}