package problems;

//		Given a binary tree T, find the maximum path sum.
//		The path may start and end at any node in the tree.
//		Input :					Output:
//		    20						40
//		   /  \
//		-10   20
//		     /  \
//		   -10  -50
public class MaxSumPathInBinaryTree {
	public int maxPathSum(TreeNode A) {
		nodeValue(A);
		return max;
	}

	int max = Integer.MIN_VALUE;

	public int nodeValue(TreeNode A) {
		if (A == null)
			return 0;

		// This will calculate max left and right value at this node
		int left = Math.max(Integer.MIN_VALUE, nodeValue(A.left));
		int right = Math.max(Integer.MIN_VALUE, nodeValue(A.right));

		// Calculate the max by adding all three
		max = Math.max(max, Math.max(A.val, A.val + left + right));

		// return the max from that path
		return Math.max(A.val, A.val + Math.max(left, right));

	}

}
