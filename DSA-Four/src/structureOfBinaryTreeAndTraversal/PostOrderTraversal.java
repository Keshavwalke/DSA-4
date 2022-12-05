package structureOfBinaryTreeAndTraversal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

//		Given a binary tree, return the Postorder traversal of its nodes values.

//		NOTE: Using recursion is not allowed.
//		Input :				Output :
//			   1				[3, 2, 1]
//			    \
//			     2
//			    /
//			   3

public class PostOrderTraversal {
	public ArrayList<Integer> postorderTraversal(TreeNode A) {
		ArrayList<Integer> ans = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		stack.push(A);
		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			ans.add(node.val);
			if (node.left != null)
				stack.push(node.left);
			if (node.right != null)
				stack.push(node.right);
		}
		Collections.reverse(ans);
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
