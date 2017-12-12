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

public class PartitionList {
	public static Node partition(Node head, int K) {
		Node root = Node.newNode(0);
		Node pivot = Node.newNode(K);
		Node rootNext = root, pivotNext = pivot;
		Node currentNode = head;
		while (currentNode != null) {
			Node next = currentNode.next;
			if (currentNode.data >= K) {
				pivotNext.next = currentNode;
				pivotNext = currentNode;
				pivotNext.next = null;
			} else {
				rootNext.next = currentNode;
				rootNext = currentNode;
			}
			currentNode = next;
		}
		rootNext.next = pivot.next;
		return root.next;
	}

	public static void main(String[] args) {
		
	}
}
