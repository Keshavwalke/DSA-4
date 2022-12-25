package lowestCommonAncestor;

import java.util.HashSet;
import java.util.Set;

//		Given two BST's A and B, return the (sum of all common nodes in both A and B) % (109 +7) .
//		In case there is no common node, return 0.
//		Input :					Output:
//			 Tree A:				17
//			    5
//			   / \
//			  2   8
//			   \   \
//			    3   15
//			        /
//			        9
//
//			 Tree B:
//			    7
//			   / \
//			  1  10
//			   \   \
//			    2  15
//			       /
//			      11
public class CommonNodesIn2BST {
	int sum = 0;

	public int solve(TreeNode A, TreeNode B) {
		Set<Integer> set = new HashSet<>();
		addNodes(set, A); // ran both function
		commonNodesSum(set, B);
		return sum;
	}

	public void addNodes(Set<Integer> set, TreeNode A) {
		if (A == null) {
			return;
		}
		set.add(A.val); // stored all nodes of tree 1 in set
		addNodes(set, A.left);
		addNodes(set, A.right);
	}

	public void commonNodesSum(Set<Integer> set, TreeNode B) {
		if (B == null) {
			return;
		}
		if (set.contains(B.val)) { // check if node of tree 2 are present
			sum += B.val;
			sum = sum % 1000000007; // if yes added that node to sum and mod
		}
		commonNodesSum(set, B.left);
		commonNodesSum(set, B.right);
	}

}
