/*Copyright (c) Dec 22, 2014 CareerMonk Publications and others.
 * E-Mail           	: info@careermonk.com 
 * Creation Date    	: 2015-01-10 06:15:46 
 * Last modification	: 2006-05-31 
               by		: Narasimha Karumanchi 
 * File Name			: RemoveDuplicatesHashing.java
 * Book Title			: Data Structures And Algorithms Made In Java
 * Warranty         	: This software is provided "as is" without any 
 * 							warranty; without even the implied warranty of 
 * 							merchantability or fitness for a particular purpose. 
 * 
 */

package com.interview.linklist;

import java.util.HashMap;
import java.util.Map;

public class RemoveDuplicatesHashing {
	// using a temporary buffer O(n)
	public static void removeDuplicates(Node head) {
		Map<Integer, Boolean> mapper = new HashMap<Integer, Boolean>();
		Node curr = head;
		Node next;
		while (curr.next != null) {
			next = curr.next;
			if (mapper.get(next.data) != null) {
				// already seen it, so delete
				curr.next = (next.next);
			} else {
				mapper.put(next.data, true);
				curr = curr.next;
			}
		}
	}
}
