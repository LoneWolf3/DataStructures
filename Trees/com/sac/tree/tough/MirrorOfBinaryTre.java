package com.sac.tree.tough;
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



public class MirrorOfBinaryTre {
	public static BinaryTreeNode MirrorOfBinaryTree(BinaryTreeNode root) {
		BinaryTreeNode  temp;
		if(root != null) {
			MirrorOfBinaryTree(root.getLeft());
			MirrorOfBinaryTree(root.right);
			/* swap the pointers in this node */
			temp  = root.getLeft();
			root.setLeft(root.right);
			root.right = temp;
		}
		return root;
	}
	
	public static void main(String[] args) {
		int[] arr = { 2 };
		BinaryTreeNode root = new BinaryTreeNode(1);
		root.left = new BinaryTreeNode(2);
		root.right = new BinaryTreeNode(3);
		root.left.left = new BinaryTreeNode(4);
		root.left.right = new BinaryTreeNode(5);
		root.right.left = new BinaryTreeNode(6);
		root.right.right = new BinaryTreeNode(7);
		System.out.println(MirrorOfBinaryTree(root));
	}
}
