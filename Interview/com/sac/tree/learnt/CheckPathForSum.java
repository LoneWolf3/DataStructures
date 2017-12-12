package com.sac.tree.learnt;
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

public class CheckPathForSum {
	public static boolean hasPathSum(BinarySearchTreeNode root, int sum) {
		if (root == null && sum == 0)
			return true;

		if (root == null)
			return false;

		if (hasPathSum(root.getLeft(), sum - root.data)) {
			return true;
		}

		if (hasPathSum(root.right, sum - root.data)) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		BinarySearchTreeNode root = new BinarySearchTreeNode(1);
		root.left = new BinarySearchTreeNode(5);
		root.right = new BinarySearchTreeNode(3);
		root.left.left = new BinarySearchTreeNode(4);
		root.left.right = new BinarySearchTreeNode(2);
		root.right.left = new BinarySearchTreeNode(6);
		root.right.right = new BinarySearchTreeNode(7);
		System.out.println(hasPathSum(root, 10));
	}
}