package com.sac.binary.tree;
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



import java.util.LinkedList;
import java.util.Queue;

public class DepthBinryTreeITR {
	// Returns the depth of this binary tree. The depth of a binary tree is the
	// length of the longest path from this node to a leaf. The depth of a
	// binary tree with no descendants (that is, just a leaf) is zero.
	public static int maxDepthLevelOrder(BinaryTreeNode root){
    	if(root == null)
            return 0;
        int maxDepth = 1;
        Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
        q.offer(root);
        q.offer(null);
        while(!q.isEmpty()){
        	BinaryTreeNode tmp = q.poll();
            if(tmp != null){
                if(tmp.getLeft() != null)
                    q.offer(tmp.getLeft());
                if(tmp.right != null)
                    q.offer(tmp.right);
            }else{
                if(!q.isEmpty()){
                    ++maxDepth;
                    q.offer(null);
                }
            }
        }
        return maxDepth;
        
    }

    public static void main(String[] args) {
    	BinaryTreeNode root = new BinaryTreeNode(1);
		root.left = new BinaryTreeNode(2);
		root.right = new BinaryTreeNode(3);
		root.left.left = new BinaryTreeNode(4);
		root.left.right = new BinaryTreeNode(5);
		root.right.left = new BinaryTreeNode(6);
		root.right.right = new BinaryTreeNode(7);
		System.out.println(maxDepthLevelOrder(root));
	}
}
