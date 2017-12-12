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

public class MergeSortedListsIterative {
	public Node mergeTwoLists(Node head1, Node head2) {
        if(head1 == null)
            return head2;
        if(head2 == null)
            return head1;
        Node head =   Node.newNode(0);;
        if(head1.data <= head2.data){
            head = head1;
            head.next = mergeTwoLists(head1.next, head2);
        }else{
            head = head2;
            head.next = mergeTwoLists(head2.next, head1);
        }
        return head;
    }
}
