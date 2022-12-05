package structureOfBinaryTreeAndTraversal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

//		Given a binary tree, return the reverse level order traversal of its nodes values. 

//		(i.e, from left to right and from last level to starting level).
//		Input :					Output:
//		    3						[15, 7, 9, 20, 3] 
//		   / \
//		  9  20
//		    /  \
//		   15   7

public class ReverseLevelOrder {
	public ArrayList<Integer> solve(TreeNode A) {
		Queue<TreeNode> q = new LinkedList<>(); // created queue of type TreeNode
		q.add(A); // added root node to queue
		ArrayList<Integer> arr = new ArrayList<Integer>(); // created  ArrayList

		while (q.size() > 0) {
			TreeNode f = q.peek();
			q.remove();
			arr.add(f.val);
			if (f.right != null) {
				q.add(f.right); // generated all right pushed to queue
			}
			if (f.left != null) {
				q.add(f.left); // generated all left pushed to queue
			}

		}
		Collections.reverse(arr);
		return arr;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
