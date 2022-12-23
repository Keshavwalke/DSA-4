package binarySearchTree;

import binarySearchTree.ValidBinarySearchTree.TreeNode;

//		Given a binary search tree of integers. You are given a range B and C.
//		Return the count of the number of nodes that lie in the given range.
//		Input :					Output:
//		    15						5
//		  /    \
//		12      20
//		/ \    /  \
//		10  14  16  27
//		/
//		8
//		
//		B = 12
//		C = 20
public class BSTNodesInRange {
	static int ans = 0; // took global variable

	public int solve(TreeNode A, int B, int C) {
		ans = 0;
		helper(A, B, C); // ran helper function to update ans variable
		return ans;
	}

	public void helper(TreeNode A, int B, int C) {
		if (A == null)
			return; // base case

		if (A.val >= B && A.val <= C) { // if node is within range increased count
			ans++;
		}
		helper(A.left, B, C); // recursion for left and right part
		helper(A.right, B, C);
	}

}
