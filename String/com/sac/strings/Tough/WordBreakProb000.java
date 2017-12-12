package com.sac.strings.Tough;

import java.util.Set;

/**
 * http://www.capacode.com/string/split-string-in-words/
 * 
 * @author ssachdev
 *
 */
public class WordBreakProb000 {
	private static String EMPTY = "";
	private static String SPACE = " ";

	public static String breakingWords(Set<String> dictionary, String s) {
		// compute shortest, longest word
		int minLength = Integer.MAX_VALUE;
		int maxLength = Integer.MIN_VALUE;
		for (String word : dictionary) {
			if (word.length() > maxLength) {
				maxLength = word.length();
			}

			if (word.length() < minLength) {
				minLength = word.length();
			}
		}

		int[] startWordPos = getStartWordPos(dictionary, minLength, maxLength, s);

		if (startWordPos[0] >= 0) {
			StringBuilder result = new StringBuilder();
			int start = 0;
			while (true) {
				int end = startWordPos[start];
				result.append(s.substring(start, end));
				start = end;
				if (start != s.length()) {
					result.append(SPACE);
				} else {
					break;
				}
			}

			return result.toString();
		} else {
			return EMPTY;
		}
	}

	/**
	 *
	 * @param dictionary
	 * @param s
	 * @return v = result[u] >= 0 if the suffix from u is valid. Then result[v]
	 *         >= 0 and substring from u to v-1 is a valid word
	 */
	public static int[] getStartWordPos(Set<String> dictionary, int minLength,
			int maxLength, String s) {
		int length = s.length();

		int[] startWordPos = new int[length + 1];
		for (int i = 0; i <= length; i++) {
			startWordPos[i] = -1;
		}
		startWordPos[length] = length;

		for (int u = length - 1; u >= 0; u--) {
			// check substring length within minLength and maxLength
			for (int v = u + minLength; v <= s.length() && v <= u + maxLength; v++) {
				if (dictionary.contains(s.substring(u, v)) && startWordPos[v] >= 0) {
					startWordPos[u] = v;
					break;
				}
			}
		}

		return startWordPos;

	}
}
