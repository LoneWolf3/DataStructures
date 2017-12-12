package com.sac.tree.learnt;


public class FloorAndCieling {

	static BinarySearchTreeNode root;

	static BinarySearchTreeNode FloorInBST(BinarySearchTreeNode root, int data) {
		BinarySearchTreeNode prev = null;
		while (root != null) {
			if (root.data > data) {
				root = root.left;
			} else if (root.data < data) {
				// save the last minimum value
				prev = root;
				root = root.right;
			} else {
				// got equal value
				return root;
			}
		}
		return prev;
	}

	static int Ceil(BinarySearchTreeNode root2, int input) {

		// Base case
		if (root2 == null) {
			return -1;
		}

		// We found equal key
		if (root2.data == input) {
			return root2.data;
		}

		// If root's key is smaller, ceil must be in right subtree
		if (root2.data < input) {
			return Ceil(root2.right, input);
		}

		// Else, either left subtree or root has the ceil value
		int ceil = Ceil(root2.left, input);
		return (ceil >= input) ? ceil : root2.data;
	}

	// Driver program to test the above functions
	public static void main(String[] args) {
		BinarySearchTreeNode root = null;
		Tree redBlackTree = new Tree();
		redBlackTree.insertNode(4);
		redBlackTree.insertNode(7);
		redBlackTree.insertNode(3);
		redBlackTree.insertNode(1);
		redBlackTree.insertNode(5);

		System.out.println(5 + " " + Ceil(root, 5));

	}
}
