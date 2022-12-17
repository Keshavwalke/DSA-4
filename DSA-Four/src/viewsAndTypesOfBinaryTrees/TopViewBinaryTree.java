package viewsAndTypesOfBinaryTrees;

import java.util.ArrayList;

//		Given a binary tree of integers denoted by root A. Return an array of 
//		integers representing the top view of the Binary tree.
//		The top view of a Binary Tree is a set of nodes visible when the tree is visited from the top.
//		Return the nodes in any order.
//		Input :					Output:
//		    1					 [1, 2, 4, 8, 3, 7]
//		  /   \
//		 2    3
//		/ \  / \
//		4   5 6  7
//		/
//		8 
public class TopViewBinaryTree {
	public ArrayList<Integer> solve(TreeNode A) {
		ArrayList<Integer> arr = new ArrayList<>();
		TreeNode curr = A;

		while (curr != null) {
			arr.add(curr.val);		//traversed and added all lefts from root node
			curr = curr.left;
		}

		if (A.right != null) {			//checked if right of root is null if not added
			curr = A.right;
		}

		while (curr != null) {
			arr.add(curr.val);				//added all rights to ans
			curr = curr.right;
		}
		return arr;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
