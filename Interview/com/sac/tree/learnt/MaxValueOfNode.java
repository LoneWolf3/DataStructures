package com.sac.tree.learnt;

public class MaxValueOfNode {
	public static int maxInBinaryTree(BinarySearchTreeNode root) {
		int maxValue = Integer.MIN_VALUE;
		if (root == null) {
			return 0;
		}
		int leftMax = maxInBinaryTree(root.getLeft());
		int rightMax = maxInBinaryTree(root.right);

		if (leftMax > rightMax)
			maxValue = leftMax;
		else
			maxValue = rightMax;

		if (root.data > maxValue)
			maxValue = root.data;

		return maxValue;
	}

	public static void main(String[] args) {
		BinarySearchTreeNode root = new BinarySearchTreeNode(20);
		root.left = new BinarySearchTreeNode(10);
		root.right = new BinarySearchTreeNode(15);
		root.left.left = new BinarySearchTreeNode(30);
		root.left.right = new BinarySearchTreeNode(40);
		root.right.left = new BinarySearchTreeNode(17);
		root.right.right = new BinarySearchTreeNode(42);
		System.out.println(maxInBinaryTree(root));
	}
}
