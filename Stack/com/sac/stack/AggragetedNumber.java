package com.sac.stack;

public class AggragetedNumber {
	public static void main(String[] args) {
		System.out.println(isAggregatedNumber("1121325"));
	}

	static boolean isAggregatedNumber(String text) {
		int length = text.length() / 2;
		for (int i = 1; i <= length; i++) {
			for (int j = 2; j <= length; j++) {
				if (Match(i, j, text)) {
					return true;
				}
			}
		}
		return false;
	}

	static boolean Match(int i, int j, String text) {
		String first = text.substring(0, i);
		String second = text.substring(i, i * 2);
		StringBuilder buffer = new StringBuilder(first);
		buffer.append(second);
		while (buffer.length() < text.length()) {
			Integer x = (Integer.parseInt(first) + Integer.parseInt(second));
			String third = x.toString();
			buffer.append(third);
			first = second;
			second = third;
		}
		if (text.equals(buffer.toString()))
			return true;
		return false;
	}
}
