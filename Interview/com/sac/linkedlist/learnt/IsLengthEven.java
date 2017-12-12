package com.sac.linkedlist.learnt;


public class IsLengthEven {

	static int isLengthEven(Node listHead) {
		// we need to traverse the List, until we reach the end
		// checking both conditions, NULL and the last Node
		while (listHead != null && listHead.next!= null) {
			// advance 2 nodes at a time
			listHead = listHead.next.next;
		}

		// if we are at a NULL, means EVEN, return 1
		if (listHead == null)
			return 1;
		else
			return 0;
	}

	public static void main(String[] args) {
		
	}
}
