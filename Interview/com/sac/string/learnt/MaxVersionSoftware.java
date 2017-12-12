package com.sac.string.learnt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * ebay-interview-questions 4 of 4 votes 31 Answers
 * 
 * Find the latest version of released software. For e.g1. 2 and 2.2.. latest is
 * 2.2. eg2: 3.1 and 3.1.3... latest version is 3.1.3... version is passed as
 * string in above format.
 * 
 * @author ssachdev
 * 
 */
public class MaxVersionSoftware {

	public static void main(String[] args) {
		List<String> chapters = new ArrayList<String>();

		chapters.add("1.2.1");
		chapters.add("1.1");

		MaxVersionSoftware wer = new MaxVersionSoftware();
		System.out.println(wer.sortChapters(chapters));
	}

	private List<String> sortChapters(List<String> chapters) {
		List<String> sortedChapters = new ArrayList<String>(0);

		int index;
		for (String currChapter : chapters) {
			if (!sortedChapters.contains(currChapter)) {
				index = getInsertIndex(sortedChapters, currChapter);
				sortedChapters.add(index, currChapter);
				System.out.println(sortedChapters);
			}
		}

		return sortedChapters;
	}

	private int getInsertIndex(List<String> sortedChapters, String currChapter) {
		int insertIndex = 0;
		if (!sortedChapters.isEmpty()) {
			int sortedChapterSub;
			int currChapterSub;
			String[] currChapterAr = currChapter.split("\\.");
			String[] sortedChapterAr = sortedChapters.get(0).split("\\.");
				for (int subLvl = 0; subLvl < 5; subLvl++) {
					sortedChapterSub = parseToInt(sortedChapterAr, subLvl);
					currChapterSub = parseToInt(currChapterAr, subLvl);
					if (sortedChapterSub == currChapterSub) {
						continue;
					} else if (sortedChapterSub == 0 && currChapterSub == 0) {
						break;
					} else if (sortedChapterSub > currChapterSub) {
						if (checkIfProper(subLvl, sortedChapterAr, currChapterAr)) {
							return insertIndex;
						}
					}
				
				insertIndex++;
			}
		} else {
			return 0;
		}
		return insertIndex;
	}

	private int parseToInt(String[] subChapter, int subLvl) {
		try {
			return Integer.parseInt(subChapter[subLvl]);
		} catch (ArrayIndexOutOfBoundsException ae) {
			return 0;
		}
	}

	private boolean checkIfProper(int subLvl, String[] sortChapterAr, String[] currChapterAr) {
		int subLvlCk = subLvl - 1;
		int compChapterSub;
		int currChapterSub;
		while (subLvlCk > -1) {
			compChapterSub = parseToInt(sortChapterAr, subLvlCk);
			currChapterSub = parseToInt(currChapterAr, subLvlCk);
			if (compChapterSub < currChapterSub) {
				return false;
			}
			subLvlCk--;
		}
		return true;
	}

}