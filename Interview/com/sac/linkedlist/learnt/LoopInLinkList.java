package com.sac.linkedlist.learnt;


/**
 * Date 04/17/2016
 * 
 * @author tusroy
 *
 *         Given a linked list, determine if it has a cycle in it.
 *
 *         Time complexity O(n) Space complexity O(1)
 *
 *         https://leetcode.com/problems/linked-list-cycle/
 */
public class LoopInLinkList {

	public void hasCycle(Node head) {
		Node slow = head;
		Node fast = head.next;

		// Search for loop using slow and fast pointers
		while (fast != null && fast.next != null) {
			if (slow == fast) {
				break;
			}
			slow = slow.next;
			fast = fast.next.next;
		}

		/* If loop exists */
		if (slow == fast) {
			slow = head;
			while (slow != fast.next) {
				slow = slow.next;
				fast = fast.next;
			}

			/* since fast->next is the looping point */
			fast.next = null; /* remove loop */

		}
	}

	public static void main(String args[]) {
		LinkList ll = new LinkList();
		Node head = null;
		head = ll.addNode(1, head);
		head = ll.addNode(2, head);
		head = ll.addNode(3, head);
		head = ll.addNode(4, head);

		Node node1 = ll.find(head, 4);
		Node node2 = ll.find(head, 3);
		node1.next = node2;
		LoopInLinkList lll = new LoopInLinkList();
		lll.hasCycle(head);

	}
}
