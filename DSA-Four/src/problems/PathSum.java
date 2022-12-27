package problems;

//		Given a binary tree and a sum, determine if the tree has a root-to-leaf path 
//		such that adding up all the values along the path equals the given sum.
//		Input :						Output:
//			 Tree:    5					1
//			         / \
//			        4   8
//			       /   / \
//			      11  13  4
//			     /  \      \
//			    7    2      1
//		
//			 B = 22
public class PathSum {
	public int hasPathSum(TreeNode A, int B) {
		if (helper(A, B, 0))
			return 1;
		return 0;
	}

	private boolean helper(TreeNode root, int B, int sum) {
		if (root == null)
			return false;
		if (root.left == null && root.right == null) {
			if (sum + root.val == B)
				return true;
			else
				return false;
		}
		boolean left = helper(root.left, B, sum + root.val);
		boolean right = helper(root.right, B, sum + root.val);
		return left || right;
	}

}
