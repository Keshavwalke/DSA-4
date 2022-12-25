package lowestCommonAncestor;
//		Two elements of a binary search tree (BST), represented by root A are swapped by mistake. 

//		Tell us the 2 values swapping which the tree will be restored.
//		Input :				Output:
//		    1					[2, 1]
//		   / \
//		  2   3

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
		left = null;
		right = null;
	}
}

public class RecoverBinarySearchTree {
	TreeNode first = null;
	TreeNode second = null;
	TreeNode prev = null;

	public int[] recoverTree(TreeNode A) {
		int[] arr = new int[2];
		inorder(A);
		arr[1] = first.val;
		arr[0] = second.val;
		return arr;
	}

	public void inorder(TreeNode A) {
		if (A == null)
			return;
		inorder(A.left); // left order traversal
		if (prev != null && prev.val > A.val) { // failing the condition
			if (first == null) {
				first = prev; // happened for first time
				second = A;
			} else {
				second = A; // happened second time
			}
		}
		prev = A;
		inorder(A.right);
	}

}
