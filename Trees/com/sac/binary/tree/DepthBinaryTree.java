package com.sac.binary.tree;
/*Copyright (c) Dec 21, 2014 CareerMonk Publications and others.
 * E-Mail           	: info@careermonk.com 
 * Creation Date    	: 2015-01-10 06:15:46 
 * Last modification	: 2006-05-31 
               by		: Narasimha Karumanchi 
 * Book Title			: Data Structures And Algorithms Made In Java
 * Warranty         	: This software is provided "as is" without any 
 * 							warranty; without even the implied warranty of 
 * 							merchantability or fitness for a particular purpose. 
 * 
 */

public class DepthBinaryTree {
	public static int maxDepthRecursive(BinaryTreeNode root) {
		if (root == null)
			return 0;
		/* compute the depth of each subtree */
		int leftDepth = maxDepthRecursive(root.getLeft());
		int rightDepth = maxDepthRecursive(root.getRight());
		if (leftDepth > rightDepth) {
			return leftDepth = leftDepth + 1;
		} else {
			return rightDepth = rightDepth + 1;
		}

	}

	public static void main(String[] args) {
		BinaryTreeNode root = new BinaryTreeNode(1);
		root.left = new BinaryTreeNode(2);
		root.right = new BinaryTreeNode(3);
		root.left.left = new BinaryTreeNode(4);
		root.left.right = new BinaryTreeNode(5);
		root.right.left = new BinaryTreeNode(6);
		root.right.right = new BinaryTreeNode(7);

		System.out.println(maxDepthRecursive(root));
	}
}