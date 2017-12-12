package com.sac.tree.learnt;

/*Copyright (c) Dec 21, 2014 CareerMonk Publications and others.
 * E-Mail           	: info@careermonk.com 
 * Creation Date    	: 2015-01-10 06:15:46 
 * Last modification	: 2006-05-31 
               by		: Narasimha Karumanchi 
 * File Name			: SumOfElementsInBinaryTree.java
 * Book Title			: Data Structures And Algorithms Made In Java
 * Warranty         	: This software is provided "as is" without any 
 * 							warranty; without even the implied warranty of 
 * 							merchantability or fitness for a particular purpose. 
 * 
 */

public class SumOfElementsInBinaryTree {
	public static int addBT(BinarySearchTreeNode root) {
		if (root == null)
			return 0;
		else {
			int a = root.getData();
			int b = addBT(root.getLeft());
			int c = addBT(root.getRight());
			return a + b + c;
		}
	}

	public static void main(String[] args) {
		int[] arr = { 2 };
		BinarySearchTreeNode root = new BinarySearchTreeNode(1);
		root.left = new BinarySearchTreeNode(2);
		root.right = new BinarySearchTreeNode(3);
		root.left.left = new BinarySearchTreeNode(4);
		root.left.right = new BinarySearchTreeNode(5);
		root.right.left = new BinarySearchTreeNode(6);
		root.right.right = new BinarySearchTreeNode(7);
		System.out.println(addBT(root));
	}

}
