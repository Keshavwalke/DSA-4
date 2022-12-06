package structureOfBinaryTreeAndTraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//		Given a binary tree of integers. Return an array of integers representing the left view of the Binary tree.
//		Left view of a Binary Tree is a set of nodes visible when the tree is visited from Left side
//		NOTE: The value comes first in the array which have lower level.
//		Input :					Output:
//		    1						[1, 2, 4, 8]
//		  /   \
//		 2    3
//		/ \  / \
//		4   5 6  7
//	   /
//	  8 

public class LeftViewBinaryTree {
	public ArrayList<Integer> solve(TreeNode A) {
		Queue<TreeNode> q = new LinkedList<>(); // created Queue
		q.add(A); // added the root node as it will be visible from left
		ArrayList<Integer> arr = new ArrayList<>(); // created arraylist to store values
		while (q.size() > 0) {
			int N = q.size();
			for (int i = 0; i < N; i++) {
				TreeNode f = q.peek();
				q.remove();
				if (i == 0) {
					arr.add(f.val); // left will be visible if it is first value
				}
				if (f.left != null) { // but to generate everything we continue rest process
					q.add(f.left);
				}
				if (f.right != null) {
					q.add(f.right);
				}
			}
		}
		return arr;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
