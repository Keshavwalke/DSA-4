package structureOfBinaryTreeAndTraversal;

import java.util.ArrayList;
import java.util.Stack;

//		Given a binary tree, return the preorder traversal of its nodes values.
//		NOTE: Using recursion is not allowed.
//		Input:					Output:
//			   1					[1,6,2,3]
//			  / \
//			 6   2
//			    /
//			   3
public class PreOrderTraversal {
	public int[] preorderTraversal(TreeNode A) {
		Stack<TreeNode> st = new Stack<>(); // created stack of type TreeNode
		ArrayList<Integer> arr = new ArrayList<>();
		TreeNode curr = A;
		while (st.size() > 0 || curr != null) { // iterating until size>0 and curr is not null
			while (curr != null) {
				arr.add(curr.val); // adding element to arraylist, pushing to stack
				st.push(curr);
				curr = curr.left; // updating current value to left
			}
			curr = st.peek();
			st.pop();
			curr = curr.right;
		}

		int ans[] = new int[arr.size()];
		for (int i = 0; i < arr.size(); i++) { // converted arrayList to array
			ans[i] = arr.get(i);
		}

		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
