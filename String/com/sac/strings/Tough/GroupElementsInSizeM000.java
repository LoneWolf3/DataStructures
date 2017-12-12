package com.sac.strings.Tough;

import java.util.HashSet;

/**
 * http://poarish.blogspot.ca/2016/01/rearrange-string-of-characters-so-that.
 * html
 * 
 * @author ssachdev
 *
 */
public class GroupElementsInSizeM000 {
	public static void main(String[] args) {

	}

	public static String rearrange(String str, int d) {
		int n = str.length();
		int bucketCount = d;
		int bigBucketCount = n % bucketCount;
		int smallBucketCount = bucketCount - bigBucketCount;
		int smallBucketHeight = n / d;
		int bigBucketHeight = smallBucketHeight + 1;
		int[][] arrangement = new int[bucketCount][28];
		int[] charCount = new int[26];
		for (int i = 0; i < n; i++) {
			int c = str.charAt(i) - 'a';
			charCount[c]++;
			// each character has to fit in one of the buckets
			if (charCount[c] > bigBucketHeight) {
				return null;
			}
		}
		// have the bucket height saved for quick access at index 27
		for (int i = 0; i < bigBucketCount; i++) {
			arrangement[i][27] = bigBucketHeight;
		}
		for (int i = 0; i < smallBucketCount; i++) {
			arrangement[bigBucketCount + i][27] = smallBucketHeight;
		}
		// try to put characters in different buckets to fill them completely
		if (!rearrange(arrangement, charCount, 0)) {
			return null;
		}
		// construct our string from the arrangement we found
		StringBuffer buffer = new StringBuffer(n);
		buffer.setLength(n);
		// there is a bucket for each offset
		for (int offset = 0; offset < bucketCount; offset++) {
			int startPos = offset;
			for (int i = 0; i < 26; i++) {
				// this character does not go in this bucket
				if (arrangement[offset][i] == 0)
					continue;
				for (int j = 0; j < charCount[i]; j++) {
					buffer.setCharAt(startPos, (char) (i + 'a'));
					startPos += d;
				}
			}
		}
		return buffer.toString();
	}

	private static boolean rearrange(int[][] arrangement, int[] charCount, int ind) {
		if (ind > 25)
			return true;
		if (charCount[ind] == 0)
			return rearrange(arrangement, charCount, ind + 1);
		// optimization: if bucket height is same doesnt matter which bucket we
		// put it in
		HashSet<String> bucketSeen = new HashSet();
		for (int i = 0; i < arrangement.length; i++) {
			if (!bucketSeen.contains(arrangement[i][26] + ":" + arrangement[i][27])
					&& arrangement[i][26] + charCount[ind] <= arrangement[i][27]) {
				arrangement[i][26] += charCount[ind];
				arrangement[i][ind] = 1;
				if (rearrange(arrangement, charCount, ind + 1))
					return true;
				arrangement[i][26] -= charCount[ind];
				arrangement[i][ind] = 0;
				bucketSeen.add(arrangement[i][26] + ":" + arrangement[i][27]);
			}
		}
		return false;
	}
}