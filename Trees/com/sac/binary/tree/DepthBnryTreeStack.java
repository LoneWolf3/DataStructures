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

import java.util.Stack;

public class DepthBnryTreeStack {
	// Returns the depth of this binary tree. The depth of a binary tree is the
	// length of the longest path from this node to a leaf. The depth of a
	// binary tree with no descendants (that is, just a leaf) is zero.
	public static int maxDepthIterative(BinaryTreeNode root) {
		if (root == null)
			return 0;
		Stack<BinaryTreeNode> s = new Stack<BinaryTreeNode>();
		s.push(root);
		int maxDepth = 0;
		BinaryTreeNode prev = null;
		while (!s.isEmpty()) {
			BinaryTreeNode curr = s.peek();
			if (prev == null || prev.getLeft() == curr || prev.right == curr)

			{
				if (curr.getLeft() != null)

				{
					s.push(curr.getLeft());
				} else if (curr.right != null)

				{
					s.push(curr.right);
				}
			} else if (curr.getLeft() == prev)

			{
				if (curr.right != null) {
					s.push(curr.right);
				}
			} else {
				s.pop();
			}
			prev = curr;
			if (s.size() > maxDepth)
				maxDepth = s.size();
		}
		return maxDepth;
	}

	public static void main(String[] args) {
		BinaryTreeNode root = new BinaryTreeNode(10);
		root.left = new BinaryTreeNode(20);
		root.right = new BinaryTreeNode(30);
		root.left.left = new BinaryTreeNode(5);
		root.left.right = new BinaryTreeNode(25);
		root.right.left = new BinaryTreeNode(35);
		root.right.right = new BinaryTreeNode(12);
		System.out.println(maxDepthIterative(root));
	}

}
