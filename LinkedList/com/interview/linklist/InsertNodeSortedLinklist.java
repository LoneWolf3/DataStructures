package com.interview.linklist;

public class InsertNodeSortedLinklist {
	/* function to insert a new_node in a list. */
	static Node sortedInsert(Node head, Node new_node) {
		Node current = null;

		/* Special case for head node */
		if (head == null || head.data >= new_node.data) {
			new_node.next = head;
			head = new_node;
		} else {

			/* Locate the node before point of insertion. */
			current = head;

			while (current.next != null && current.next.data < new_node.data)
				current = current.next;

			new_node.next = current.next;
			current.next = new_node;
		}
		return head ;
	}

	/* Utility functions */

	public static void main(String[] args) {
		LinkList ll = new LinkList();
		Node head = null;
		head = ll.addNode(11, head);
		head = ll.addNode(12, head);
		head = ll.addNode(14, head);
		ll.printList(sortedInsert(head, Node.newNode(13)));
	}
}
