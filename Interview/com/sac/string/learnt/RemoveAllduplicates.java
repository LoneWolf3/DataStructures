package com.sac.string.learnt;

import java.util.HashMap;
import java.util.Map;

public class RemoveAllduplicates {

	public static void main(String[] args) {

		String input = "geeksforgeeks";

		char[] charArray = input.toCharArray();

		input = removeDuplicates(charArray);

		System.out.println(input);

	}

	private static String removeDuplicates(char[] charArray)

	{

		int inputIndex = 0, resiudalIndex = 0;

		Map<String, Integer> hash = new HashMap<String, Integer>();
		// iterate over charr array
		while (inputIndex < charArray.length)

		{
			// If hash map does not contains char add it and
			if (!hash.containsKey(String.valueOf(charArray[inputIndex])))

			{

				hash.put(String.valueOf(charArray[inputIndex]), 1);
				// Add the Charcter for first time only as we are bypassing
				// other charcters.
				charArray[resiudalIndex] = charArray[inputIndex];

				resiudalIndex++;

			}

			inputIndex++;

		}

		for (int i = resiudalIndex; i < charArray.length; i++)

		{

			charArray[i] = '\0';

		}

		return String.valueOf(charArray);

	}
}
