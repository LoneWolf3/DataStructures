package com.sac.binary.tree;

// Recursive optimized Java program to find the diameter of a

// Binary Tree

/* Class to print the Diameter */
public class DiaMeterOftree {

	/* Method to calculate the diameter and return it to main */
	static int diameter(BinaryTreeNode root) {
		/* base case if tree is empty */
		if (root == null)
			return 0;

		/* get the height of left and right sub trees */
		int lheight = height(root.left);
		int rheight = height(root.right);

		/* get the diameter of left and right subtrees */
		int ldiameter = diameter(root.left);
		int rdiameter = diameter(root.right);

		/*
		 * Return max of following three 1) Diameter of left subtree 2) Diameter
		 * of right subtree 3) Height of left subtree + height of right subtree
		 * + 1
		 */
		return Math.max(lheight + rheight + 1, Math.max(ldiameter, rdiameter));

	}

	/*
	 * The function Compute the "height" of a tree. Height is the number f nodes
	 * along the longest path from the root node down to the farthest leaf node.
	 */
	static int height(BinaryTreeNode left) {
		/* base case tree is empty */
		if (left == null)
			return 0;

		/*
		 * If tree is not empty then height = 1 + max of left height and right
		 * heights
		 */
		int heightL   =height(left.left);
		int heightR = height(left.right);
		return (1 + Math.max(heightL,heightR ));
	}

	public static void main(String args[]) {
		BinaryTreeNode root = new BinaryTreeNode(1);
		root.left = new BinaryTreeNode(2);
		root.right = new BinaryTreeNode(3);
		root.left.left = new BinaryTreeNode(4);
		root.left.right = new BinaryTreeNode(5);
		root.right.left = new BinaryTreeNode(6);
		root.right.right = new BinaryTreeNode(7);
		

		System.out.println("The diameter of given binary tree is : " + diameter(root));
	}

}