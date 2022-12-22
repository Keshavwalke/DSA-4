package binarySearchTree;

//		You are given a binary tree represented by root A.
//		Assume a BST is defined as follows:
//		1) The left subtree of a node contains only nodes with keys less than the node's key.
//		2) The right subtree of a node contains only nodes with keys greater than the node's key.
//		3) Both the left and right subtrees must also be binary search trees.
public class ValidBinarySearchTree {
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
			left = null;
			right = null;
		}
	}

	public int isValidBST(TreeNode A) {
		int s = Integer.MIN_VALUE; // taken range from -infinity to +infinity
		int e = Integer.MAX_VALUE;
		if (solve(A, s, e) == true) { // passing values and returning helper function
			return 1;
		}
		return 0;
	}

	public boolean solve(TreeNode A, int s, int e) {
		if (A == null) { // base case if node null returned true
			return true;
		}
		if (A.val >= s && A.val <= e) { // if values are within range
			boolean l = solve(A.left, s, A.val - 1); // updated left and right side
			boolean r = solve(A.right, A.val + 1, e);
			return l & r; // both sides should be true
		} else {
			return false;
		}
	}

}
