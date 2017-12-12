package com.sac.binary.search.tree;

import java.util.Optional;
import java.util.Stack;

public class BST {

	public static class Node {
		int data;
		Node left;
		Node right;

	}

	private static Node createRootNode(int data) {
		Node node = new Node();
		node.data = data;
		node.left = null;
		node.right = null;
		return node;
	}

	public Node insert(Node root, int data) {
		if (root == null) {

			return createRootNode(data);
		}
		// duplicate insertion is not allowed for this tree.
		if (root.data == data) {
			throw new IllegalArgumentException("Duplicate date " + data);
		}

		if (root.data > data) {
			Node left = insert(root.left, data);
			// set the left child returned to be left of root node
			root.left = left;

		} else {
			Node right = insert(root.right, data);
			// set the right child returned to be right of root node
			root.right = right;

		}

		return root;
	}

	public static void displayTree(Node root) {
		Stack globalStack = new Stack();
		globalStack.push(root);
		int nBlanks = 32;
		boolean isRowEmpty = false;
		System.out.println("......................................................");
		while (isRowEmpty == false) {
			Stack localStack = new Stack();
			isRowEmpty = true;

			for (int j = 0; j < nBlanks; j++)
				System.out.print(' ');

			while (globalStack.isEmpty() == false) {
				Node temp = (Node) globalStack.pop();
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

	public static Node find(int key, Node root) // find node with given key
	{ // (assumes non-empty tree)
		Node current = root; // start at root
		while (current.data != key) // while no match,
		{
			if (key < current.data) // go left?
				current = current.left;
			else // or go right?
				current = current.right;
			if (current == null) // if no child,
				return null; // didn't find it
		}
		return current; // found it
	} // end

	private static void inOrder(Node localRoot) {
		if (localRoot == null) {
			return;
		}
		if (localRoot != null) {
			inOrder(localRoot.left);
			System.out.print(localRoot.data + " ");
			inOrder(localRoot.right);
		}
	}

	public static void main(String args[]) {
		Node root = null;
		BST redBlackTree = new BST();
		root = redBlackTree.insert(root, 4);
		root = redBlackTree.insert(root, 5);
		root = redBlackTree.insert(root, 3);
		root = redBlackTree.insert(root, 2);
		root = redBlackTree.insert(root, 6);
		displayTree(root);

		Node found = find(88, root);
		if (found != null) {
			System.out.print("Found");
			System.out.print("\n");
		} else
			System.out.print("Could not find ");
		inOrder(root);
	}

}
