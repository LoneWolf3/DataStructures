/*Copyright (c) Dec 21, 2014 CareerMonk Publications and others.
 * E-Mail           	: info@careermonk.com 
 * Creation Date    	: 2015-01-10 06:15:46 
 * Last modification	: 2006-05-31 
               by		: Narasimha Karumanchi 
 * Book Title			: Data Structures And Algorithms Made In Java
 * Warranty         	: This software is provided "as is" without any 
 * 							warranty; without even the implied warranty of 
 * 							merchantability or fitness for a particular purpose. 
 * 
 */

package com.interview.linklist;

public class NthNodeFromEnd {
	private static int counter;

	public static Node nthNodeFromEnd(Node head, int Nth) {
		if (head != null) {
			nthNodeFromEnd(head.next, Nth);
			counter++;
			if (Nth == counter) {
				return head;
			}
		}
		return null;
	}

	public static Node nthNodeFromEndIterative(Node head, int Nth) {
		if (head == null) {
			return null;
		}
		Node nth = head;
		// Get nth from the start
		for (int i = 0; i < Nth; i++) {
			if (nth.next == null) {
				return null;
			}
			nth = nth.next;
		}
		// Move both the head and nth node so the difference between them is n
		// Thus we get the nth node from the end
		while (nth != null) {
			head = head.next;
			nth = nth.next;
		}
		return head;
	}

	public static void main(String[] args) {
	
	}

}
