package com.sac.binary.tree;
/*Copyright (c) Dec 21, 2014 CareerMonk Publications and others.
 * E-Mail           	: info@careermonk.com 
 * Creation Date    	: 2015-01-10 06:15:46 
 * Last modification	: 2006-05-31 
               by		: Narasimha Karumanchi 
 * File Name			: LevelOrderTraversalInReverse.java
 * Book Title			: Data Structures And Algorithms Made In Java
 * Warranty         	: This software is provided "as is" without any 
 * 							warranty; without even the implied warranty of 
 * 							merchantability or fitness for a particular purpose. 
 * 
 */



import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LevelOrderReverse {
	public static void levelOrderTraversalInReverse(BinaryTreeNode root) {
		if (root == null)
			return;
		Stack<BinaryTreeNode> s = new Stack<BinaryTreeNode>();
		Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
		q.offer(root);
		while (!q.isEmpty()) {
			BinaryTreeNode tmp = q.poll();
			if (tmp.getLeft() != null)
				q.offer(tmp.getLeft());
			if (tmp.right != null)
				q.offer(tmp.right);
			s.push(tmp);
		}
		while (!s.isEmpty())
			System.out.println(s.pop().getData() + " ");
	}

	public static void main(String[] args) {
		BinaryTreeNode root = new BinaryTreeNode(1);
		root.left = new BinaryTreeNode(2);
		root.right = new BinaryTreeNode(3);
		root.left.left = new BinaryTreeNode(4);
		root.left.right = new BinaryTreeNode(5);
		root.right.left = new BinaryTreeNode(6);
		root.right.right = new BinaryTreeNode(7);
		levelOrderTraversalInReverse(root);
	}

}
