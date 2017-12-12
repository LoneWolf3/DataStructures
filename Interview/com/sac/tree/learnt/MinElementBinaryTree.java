package com.sac.tree.learnt;

public class MinElementBinaryTree {

	/*
	 * Given a non-empty binary search tree, return the minimum data value found
	 * in that tree. Note that the entire tree does not need to be searched.
	 */
	static int minvalue(BinarySearchTreeNode root) {
		BinarySearchTreeNode current = root;

		/* loop down to find the leftmost leaf */
		while (current.left != null) {
			current = current.left;
		}
		return (current.data);
	}

	// Driver program to test above functions
	public static void main(String[] args) {
		BinarySearchTreeNode root = null;
		Tree redBlackTree = new Tree();
		redBlackTree.insertNode(4);
		redBlackTree.insertNode(7);
		redBlackTree.insertNode(3);
		redBlackTree.insertNode(1);
		redBlackTree.insertNode(5);

		System.out.println(minvalue(root));

	}
}

// This code has been contributed by Mayank Jaiswal