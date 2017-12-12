package com.sac.strings.Tough;


import java.util.HashMap;

/**
 * linkedin-interview-questions 4 of 4 votes 64 Answers
 * 
 * Given two (dictionary) words as Strings, determine if they are isomorphic.
 * Two words are called isomorphic if the letters in one word can be remapped to
 * get the second word. Remapping a letter means replacing all occurrences of it
 * with another letter while the ordering of the letters remains unchanged. No
 * two letters may map to the same letter, but a letter may map to itself.
 * 
 * Example: given "foo", "app"; returns true we can map 'f' -> 'a' and 'o' ->
 * 'p' given "bar", "foo"; returns false we can't map both 'a' and 'r' to 'o'
 * 
 * given "turtle", "tletur"; returns true we can map 't' -> 't', 'u' -> 'l', 'r'
 * -> 'e', 'l' -> 'u', 'e' -'r'
 * 
 * given "ab", "ca"; returns true we can map 'a' -> 'c', 'b'
 * 
 * @author ssachdev
 * 
 */
public class IsomorphicString {

	public static boolean check(String s, String t) {
		if (s.length() != t.length())
			return false;
		HashMap<Character, Character> map1 = new HashMap<Character, Character>();
		HashMap<Character, Character> map2 = new HashMap<Character, Character>();

		for (int i = 0; i < s.length(); i++) {
			char c1 = s.charAt(i);
			char c2 = t.charAt(i);
			if (map1.containsKey(c1)) {
				if (map1.get(c1) != c2)
					return false;
			}
			if (map2.containsKey(c2)) {
				if (map2.get(c2) != c1)
					return false;
			}

			map1.put(c1, c2);
			map2.put(c2, c1);
		}
		return true;
	}

}
