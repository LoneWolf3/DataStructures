package com.array;

/**
 * hey guys, What about using a trie structure to represent those numbers? In
 * which you have each number split in 8 groups of 8 bits (or lower no. of
 * bits). So, for ex. 123456789123456789 (00000000 11011011 01001101 10100101
 * 11010110 01101000 00101111 100010101) will be represented by the path:
 * 00000000 --> 11011011 --> 01001101 --> 10100101 --> 11010110 --> 01101000 -->
 * 00101111 --> 100010101 in the trie structure.
 * 
 * After the entire trie structure was built it will much easier to find a
 * number which is not in the list.
 * 
 * If the list is too big to fit into memory, we can store the trie structure on
 * the disk.
 * 
 * This is how Lucene stores the numeric values in its index for a fast search.
 * 
 * @author ssachdev
 * 
 */
public class Find64BitElementNotInList {

}
