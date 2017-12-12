package com.sac.binary.tree;

/**
 * Date 04/27/2016
 * 
 * @author Tushar Roy
 *
 *         Find lowest common ancestor in binary tree.
 *
 *         Time complexity O(n) Space complexity O(h)
 */
public class LCABinaryTree {

	public static BinaryTreeNode lca(BinaryTreeNode root, BinaryTreeNode n1, BinaryTreeNode n2) {
		if (root == null) {
			return null;
		}
		if (root == n1 || root == n2) {
			return root;
		}

		BinaryTreeNode left = lca(root.left, n1, n2);
		BinaryTreeNode right = lca(root.right, n1, n2);

		if (left != null && right != null) {
			return root;
		}
		return left != null ? left : right;
	}

	public static void main(String[] args) {
		BinaryTreeNode root = new BinaryTreeNode(1);
		root.left = new BinaryTreeNode(2);
		root.right = new BinaryTreeNode(3);
		root.left.left = new BinaryTreeNode(4);
		root.left.right = new BinaryTreeNode(5);
		root.right.left = new BinaryTreeNode(6);
		root.right.right = new BinaryTreeNode(7);
		System.out.println(lca(root, root.left.left, root.left.right).data);
	}

}
