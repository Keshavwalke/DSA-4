package structureOfBinaryTreeAndTraversal;

import java.util.ArrayList;
import java.util.Stack;

//		Given a binary tree, return the inorder traversal of its nodes' values.
//		NOTE: Using recursion is not allowed.
//		Input :					Output:
//			   1					[6, 1, 3, 2]
//			  / \
//			 6   2
//			    /
//			   3

// Definition for binary tree
 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     
     TreeNode(int x) {
      val = x;
      left=null;
      right=null;
     }
     
    
 }
 class BinaryTree {
	    // Root of Binary Tree
	    TreeNode root;
	 
	    BinaryTree() { 
	    	root = null; 
	    }
	    }

public class InorderTraversal {

	//Using Iterative Approach
	public static int[] inorderTraversal(TreeNode A) {
		TreeNode curr = A;
		Stack<TreeNode> st = new Stack<>(); // created stack of type TreeNode
		ArrayList<Integer> arr = new ArrayList<>(); // created arrayList to get values

		while (st.size() > 0 || curr != null) { // running loop till stack is not empty and curr is not null
			while (curr != null) {
				st.push(curr); // move left until left is null and update curr push into stack
				curr = curr.left;
			}
			curr = st.peek(); // come back from null to top of stack
			st.pop();
			arr.add(curr.val); // pop the peek value and add to arraylist
			curr = curr.right; // updating current to right side now
		}

		int ans[] = new int[arr.size()];
		for (int i = 0; i < arr.size(); i++) { // converted arrayList to array
			ans[i] = arr.get(i);
		}

		return ans;
	}
	
	//Solved using recursive code
	public static void solve(TreeNode A) {
		if(A==null) return;
		solve(A.left);
		System.out.print(A.val+" ");
		solve(A.right);
	}

	public static void main(String[] args) {
		 BinaryTree t=new BinaryTree();
	     t.root=new TreeNode(1);
	     t.root.left= new TreeNode(6);
	     t.root.right=new TreeNode(2);
	     t.root.right.left=new TreeNode(3);
	     
	     int ans[]=inorderTraversal(t.root);
	     for(int i=0;i<ans.length;i++) {
	    	 System.out.print(ans[i]+" ");
	     }
	     
	     System.out.println();
	     solve(t.root);

	}

}
