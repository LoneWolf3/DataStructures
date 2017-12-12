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



public class MirrorExistsBetweenTree {
    public boolean areMirrors(BinaryTreeNode  root1, BinaryTreeNode  root2) {
    	if(root1 == null && root2 == null) 	
            return true;
    	if(root1 == null || root2 == null) 
            return false;
    	if(root1.data != root2.data) 
             return false;
    	else return (areMirrors(root1.getLeft(), root2.right) && areMirrors(root1.right, root2.getLeft()));
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
		
	}

}
