package problems;
//		Given a binary tree, find its maximum depth.
//		The maximum depth of a binary tree is the number of nodes along the longest path 
//		from the root node down to the farthest leaf node.
//		NOTE : The path has to end on a leaf node.

public class MaxDepthOfBinaryTree {
	 public int maxDepth(TreeNode A) {
	        if(A == null)
	        return 0;
	        return 1 + Math.max(maxDepth(A.left) , maxDepth(A.right));
	    }

}
