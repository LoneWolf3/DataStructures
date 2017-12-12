package com.sac.tree.tough;

/*Copyright (c) Dec 22, 2014 CareerMonk Publications and others.
 * E-Mail           	: info@careermonk.com 
 * Creation Date    	: 2015-01-10 06:15:46 
 * Last modification	: 2006-05-31 
               by		: Narasimha Karumanchi 
 * File Name			: FillNextSiblingsWithRecursion.java
 * Book Title			: Data Structures And Algorithms Made In Java
 * Warranty         	: This software is provided "as is" without any 
 * 							warranty; without even the implied warranty of 
 * 							merchantability or fitness for a particular purpose. 
 * 
 */

public class FillNextSiblingsWithRecursion {

	public NodeSibLing provideSiblings(NodeSibLing root) {
		if (root != null) {

			if (root.left != null) { // check if left node is not null
				// make the left node's sibling points to the right node of root
				root.left.nextSibling = root.right;
			}
			if (root.right != null) {
				if (root.nextSibling != null)// check if root has any sibling
					// make the right node's sibling points root's next siblings
					// left node
					root.right.nextSibling = root.nextSibling.left;
			}
			provideSiblings(root.left);
			provideSiblings(root.right);
			return root;

		}
		return null;
	}

	public void printLevel(NodeSibLing n) {
		while (n != null) {
			System.out.print(" " + n.data);
			n = n.nextSibling;
		}
	}

	public static void main(String[] args) {
		NodeSibLing root = new NodeSibLing(1);
		root.left = new NodeSibLing(2);
		root.right = new NodeSibLing(3);
		root.left.left = new NodeSibLing(4);
		root.left.right = new NodeSibLing(5);
		root.right.left = new NodeSibLing(6);
		root.right.right = new NodeSibLing(7);

		FillNextSiblingsWithRecursion i = new FillNextSiblingsWithRecursion();
		NodeSibLing x = i.provideSiblings(root);
		i.printLevel(x);
		System.out.println("");
		i.printLevel(x.left);
		System.out.println("");
		i.printLevel(x.left.left);

	}

}

class NodeSibLing {
	int data;
	NodeSibLing left;
	NodeSibLing right;
	NodeSibLing nextSibling;

	public NodeSibLing(int data) {
		this.data = data;
	}
}
