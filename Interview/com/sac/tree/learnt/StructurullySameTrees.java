package com.sac.tree.learnt;
/*Copyright (c) Dec 21, 2014 CareerMonk Publications and others.
 * E-Mail           	: info@careermonk.com 
 * Creation Date    	: 2015-01-10 06:15:46 
 * Last modification	: 2006-05-31 
               by		: Narasimha Karumanchi 
 * File Name			: CheckStructurullySameTrees.java
 * Book Title			: Data Structures And Algorithms Made In Java
 * Warranty         	: This software is provided "as is" without any 
 * 							warranty; without even the implied warranty of 
 * 							merchantability or fitness for a particular purpose. 
 * 
 */

//Java program to see if two trees are identical

public class StructurullySameTrees {
	public static boolean identicalTrees(BinarySearchTreeNode a, BinarySearchTreeNode b) {

		/* 1. both empty */
		if (a == null && b == null) {
			return true;
		}

		/* 2. both non-empty -> compare them */
		if (a != null && b != null) {
			if (a.data == b.data)

			{
				if (identicalTrees(a.left, b.left))

				{
					if (identicalTrees(a.right, b.right))

					{
						return true;
					}
				}
			}

		}

		/* 3. one empty, one not -> false */
		return false;

	}

	public static void main(String[] args) {
		BinarySearchTreeNode root = new BinarySearchTreeNode(1);
		root.left = new BinarySearchTreeNode(2);
		root.right = new BinarySearchTreeNode(3);
		root.left.left = new BinarySearchTreeNode(4);
		root.left.right = new BinarySearchTreeNode(5);
		root.right.left = new BinarySearchTreeNode(6);
		root.right.right = new BinarySearchTreeNode(7);

		BinarySearchTreeNode root2 = new BinarySearchTreeNode(1);
		root2.left = new BinarySearchTreeNode(2);
		root2.right = new BinarySearchTreeNode(3);
		root2.left.left = new BinarySearchTreeNode(4);
		root2.left.right = new BinarySearchTreeNode(5);
		root2.right.left = new BinarySearchTreeNode(6);
		root2.right.right = new BinarySearchTreeNode(7);
		identicalTrees(root, root2);
	}

}
