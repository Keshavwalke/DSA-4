package lowestCommonAncestor;
//		Find the lowest common ancestor in an unordered binary tree A, given two values, B and C, in the tree.
//		Lowest common ancestor: the lowest common ancestor (LCA) of two nodes and w in a tree or directed 
//		acyclic graph (DAG) is the lowest (i.e., deepest) node that has both v and w as descendants.
//		Input :	 			Ouptut:
//		    1					1
//		   /  \
//		  2    3
//		B = 2
//		C = 3
public class LeastCommonAncestor {
	public static TreeNode LCA(TreeNode root, int val1, int val2) {
		if (root == null)
			return null;
		if (root.val == val1 || root.val == val2) // if root is value of val1 or val2
			return root;
		TreeNode l = LCA(root.left, val1, val2);
		TreeNode r = LCA(root.right, val1, val2);
		if (l != null && r != null)
			return root;
		if (l != null)
			return l;
		return r;
	}

	public static boolean find(TreeNode root, int val1) { // fun to check if element present
		if (root == null)
			return false; // if root node is null returning false
		if (root.val == val1)
			return true;
		return (find(root.left, val1) || find(root.right, val1));
	}

	public int lca(TreeNode A, int B, int C) {
		if (find(A, B) == false || find(A, C) == false) // if any value not available final ans -1
			return -1;
		TreeNode ans = LCA(A, B, C); // found out lca
		if (ans == null) // if lca ans is null again returning -1
			return -1;
		return ans.val;
	}

}
