package lowestCommonAncestor;
//		Given two binary trees, check if they are equal or not.
//		Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
//		Input :						Output:
//			   1       1				1
//			  / \     / \
//			 2   3   2   3
public class IdenticalBinaryTree {
	public int isSameTree(TreeNode A, TreeNode B) {
		if (A == null && B == null)
			return 1; // base case-1 if bot the nodes are null trees are identical
		else if ((A == null && B != null) || (A != null && B == null))
			return 0; // base case-2 if any one node is null trees are unidentical
		else if (A.val != B.val)
			return 0; // base case-3 if any node value is different trees are not identical

		int left = isSameTree(A.left, B.left);
		int right = isSameTree(A.right, B.right);
		return left & right;
	}

}
