package com.sac.strings.Tough;

/**
 * True xyz,xz xyz, xyk xy, xyz
 * 
 * 
 * -False xyz, xyz xyz,xzy x, xyz
 * 
 * @author ssachdev
 * 
 */
public class TwoStringsOneEdit {

	public static void main(String[] args) {

	}

	static boolean edit(String[] s1, String[] s2) {
		if (s2.length < s1.length) {
			return edit(s2, s1);
		}
		if (s1.length + 1 < s2.length) {
			return false;
		}

		int i = 0;
		while (s1[i] != s2[i]) {
			if (s1.length == s2.length) {
				return s1.toString().substring(i + 1) == s2.toString().substring(i + 1);
			} else {
				return s1.toString().substring(i) == s2.toString().substring(i + 1);
			}
		}
		i++;

		return s1.length != s2.length;
	}
}
