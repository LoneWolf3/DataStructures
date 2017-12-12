package com.sac.notations;

/**
 * Why Asymptotic Notation?
 * 
 * From the above discussion (for all the three notations: worst case, best case
 * and average case), we can easily understand that, in every case for a given
 * function we are trying to find other function which approximates at higher
 * values of . That means, is also a curve which approximates at higher values
 * of . In mathematics we call such curve as .
 * 
 * Big O notation gives the upper bound of the given function. Generally we
 * represent it as O() . e.g = f(n) = npow4 +npow2... then O = npow4.
 * 
 * 
 * Omega notations give lower bound of problems as alternatte to upper bound big
 * O
 * 
 * Theta notations tells wheater upper bound and lower blund equal or not or
 * average runnig time.
 * 
 * Why is it called Asymptotic Analysis? From the above discussion (for all the
 * three notations: worst case, best case and average case), we can easily
 * understand that, in every case for a given function we are trying to find
 * other function which approximates at higher values of . That means, is also a
 * curve which approximates at higher values of . In mathematics we call such
 * curve as
 * 
 * @author ssachdev
 *
 */
public class AssymtoticNotations {
	/**
	 * O(1) O(1) describes an algorithm that will always execute in the same
	 * time (or space) regardless of the size of the input data set.
	 * 
	 * 
	 * array: accessing any element fixed-size stack: push and pop methods
	 * fixed-size queue: enqueue and dequeue methods
	 */

	boolean IsFirstElementNull(String[] strings) {
		if (strings[0] == null) {
			return true;
		}
		return false;
	}

	/**
	 * O(N) O(N) describes an algorithm whose performance will grow linearly and
	 * in direct proportion to the size of the input data set. The example below
	 * also demonstrates how Big O favours the worst-case performance scenario;
	 * a matching string could be found during any iteration of the for loop and
	 * the function would return early, but Big O notation will always assume
	 * the upper limit where the algorithm will perform the maximum number of
	 * iterations.
	 */

	boolean ContainsValue(String[] strings, String value) {
		for (int i = 0; i < strings.length; i++) {
			if (strings[i] == value) {
				return true;
			}
		}
		return false;
	}

	/**
	 * O(N2) O(N2) represents an algorithm whose performance is directly
	 * proportional to the square of the size of the input data set. This is
	 * common with algorithms that involve nested iterations over the data set.
	 * Deeper nested iterations will result in O(N3), O(N4) etc.
	 */
	boolean ContainsDuplicates(String[] strings) {
		for (int i = 0; i < strings.length; i++) {
			for (int j = 0; j < strings.length; j++) {
				if (i == j) // Don't compare with self
				{
					continue;
				}

				if (strings[i] == strings[j]) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * O(log N) basically means time goes up linearly while the n goes up
	 * exponentially. So if it takes 1 second to compute 10 elements, it will
	 * take 2 seconds to compute 100 elements, 3 seconds to compute 1000
	 * elements, and so on.
	 * 
	 * In our example: when there were 15 elements, we needed 4 comparisons:
	 * log215 + 1 = 3 + 1 = 4
	 * 
	 * 
	 * Since you can only split a space of n elements in half log_2(n) times
	 * before you're only looking at one item, you must have zeroed in on the
	 * desired element after log_2(n) steps at the worst. Therefore, binary
	 * search works in O(log(n)) time.
	 * 
	 */

}
