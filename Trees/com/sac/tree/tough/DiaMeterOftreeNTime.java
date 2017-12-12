package com.sac.tree.tough;

public class DiaMeterOftreeNTime {
	int diameter = 0;

	// here in improved solution, we calculate the height and diameter for every
	// BinaryTreeNode in same iteration
	// every BinaryTreeNode will return 2 values, diameter and height wrt to the
	// particular BinaryTreeNode
	public int[] Diameter(BinaryTreeNode root) {
		int HandD[] = { 0, 0 }; // initialize the height (HandD[0]) and diameter
								// as 0 (HandD[1])
		if (root != null) {

			int[] leftResult = Diameter(root.left);
			int[] rightResult = Diameter(root.right);

			int height = Math.max(leftResult[0], rightResult[0]) + 1;
			int leftDiameter = leftResult[1];
			int rightDiameter = rightResult[1];
			int rootDiameter = leftResult[0] + rightResult[0] + 1;
			int finalDiameter = getMax(leftDiameter, rightDiameter,
					rootDiameter);
			// prepare the HandD[]
			HandD[0] = height; // update the height
			HandD[1] = finalDiameter;
			return HandD;
		}
		return HandD;
	}

	public int getMax(int a, int b, int c) {
		return Math.max(a, Math.max(b, c));
	}

	public static void main(String[] args) {
		BinaryTreeNode root = new BinaryTreeNode(1);
		root.left = new BinaryTreeNode(2);
		root.right = new BinaryTreeNode(3);
		root.left.left = new BinaryTreeNode(4);
		root.left.right = new BinaryTreeNode(5);
		root.right.left = new BinaryTreeNode(6);
		root.right.right = new BinaryTreeNode(7);

		DiaMeterOftreeNTime d = new DiaMeterOftreeNTime();
		System.out.println("Diameter of Tree" + d.Diameter(root)[1]);
	}
}

