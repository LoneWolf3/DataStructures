package com.sac.Linked.tree;


public class BinaryTre2DoubleLinkedList {
	static BinarySearchTreeNode root;

	// head --> Pointer to head BinarySearchTreeNode of created doubly linked
	// list
	static BinarySearchTreeNode head;

	// Initialize previously visited BinarySearchTreeNode as NULL. This is
	// static so that the same value is accessible in all recursive
	// calls
	static BinarySearchTreeNode prev = null;

	// A simple recursive function to convert a given Binary tree
	// to Doubly Linked List
	// root --> Root of Binary Tree
	static void BinaryTree2DoubleLinkedList(BinarySearchTreeNode root) {
		// Base case
		if (root == null)
			return;

		// Recursively convert left subtree
		BinaryTree2DoubleLinkedList(root.left);

		// Now convert this BinarySearchTreeNode
		if (prev == null)
			head = root;
		else {
			root.left = prev;
			prev.right = root;
		}
		prev = root;

		// Finally convert right subtree
		BinaryTree2DoubleLinkedList(root.right);
	}

	static /* Function to print nodes in a given doubly linked list */
	void printList(BinarySearchTreeNode BinarySearchTreeNode) {
		while (BinarySearchTreeNode != null) {
			System.out.print(BinarySearchTreeNode.data + " ");
			BinarySearchTreeNode = BinarySearchTreeNode.right;
		}
	}

	// Driver program to test above functions
	public static void main(String[] args) {
		// Let us create the tree as shown in above diagram
		BinarySearchTreeNode root = null;
		root = new BinarySearchTreeNode(10);
		root.left = new BinarySearchTreeNode(12);
		root.right = new BinarySearchTreeNode(15);
		root.left.left = new BinarySearchTreeNode(25);
		root.left.right = new BinarySearchTreeNode(30);
		root.right.left = new BinarySearchTreeNode(36);

		// convert to DLL
		BinaryTree2DoubleLinkedList(root);

		// Print the converted List
		printList(head);

	}
}