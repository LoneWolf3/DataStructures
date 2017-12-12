package com.interview.linklist;

/**
 * http://www.geeksforgeeks.org/reverse-alternate-k-nodes-in-a-singly-linked-list/
 * Test case k is even odd number of nodes are even odd k is less than or equal
 * to 1.
 */
public class ReverseAlternateKNodes {

	/*
	 * Reverses alternate k nodes and returns the pointer to the new head node
	 */
	Node kAltReverse(Node node, int k) {
		Node current = node;
		Node next = null, prev = null;
		int count = 0;

		/* 1) reverse first k nodes of the linked list */
		while (current != null && count < k) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
			count++;
		}

		/*
		 * 2) Now head points to the kth node. So change next of head to (k+1)th
		 * node
		 */
		if (node != null) {
			node.next = current;
		}

		/*
		 * 3) We do not want to reverse next k nodes. So move the current
		 * pointer to skip next k nodes
		 */
		count = 0;
		while (count < k - 1 && current != null) {
			current = current.next;
			count++;
		}

		/*
		 * 4) Recursively call for the list starting from current->next. And
		 * make rest of the list as next of first node
		 */
		if (current != null) {
			current.next = kAltReverse(current.next, k);
		}

		/* 5) prev is new head of the input list */
		return prev;
	}

	public static void main(String args[]) {
		LinkList ll = new LinkList();
		Node head = null;
		head = ll.addNode(1, head);
		head = ll.addNode(2, head);
		head = ll.addNode(3, head);
		head = ll.addNode(4, head);
		head = ll.addNode(5, head);
		head = ll.addNode(6, head);
		head = ll.addNode(7, head);
		head = ll.addNode(8, head);
		head = ll.addNode(9, head);

		ReverseAlternateKNodes ra = new ReverseAlternateKNodes();
		head = ra.kAltReverse(head, 3);
		ll.printList(head);
	}
}
