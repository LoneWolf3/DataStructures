package com.sac.binary.search.tree;

import com.sac.binary.search.tree.BST.Node;

//Java program to print BST in given range

//A binary tree Node1
class Node1 {

	int data;
	Node1 left, right;

	Node1(int d) {
		data = d;
		left = right = null;
	}
}

public class PrintingAllElemenInK1K2 {

	static Node1 root;

	/*
	 * The functions prints all the keys which in the given range [k1..k2]. The
	 * function assumes than k1 < k2
	 */
	static void Print(Node root, int k1, int k2) {

		/* base case */
		if (root == null) {
			return;
		}

		/*
		 * Since the desired o/p is sorted, recurse for left subtree first If
		 * root->data is greater than k1, then only we can get o/p keys in left
		 * subtree
		 */
		if (k1 < root.data) {
			Print(root.left, k1, k2);
		}

		/* if root's data lies in range, then prints root's data */
		if (k1 <= root.data && k2 >= root.data) {
			System.out.print(root.data + " ");
		}

		/*
		 * If root->data is smaller than k2, then only we can get o/p keys in
		 * right subtree
		 */
		if (k2 > root.data) {
			Print(root.right, k1, k2);
		}
	}

	public static void main(String[] args) {
		Node root = null;
		BST redBlackTree = new BST();
		root = redBlackTree.insert(root, 8);
		root = redBlackTree.insert(root, 5);
		root = redBlackTree.insert(root, 4);
		root = redBlackTree.insert(root, 6);
		root = redBlackTree.insert(root, 9);

		BST.displayTree(root);

		Print(root, 4, 9);
	}
}

// This code has been contributed by Mayank Jaiswal