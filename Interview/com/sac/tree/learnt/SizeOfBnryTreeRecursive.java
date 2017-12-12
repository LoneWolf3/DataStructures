package com.sac.tree.learnt;


/*Copyright (c) Dec 21, 2014 CareerMonk Publications and others.
 * E-Mail           	: info@careermonk.com 
 * Creation Date    	: 2015-01-10 06:15:46 
 * Last modification	: 2006-05-31 
               by		: Narasimha Karumanchi 
 * File Name			: BinaryTreeSize.java
 * Book Title			: Data Structures And Algorithms Made In Java
 * Warranty         	: This software is provided "as is" without any 
 * 							warranty; without even the implied warranty of 
 * 							merchantability or fitness for a particular purpose. 
 * 
 */




public class SizeOfBnryTreeRecursive {
	// Returns the total number of nodes in this binary tree (include the root in the count).
	public static int size(BinarySearchTreeNode root) {
		if(root==null){
			return 0;
		}
		int leftCount = size(root.left);
		int rightCount =  size(root.right);
		return 1 + leftCount + rightCount;
	}

	public static void main(String[] args) {
		BinarySearchTreeNode root = new BinarySearchTreeNode(10);
		root.left = new BinarySearchTreeNode(20);
		root.right = new BinarySearchTreeNode(30);
		root.left.left = new BinarySearchTreeNode(5);
		root.left.right = new BinarySearchTreeNode(25);
		root.right.left = new BinarySearchTreeNode(35);
		root.right.right = new BinarySearchTreeNode(12);
		System.out.println(size(root));
	}

}
