package viewsAndTypesOfBinaryTrees;

//		Given a root of binary tree A, determine if it is height-balanced.
//		A height-balanced binary tree is defined as a binary tree in which 
//		the depth of the two subtrees of every node never differ by more than 1.
//		Input :			Output:
//		    1				1
//		   / \
//		  2   3
public class BalancedBinaryTree {
	public int isBalanced(TreeNode A) {
		if (checkBalanced(A) == 0)
			return 0;
		return 1;
	}

	public int checkBalanced(TreeNode A) {
		if (A == null)
			return 1;

		int left = checkBalanced(A.left);
		int right = checkBalanced(A.right);

		if (left == 0 || right == 0)
			return 0;
		if (Math.abs(left - right) > 1)
			return 0;

		return Math.max(left, right) + 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
