package viewsAndTypesOfBinaryTrees;

//	Given two binary trees, check if they are equal or not.
//	Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
//	Input 1:					Output :
//		   1       1					1
//		  / \     / \
//		 2   3   2   3
public class IdenticalBinaryTrees {
	public int isSameTree(TreeNode A, TreeNode B) {
		// base case-1 if bot the nodes are null trees are identical
		if (A == null && B == null)
			return 1;
		// base case-2 if any one node is null trees are unidentical
		else if ((A == null && B != null) || (A != null && B == null))
			return 0;
		// base case-3 if any node value is different trees are not identical
		else if (A.val != B.val)
			return 0;

		int left = isSameTree(A.left, B.left);
		int right = isSameTree(A.right, B.right);
		return Math.min(left, right); // captuirng the min value
	}
}
