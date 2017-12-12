package com.sac.tree.learnt;
/*Copyright (c) Dec 21, 2014 CareerMonk Publications and others.
 * E-Mail           	: info@careermonk.com 
 * Creation Date    	: 2015-01-10 06:15:46 
 * Last modification	: 2006-05-31 
               by		: Narasimha Karumanchi 
 * File Name			: DeepestNode.java
 * Book Title			: Data Structures And Algorithms Made In Java
 * Warranty         	: This software is provided "as is" without any 
 * 							warranty; without even the implied warranty of 
 * 							merchantability or fitness for a particular purpose. 
 * 
 */

import java.util.LinkedList;
import java.util.Queue;

public class DeepestNodeBnryTree {
	// The last node processed from queue in level order is the deepest node in
	// binary tree.
	public static BinarySearchTreeNode deepestNodeinBinaryTree(BinarySearchTreeNode root) {
		BinarySearchTreeNode tmp = null;
		if (root == null)
			return null;
		Queue<BinarySearchTreeNode> q = new LinkedList<BinarySearchTreeNode>();
		q.offer(root);
		while (!q.isEmpty()) {
			tmp = q.poll();
			if (tmp.getLeft() != null)
				q.offer(tmp.getLeft());
			if (tmp.right != null)
				q.offer(tmp.right);
		}
		return tmp;
	}

	public static void main(String[] args) {
		BinarySearchTreeNode root = new BinarySearchTreeNode(1);
		root.left = new BinarySearchTreeNode(2);
		root.right = new BinarySearchTreeNode(3);
		root.left.left = new BinarySearchTreeNode(4);
		root.left.right = new BinarySearchTreeNode(5);
		root.right.left = new BinarySearchTreeNode(6);
		root.right.right = new BinarySearchTreeNode(7);
		System.out.println(deepestNodeinBinaryTree(root));
	}

}
