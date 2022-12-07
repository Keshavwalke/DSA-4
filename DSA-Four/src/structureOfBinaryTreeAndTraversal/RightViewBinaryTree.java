package structureOfBinaryTreeAndTraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//		Given a binary tree of integers denoted by root A. Return an array 

//		of integers representing the right view of the Binary tree.
//		Right view of a Binary Tree is a set of nodes visible when the tree is visited from Right side.
//		Input :					Output:
//		    1						[1, 3, 7, 8]
//		  /   \
//		 2    3
//		/ \  / \
//		4   5 6  7
//		/
//		8 

public class RightViewBinaryTree {
	public ArrayList<Integer> solve(TreeNode A) {
		Queue<TreeNode> q = new LinkedList<>(); // created Queue
		q.add(A); // added the root node as it will be visible from right
		ArrayList<Integer> arr = new ArrayList<>(); // created arraylist to store values
		while (q.size() > 0) {
			int N = q.size();
			for (int i = 0; i < N; i++) {
				TreeNode f = q.peek();
				q.remove();
				if (i == N - 1) {
					arr.add(f.val); // right will be visible if it is last value
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

	}

}
