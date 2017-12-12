package com.sac.tree.learnt;

import java.io.IOException;
// for Stack class
import java.util.Stack;

import com.sac.binary.search.tree.BinarySearchTreeNode;

class Tree {
	private BinarySearchTreeNode root; // first BinarySearchTreeNode of tree

	public Tree() // constructor
	{
		root = null;
	}

	public BinarySearchTreeNode find(int data) {
		BinarySearchTreeNode BinarySearchTreeNode = root; // start at root
		BinarySearchTreeNode element = search(data, BinarySearchTreeNode);
		return element;

	}

	public BinarySearchTreeNode search(int data, BinarySearchTreeNode BinarySearchTreeNode) {
		if (BinarySearchTreeNode != null) {
			if (BinarySearchTreeNode.data == data) {
				return BinarySearchTreeNode;
			} else {
				BinarySearchTreeNode foundNode = search(data, BinarySearchTreeNode.left);
				if (foundNode == null) {
					foundNode = search(data, BinarySearchTreeNode.right);
				}
				return foundNode;
			}
		} else {
			return null;
		}
	}

	public void insertNode(int data) {
		root = insertNode(root, new BinarySearchTreeNode(data));
	}

	private BinarySearchTreeNode insertNode(BinarySearchTreeNode currentParent, BinarySearchTreeNode newNode) {

		if (currentParent == null) {
			return newNode;
		} else if (newNode.data > currentParent.data) {
			currentParent.right = insertNode(currentParent.right, newNode);
		} else if (newNode.data < currentParent.data) {
			currentParent.left = insertNode(currentParent.left, newNode);
		}

		return currentParent;
	}

	// This method mainly calls deleteRec()
	void delete(int data) {
		root = deleteRec(root, data);
	}

	/* A recursive function to insert a new data in BST */
	BinarySearchTreeNode deleteRec(BinarySearchTreeNode root, int data) {
		/* Base Case: If the tree is empty */
		if (root == null)
			return root;

		/* Otherwise, recur down the tree */
		if (data < root.data)
			root.left = deleteRec(root.left, data);
		else if (data > root.data)
			root.right = deleteRec(root.right, data);

		// if data is same as root's data, then This is the BinarySearchTreeNode
		// to be deleted
		else {
			// BinarySearchTreeNode with only one child or no child
			if (root.left == null)
				return root.right;
			else if (root.right == null)
				return root.left;

			// BinarySearchTreeNode with two children: Get the inorder successor (smallest
			// in the right subtree)
			root.data = minValue(root.right);

			// Delete the inorder successor
			root.right = deleteRec(root.right, root.data);
		}

		return root;
	}

	int minValue(BinarySearchTreeNode root) {
		int minv = root.data;
		while (root.left != null) {
			minv = root.left.data;
			root = root.left;
		}
		return minv;
	}

	public void traverse(int traverseType) {
		switch (traverseType) {
		case 1:
			System.out.print("\nPreorder traversal: ");
			preOrder(root);
			break;
		case 2:
			System.out.print("\nInorder traversal:  ");
			inOrder(root);
			break;
		case 3:
			System.out.print("\nPostorder traversal: ");
			postOrder(root);
			break;
		}
		System.out.println();
	}

	private void preOrder(BinarySearchTreeNode localRoot) {
		if (localRoot != null) {
			System.out.print(localRoot.data + " ");
			preOrder(localRoot.left);
			preOrder(localRoot.right);
		}
	}

	private void inOrder(BinarySearchTreeNode localRoot) {
		if (localRoot != null) {
			inOrder(localRoot.left);
			System.out.print(localRoot.data + " ");
			inOrder(localRoot.right);
		}
	}

	private void postOrder(BinarySearchTreeNode localRoot) {
		if (localRoot != null) {
			postOrder(localRoot.left);
			postOrder(localRoot.right);
			System.out.print(localRoot.data + " ");
		}
	}

	public void displayTree() {
		Stack<BinarySearchTreeNode> globalStack = new Stack<BinarySearchTreeNode>();
		globalStack.push(root);
		int nBlanks = 32;
		boolean isRowEmpty = false;
		System.out.println("......................................................");
		while (isRowEmpty == false) {
			Stack<BinarySearchTreeNode> localStack = new Stack<BinarySearchTreeNode>();
			isRowEmpty = true;

			for (int j = 0; j < nBlanks; j++)
				System.out.print(' ');

			while (globalStack.isEmpty() == false) {
				BinarySearchTreeNode temp = (BinarySearchTreeNode) globalStack.pop();
				if (temp != null) {
					System.out.print(temp.data);
					localStack.push(temp.left);
					localStack.push(temp.right);

					if (temp.left != null || temp.right != null)
						isRowEmpty = false;
				} else {
					System.out.print("--");
					localStack.push(null);
					localStack.push(null);
				}
				for (int j = 0; j < nBlanks * 2 - 2; j++)
					System.out.print(' ');
			} // end while globalStack not empty
			System.out.println();
			nBlanks /= 2;
			while (localStack.isEmpty() == false)
				globalStack.push(localStack.pop());
		} // end while isRowEmpty is false
		System.out.println("......................................................");
	} // end displayTree()
}

public class BinarySearchTree {
	public static void main(String[] args) throws IOException {
		Tree theTree = new Tree();

		theTree.insertNode(5);
		theTree.insertNode(3);
		theTree.insertNode(2);
		theTree.insertNode(4);
		theTree.insertNode(6);
		theTree.find(3);
		theTree.delete(3);
		theTree.displayTree();

	}
}
