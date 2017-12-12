package com.sac.tree.learnt;
/*Copyright (c) Dec 21, 2014 CareerMonk Publications and others.
 * E-Mail           	: info@careermonk.com 
 * Creation Date    	: 2015-01-10 06:15:46 
 * Last modification	: 2006-05-31 
               by		: Narasimha Karumanchi 
 * File Name			: FindLevelwithMaxSum.java
 * Book Title			: Data Structures And Algorithms Made In Java
 * Warranty         	: This software is provided "as is" without any 
 * 							warranty; without even the implied warranty of 
 * 							merchantability or fitness for a particular purpose. 
 * 
 */

import java.util.LinkedList;
import java.util.Queue;

public class LevelwithMaxSumBnryTree {

	public static void maxSumLevel(BinarySearchTreeNode root) {
		if (root == null) {
			System.out.println("Tree is empty");
			return;
		}
		Queue<BinarySearchTreeNode> queue = new LinkedList<BinarySearchTreeNode>();
		queue.offer(root);
		// level delimiter
		queue.offer(null);

		int maxSum = 0;
		int level = 0;
		// default root level
		int localLevel = 0;
		int localSum = 0;
		while (!queue.isEmpty()) {
			BinarySearchTreeNode node = queue.poll();
			// Level change
			if (null == node) {
				if (!queue.isEmpty()) {
					// level delimiter
					queue.offer(null);
				}

				if (localSum > maxSum) {
					maxSum = localSum;
					level = localLevel;
				}
				// Reset the level sum for next level calculation
				localSum = 0;
				localLevel++;
			} else {
				if (node.left != null) {
					queue.offer(node.left);
				}
				if (node.right != null) {
					queue.offer(node.right);
				}
				localSum = localSum + node.data;
			}
		}
		System.out.println(" Max Sum " + maxSum + " is at Level " + level);
	}

	public static void main(String[] args) {
		BinarySearchTreeNode root = new BinarySearchTreeNode(1);
		root.left = new BinarySearchTreeNode(2);
		root.right = new BinarySearchTreeNode(3);
		root.left.left = new BinarySearchTreeNode(4);
		root.left.right = new BinarySearchTreeNode(5);
		root.right.left = new BinarySearchTreeNode(6);
		root.right.right = new BinarySearchTreeNode(7);

		maxSumLevel(root);
	}

}
