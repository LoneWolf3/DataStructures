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

public class PrintListInReverse {
    //This Function will print the linked list from end
    public static void printListFromEnd(Node head) {
		if(head == null)    
	                   return;
	       	printListFromEnd(head.next);
	       	System.out.println(head.data);
	    }
	public static void main(String[] args) {
		LinkList ll = new LinkList();
		
	
	}
}
