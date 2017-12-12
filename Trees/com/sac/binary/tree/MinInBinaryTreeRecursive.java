package com.sac.binary.tree;

/*Copyright (c) Dec 21, 2014 CareerMonk Publications and others.
 * E-Mail           	: info@careermonk.com 
 * Creation Date    	: 2015-01-10 06:15:46 
 * Last modification	: 2006-05-31 
               by		: Narasimha Karumanchi 
 * File Name			: MinInBinaryTreeRecursive.java
 * Book Title			: Data Structures And Algorithms Made In Java
 * Warranty         	: This software is provided "as is" without any 
 * 							warranty; without even the implied warranty of 
 * 							merchantability or fitness for a particular purpose. 
 * 
 */




public class MinInBinaryTreeRecursive {
	public static int minInBinaryTree(BinaryTreeNode root){
	    int minValue = Integer.MAX_VALUE;
	   
	    if (root != null){
	        int leftMin = minInBinaryTree(root.getLeft());
	        int rightMin = minInBinaryTree(root.right);
	         
	        if (leftMin < rightMin)
	        	minValue = leftMin;
	        else
	        	minValue = rightMin;
	             
	        if (root.data < minValue)
	        	minValue = root.data;
	    }
	    return minValue;
	}
	
	
	public static void main(String[] args) {
		BinaryTreeNode root = new BinaryTreeNode(4);
		root.left = new BinaryTreeNode(2);
		root.right = new BinaryTreeNode(7);
		root.left.left = new BinaryTreeNode(5);
		root.left.right = new BinaryTreeNode(6);
		root.right.left = new BinaryTreeNode(3);
		root.right.right = new BinaryTreeNode(1);
		System.out.println(minInBinaryTree(root));
	}
}
