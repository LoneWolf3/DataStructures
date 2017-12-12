package com.sac.binary.tree;


//Java program to check if Binary tree is sum tree or not

//A binary tree Node16
class Node16 {

	int data;
	Node16 left, right, nextRight;

	Node16(int item) {
		data = item;
		left = right = nextRight = null;
	}
}

public class PrintAncestors {

	static Node16 root;

	/*
	 * If target is present in tree, then prints the ancestors and returns true,
	 * otherwise returns false.
	 */
	boolean printAncestors(Node16 Node16, int target) {

		/* base cases */
		if (Node16 == null) {
			return false;
		}

		if (Node16.data == target) {
			return true;
		}

		/*
		 * If target is present in either left or right subtree of this Node16,
		 * then print this Node16
		 */
		if (printAncestors(Node16.left, target) || printAncestors(Node16.right, target)) {
			System.out.print(Node16.data + " ");
			return true;
		}

		/* Else return false */
		return false;
	}

	public static void main(String args[]) {
		PrintAncestors tree = new PrintAncestors();
		tree.root = new Node16(1);
		tree.root.left = new Node16(2);
		tree.root.right = new Node16(3);
		tree.root.left.left = new Node16(4);
		tree.root.left.right = new Node16(5);
		tree.root.left.left.left = new Node16(7);

		tree.printAncestors(root, 7);

	}
}

// This code has been contributed by Mayank Jaiswal