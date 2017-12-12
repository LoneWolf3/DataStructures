package com.sac.strings.Tough;
/***longest common pattern in two strings***/

import java.util.Set;
import java.util.TreeSet;

public class LongestCommonPattren000 {
	public static void main(String[] args) {

		String firstString = "sachin";
		String secondString = "xyzsac";

		String maxString = "";
		String secondsubString ="";

		int index = 0;
		int secondStringlastIndex = 1;
		while (index < secondString.length()) {
			for (int i = 0; i < firstString.length(); i++)
			{

				int lastIndex = firstString.length() - i;
				if(secondStringlastIndex<=secondString.length())
				 secondsubString = secondString.substring(secondString.length() - secondStringlastIndex);
					String subString = firstString.substring(0, lastIndex);
					if (secondsubString.contains(subString)
							&& subString.length() > maxString.length()) {
						maxString = subString;
					}

				
			}
			index++;
			secondStringlastIndex++;
			
		}

		System.out.println(maxString);

	}

}