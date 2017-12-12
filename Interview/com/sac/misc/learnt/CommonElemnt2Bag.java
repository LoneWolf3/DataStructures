package com.sac.misc.learnt;

/**
 * google-interview-questions 2 of 2 votes 21 Answers
 * 
 * 1000 elements in one bag and 1 million elements in another. how do you find
 * common elements among them. Also give the complexity of your solution.
 * 
 * @author ssachdev
 * 
 */
public class CommonElemnt2Bag {
		/**
	 * First put all the 1000 elements in an hash table. Then take each of the
	 * one million elements and look for them in the hash table. If match is
	 * found report them as a solution.
	 * 
	 * Also works if you don't have enough memory to bring all the 1mil
	 * elements. Then just drag a chunk to disk, check and then drag the next
	 * chunk.
	 * 
	 * Space Complexity : O(m) Time Complexity : O(n)
	 * 
	 * m size of smaller bag n: size of larger bag
	 */
}
