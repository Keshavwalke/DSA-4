package binarySearchTree;
//		Given preorder traversal of a binary tree, check if it is possible that 
//		it is also a preorder traversal of a Binary Search Tree (BST), 
//		where each internal node (non-leaf nodes) have exactly one child.
//		Input :						Output:
//			 A : [4, 10, 5, 8]			YES

public class CheckingBSTwithOneChild {
	// Approach 1
	public String solve1(int[] A) {
		int l = Integer.MIN_VALUE;
		int r = Integer.MAX_VALUE;
		int root = A[0];

		for (int i = 1; i < A.length; i++) {
			if (A[i] > root) { // if coming element greater min need to update left value
				l = root; // these are acting as boundaries
			} else {
				r = root; // else updating right value
			}
			if (A[i] < l || A[i] > r) { // if current element not withing boundaries returned NO
				return "NO";
			}
			root = A[i];
		}
		return "YES"; // In end returned YES
	}

	// Approach 2
	public String solve(int[] A) {
		int length = A.length;

		int max = Math.max(A[length - 1], A[length - 2]);
		int min = Math.min(A[length - 1], A[length - 2]);

		for (int i = length - 3; i >= 0; i--) {
			if (A[i] > min && A[i] < max)
				return "NO";

			min = Math.min(min, A[i]);
			max = Math.max(max, A[i]);
		}

		return "YES";
	}

}
