package binarySearchTree;

import java.util.ArrayList;

import binarySearchTree.ValidBinarySearchTree.TreeNode;

//			Given a binary search tree A, where each node contains a positive integer, 
//			and an integer B, you have to find whether or not there exist two different 
//			nodes X and Y such that X.value + Y.value = B.
//			Return 1 to denote that two such nodes exist. Return 0, otherwise.
//			Input :				Output :
//			    10					1
//			    / \
//			   9   20
//			
//			B = 19

public class TwoSumBST {
	ArrayList<Integer> arr = new ArrayList<>(); // created global arraylist to store values

	public int t2Sum(TreeNode A, int B) {
		ArrayList<Integer> ans = helper(A); // filled our local arraylist by calling helper function

		int i = 0;
		int j = ans.size() - 1; // took two pointers
		while (i < j) {
			if (ans.get(i) + ans.get(j) == B) { // if values same directly returned 1
				return 1;
			}
			if (ans.get(i) + ans.get(j) > B) { // if greater decreased last pointer as it has more value
				j--;
			} else {
				i++;
			}
		}
		return 0;
	}

	public ArrayList<Integer> helper(TreeNode A) {
		if (A == null)
			return arr; // Base condition
		helper(A.left); // filled in In-order since it is sorted and 2 pointer can be used
		arr.add(A.val);
		helper(A.right);
		return arr;
	}

}
