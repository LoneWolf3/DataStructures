package com.sac.binary.tree;
/*Copyright (c) Dec 21, 2014 CareerMonk Publications and others.
 * E-Mail           	: info@careermonk.com 
 * Creation Date    	: 2015-01-10 06:15:46 
 * Last modification	: 2006-05-31 
               by		: Narasimha Karumanchi 
 * File Name			: SearchBinaryTreeLevelOrder.java
 * Book Title			: Data Structures And Algorithms Made In Java
 * Warranty         	: This software is provided "as is" without any 
 * 							warranty; without even the implied warranty of 
 * 							merchantability or fitness for a particular purpose. 
 * 
 */



import java.util.LinkedList;
import java.util.Queue;

public class FindNodeBnryTreeITR {
	public static boolean findInBT(BinaryTreeNode root, int data) {
		if (root == null)
			return false;
		Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
		q.offer(root);
		while (!q.isEmpty()) {
			BinaryTreeNode tmp = q.poll();
			if (tmp.getData() == data) {
				return true;
			}
			if (tmp != null) {
				if (tmp.getLeft() != null)
					q.offer(tmp.getLeft());
				if (tmp.right != null)
					q.offer(tmp.right);
			}
		}
		return false;
	}

	public static void main(String[] args) {
		BinaryTreeNode root = new BinaryTreeNode(10);
		root.left = new BinaryTreeNode(20);
		root.right = new BinaryTreeNode(30);
		root.left.left = new BinaryTreeNode(5);
		root.left.right = new BinaryTreeNode(25);
		root.right.left = new BinaryTreeNode(35);
		root.right.right = new BinaryTreeNode(12);
		System.out.println(findInBT(root, 5));
	}
}
