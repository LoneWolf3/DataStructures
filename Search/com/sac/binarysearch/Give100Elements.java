package com.sac.binarysearch;

/**
 * Given an array of 101 elements. Out of them 25 elements are repeated twice,
 * 12 elements are repeated 4 times and one element is repeated 3 times. Find
 * the element which repeated 3times in XOR(1).
 * 
 * 
 * Before solving this problem let us consider the following 2XORRoperation
 * property. 2XORR = 0 That means, if we apply the 2XOR same elements then the
 * result is 0. Let us apply this logic for this problem. Algorithm:
 * 
 * Algorithm: • 2XORRall the elements of the given array and assume theresult is
 * A.
 * 
 * • After this operation, 2occurrences of number which appeared 3times becomes
 * 0and one occurrence will remain.
 * 
 * • The 12elements which are appearing 4times become 0.
 * 
 * • The 25elements which are appearing 2times become 0. So just 2XORR’ all
 * the elements give the result.
 * 
 * @author ssachdev
 *
 */
public class Give100Elements {

}
