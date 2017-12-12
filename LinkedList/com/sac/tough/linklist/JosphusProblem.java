package com.sac.tough.linklist;

public class JosphusProblem {
	private Node start;
	private int count;

	public void append(int x) {
		count++;
		Node temp = new Node(x);
		if (start == null) {
			start = temp;
		} else {
			Node tp = start;
			while (tp.link != start) {
				tp = tp.link;
			}
			tp.link = temp;
		}
		temp.link = start;
	}

	public void addBeg(int x) {
		count++;
		Node temp = new Node(x);
		if (start == null) {
			temp.link = temp;
		} else {
			Node tp = start;
			while (tp.link != start) {
				tp = tp.link;
			}
			tp.link = temp;
			temp.link = start;
		}
		start = temp;
	}

	public void addAt(int pos, int x) {
		Node temp, tp;
		temp = new Node(x);
		tp = start;
		for (int i = 1; i <= pos; i++) {
			if (tp.link == start)
				break;
			tp = tp.link;
		}
		temp.link = tp.link;
		tp.link = temp;
		count++;
	}

	public void displayList() {
		if (start == null)
			System.out.println("List is empty..");
		else {
			Node temp = start;
			System.out.print("->");
			while (temp.link != start) {
				System.out.println(" " + temp.data);
				temp = temp.link;
			}
			System.out.println(temp.data + " ->");
		}
	}

	public void deleteAt(int position) {
		Node current = start;
		Node previous = start;
		for (int i = 0; i < position; i++) {
			if (current.link == start)
				break;
			previous = current;
			current = current.link;
		}
		System.out.print(current.data);
		if (position == 0)
			deleteFirst();
		else
			previous.link = current.link;
		count--;
	}

	public int deleteNode(Node node) {
		Node current = start;
		Node previous = start;
		int data = node.data;
		while (current.data != data) {
			if (current.link == start)
				break; // Node does not exists in circular linked list
			previous = current;
			current = current.link;
		}
		previous.link = current.link;
		count--;
		return data;// returning the deleted data
	}

	public void deleteFirst() {
		Node temp = start;
		while (temp.link != start) {
			temp = temp.link;
		}
		temp.link = start.link;
		start = start.link;
		count--;
	}

	public int getCount() {
		return count;
	}

	/* Extra method for Josephus problem */
	public void game(int countToDeath, int persons) {

		Node current = start;
		int caller = 0;
		while (true) {
			caller = current.data;
			System.out.print(caller + "Says->");
			for (int i = 0; i < countToDeath; i++) {
				current = current.link;
			}
			start = current.link;
			if (getCount() > 1) {
				// comparing caller with person going to be dead
				if (caller == current.data)
					System.out.println("WTF!! I will have to kill myself ! :( " + deleteNode(current));
				else
					System.out.println("I do not want to say but you must die Mr. no:" + deleteNode(current));
			} else {
				System.out.println("Thank God ! I saved myself :)");
				break;
			}

			current = start;
		}
	}

	private static class Node {
		int data;
		Node link;

		public Node(int data) {
			this.data = data;
		}

		@SuppressWarnings("unused")
		public Node(int data, Node link) {
			this.data = data;
			this.link = link;
		}
	}
}