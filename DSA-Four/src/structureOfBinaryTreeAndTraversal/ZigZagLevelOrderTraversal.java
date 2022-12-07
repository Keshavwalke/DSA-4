package structureOfBinaryTreeAndTraversal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

//		Given a binary tree, return the zigzag level order traversal of its nodes values. 

//		(ie, from left to right, then right to left for the next level and alternate between).
//		Input :					Output :
//		    3						[[3],
//		   / \						 [20,9]
//		  9  20						 [15,7]
//		    /  \					 		]
//		   15   7

public class ZigZagLevelOrderTraversal {
	public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode A) {
		Queue<TreeNode> q = new LinkedList<>(); // created queue of type TreeNode
		q.add(A); // added root node to queue
		ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>(); // created 2D ArrayList

		int index = 0;
		while (q.size() > 0) {
			ArrayList<Integer> temp = new ArrayList<>();
			int N = q.size();
			for (int i = 0; i < N; i++) {
				TreeNode f = q.peek();
				q.remove();

				temp.add(f.val);
				if (f.left != null) {
					q.add(f.left); // generated all left pushed to queue
				}
				if (f.right != null) {
					q.add(f.right); // generated all right pushed to queue
				}
			}
			if ((index % 2) == 1)
				Collections.reverse(temp);
			index++;
			arr.add(temp);
		}
		return arr;
	}

	public static void main(String[] args) {

	}

}
