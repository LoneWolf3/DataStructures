package com.sac.binary.search.tree;

import com.sac.binary.search.tree.BST.Node;

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

public class LCABST {
	public static Node LCA(Node root, int i, int j) {
		if (root == null)
			return root;
		if (root.data == i || root.data == j)
			return root;
		if (Math.max(i, j) < root.data) // a.data < root.data && b.data <
										// root.data
			return LCA(root.left, i, j);
		else if (Math.min(i, j) > root.data) // a.data > root.data && b.data >
												// root.data
			return LCA(root.right, i, j);
		else
			return root;
	}

	public static void main(String[] args) {
		Node root = null;
		BST redBlackTree = new BST();
		root = redBlackTree.insert(root, 8);
		root = redBlackTree.insert(root, 5);
		root = redBlackTree.insert(root, 4);
		root = redBlackTree.insert(root, 6);
		root = redBlackTree.insert(root, 9);

		BST.displayTree(root);
		System.out.println( LCA(root, 4, 6).data);

	}

}
