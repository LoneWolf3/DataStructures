package com.interview.linklist;

public class SimpleLinkedList {
	// reference to the head node.
	private Node head;

	public static void main(String[] args) {
		SimpleLinkedList obj = new SimpleLinkedList();
		obj.add(2);
		obj.add(3);
	}

	// LinkedList constructor
	public SimpleLinkedList() {
		// this is an empty list, so the reference to the head node
		// is set to a new node with no data
		head = new Node(null);
	}

	public void add(Object data)
	// post: appends the specified element to the end of this list.
	{
		Node temp = new Node(data);
		Node current = head;
		// starting at the head node, crawl to the end of the list
		while (current.getNext() != null) {
			current = current.getNext();
		}
		// the last node's "next" reference set to our new node
		current.setNext(temp);
	}

	public boolean remove(int index)
	// post: removes the element at the specified position in this list.
	{
		Node current = head;
		for (int i = 1; i < index; i++) {
			if (current.getNext() == null)
				return false;

			current = current.getNext();
		}
		current.setNext(current.getNext().getNext());
		return true;
	}

	private class Node {
		// reference to the next node in the chain,
		// or null if there isn't one.
		Node next;
		// data carried by this node.
		// could be of any type you need.
		Object data;

		// Node constructor
		public Node(Object _data) {
			next = null;
			data = _data;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node _next) {
			next = _next;
		}
	}
}
