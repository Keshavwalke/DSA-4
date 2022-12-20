package viewsAndTypesOfBinaryTrees;

//		Given a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
//		Input :				Output:
//		    1					1
//		   / \
//		  2   2
//		 / \ / \
//		3  4 4  3
public class SymmetricBinaryTree {
	public int isSymmetric(TreeNode A) {
		return isSymmetricHelper(A.left, A.right) == true ? 1 : 0;
	}

	boolean isSymmetricHelper(TreeNode left, TreeNode right) {
		if (left == null && right == null) {
			return true;
		}
		if (left == null || right == null) {
			return false;
		}
		if (left.val == right.val) {
			return isSymmetricHelper(left.left, right.right) && isSymmetricHelper(left.right, right.left);
		} else {
			return false;
		}
	}

}
