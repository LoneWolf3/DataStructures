package com.sac.binary.search.tree;

import com.sac.binary.search.tree.BST.Node;

public class InterSectionOfNodes {

	static void search(Node root, Node root2) {
		if (root2 == null)
			return;
		if (root.data == root2.data) {
			System.out.println("Common BinarySearchTreeNode:" + root.data);
			return; // common elem found
		} else {
			if (root.data < root2.data) {
				root2 = root2.left;
				search(root, root2);
			} else {
				root2 = root2.right;
				search(root, root2);
			}
		}
	}

	static void common(Node root, Node root2) {
		if (root != null) {
			common(root.left, root2);
			search(root, root2);
			common(root.right, root2);
		}
	}

	// Driver program to test above functions
	public static void main(String[] args) {
		Node root = null;
		BST redBlackTree = new BST();
		root = redBlackTree.insert(root, 4);
		root = redBlackTree.insert(root, 7);
		root = redBlackTree.insert(root, 3);
		root = redBlackTree.insert(root, 2);
		root = redBlackTree.insert(root, 6);
		BST.displayTree(root);
		
		Node root2 = null;
		BST redBlackTree2 = new BST();
		root2 = redBlackTree2.insert(root2, 14);
		root2 = redBlackTree2.insert(root2, 17);
		root2 = redBlackTree2.insert(root2, 13);
		root2 = redBlackTree2.insert(root2, 12);
		root2 = redBlackTree2.insert(root2, 6);
		common(root, root2);
	}

}
