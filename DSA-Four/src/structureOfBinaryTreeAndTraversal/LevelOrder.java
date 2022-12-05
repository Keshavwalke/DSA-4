package structureOfBinaryTreeAndTraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LevelOrder {
	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode A) {
		Queue<TreeNode> q = new LinkedList<>(); // created queue of type TreeNode
		q.add(A); // added root node to queue
		ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>(); // created 2D ArrayList

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
			arr.add(temp);
		}
		return arr;
	}

	public static void main(String[] args) {

	}

}
