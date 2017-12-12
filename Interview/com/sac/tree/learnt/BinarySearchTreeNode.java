package com.sac.tree.learnt;

public class BinarySearchTreeNode {
	public int data;
	public BinarySearchTreeNode left;
	public BinarySearchTreeNode right;

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public BinarySearchTreeNode getLeft() {
		return left;
	}

	public void setLeft(BinarySearchTreeNode left) {
		this.left = left;
	}

	public BinarySearchTreeNode getRight() {
		return right;
	}

	public void setRight(BinarySearchTreeNode right) {
		this.right = right;
	}

	public BinarySearchTreeNode(int x) {
		data = x;
		left = null;
		right = null;
	}
}
