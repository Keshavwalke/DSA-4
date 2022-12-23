package binarySearchTree;
//		You are given a Binary Tree A with N nodes.
//		Write a function that returns the size of the largest subtree, which is also a Binary Search Tree (BST).
//		If the complete Binary Tree is BST, then return the size of the whole tree.
//			Input :				Output :
//			     10					3
//			    / \
//			   5  15
//			  / \   \ 
//			 1   8   7

import binarySearchTree.ValidBinarySearchTree.TreeNode;

class Pair {
	int min;
	int max;
	int size;

	public Pair(int min, int max, int size) {
		this.min = min;
		this.max = max;
		this.size = size;
	}
}

public class LargestBSTSubTree {
	boolean isBST = true;
	int max = Integer.MIN_VALUE;

	public int solve(TreeNode A) {
		travel(A);
		return max;
	}

	private Pair travel(TreeNode A) {
		if (A == null)
			return new Pair(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);

		Pair left = travel(A.left);
		Pair right = travel(A.right);

		if (A.val <= left.max || A.val >= right.min) {
			isBST = false;
		}
		if (isBST)
			max = Integer.max(max, left.size + right.size + 1);
		return new Pair(Math.min(left.min, A.val), Math.max(right.max, A.val), left.size + right.size + 1);
	}

}
