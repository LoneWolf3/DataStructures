package com.sac.string.learnt;

public class CompactString {

	public static String compress(String str) {
		if (str.isEmpty()) {
			return "";
		}

		char[] chars = str.toCharArray();
		StringBuilder builder = new StringBuilder();

		int count = 1;
		char prev = chars[0];
		// Loop throuh string
		for (int i = 1; i < chars.length; i++) {
			char current = chars[i];
			// Check if prev char is same as current.
			if (current == prev) {
				count++;
			}
			// Append previous and count
			else {
				builder.append(prev).append(count);
				count = 1;
			}
			// before existing loop assign previous = current
			prev = current;
		}
		return builder.append(prev).append(count).toString();
	}

	public static void main(String[] args) {
		System.out.println(compress("aaabb"));
	}
}
