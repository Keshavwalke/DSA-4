package structureOfBinaryTreeAndTraversal;
//		Given a binary tree A, invert the binary tree and return it.

//		Inverting refers to making the left child the right child and vice versa.
//		Input :				Output :
//		    1						  1
//		  /   \				  		/   \
//		 2     3				   3     2

public class InvertBinaryTree {
	public TreeNode invertTree(TreeNode A) {
		if (A == null) {
			return A;
		}
		TreeNode left = invertTree(A.left);
		TreeNode right = invertTree(A.right);

		A.left = right;
		A.right = left;
		return A;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
