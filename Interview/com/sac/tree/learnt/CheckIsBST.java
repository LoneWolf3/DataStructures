package com.sac.tree.learnt;

//Java implementation to check if given Binary tree
//is a BST or not

/* Class containing left and right child of current
BinarySearchTreeNode and key value*/

public class CheckIsBST {
	// Root of the Binary Tree
	BinarySearchTreeNode root;

	// To keep tract of previous BinarySearchTreeNode in Inorder Traversal
	BinarySearchTreeNode prev;

	boolean isBST() {
		prev = null;
		return isBST(root);
	}

	/*
	 * Returns true if given search tree is binary search tree (efficient
	 * version)
	 */
	boolean isBST(BinarySearchTreeNode BinarySearchTreeNode) {
		// traverse the tree in inorder fashion and
		// keep a track of previous BinarySearchTreeNode
		if (BinarySearchTreeNode != null) {
			if (!isBST(BinarySearchTreeNode.left))
				return false;

			// allows only distinct values BinarySearchTreeNode
			if (prev != null && BinarySearchTreeNode.data <= prev.data)
				return false;
			prev = BinarySearchTreeNode;
			return isBST(BinarySearchTreeNode.right);
		}
		return true;
	}

	/* Driver program to test above functions */
	public static void main(String args[]) {
		CheckIsBST tree = new CheckIsBST();
		tree.root = new BinarySearchTreeNode(4);
		tree.root.left = new BinarySearchTreeNode(2);
		tree.root.right = new BinarySearchTreeNode(5);
		tree.root.left.left = new BinarySearchTreeNode(1);
		tree.root.left.right = new BinarySearchTreeNode(3);

		if (tree.isBST())
			System.out.println("IS BST");
		else
			System.out.println("Not a BST");
	}
}