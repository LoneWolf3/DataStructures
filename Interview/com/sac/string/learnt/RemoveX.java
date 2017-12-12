package com.sac.string.learnt;
/**
 * Check how replaca all works in java.
 * @author ssachdev
 *
 */
public class RemoveX {
	public static void main(String[] args) {
		boolean[] charSet = new boolean[256];
		String st = "This is a boy";
		st = st.replaceAll("is", "");
		System.out.println(st);
	}
}
