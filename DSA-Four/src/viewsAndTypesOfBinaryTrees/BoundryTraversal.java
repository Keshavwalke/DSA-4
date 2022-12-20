package viewsAndTypesOfBinaryTrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//		Given a binary tree, return the values of its boundary in anti-clockwise direction starting from the root. 
//		Boundary includes left boundary, leaves,and right boundary in order without duplicate nodes.
//		Left boundary is defined as the path from the root to the left-most node. 
//		Right boundary is defined as the path from the root to the right-most node. If the root doesn't 
//		have left subtree or right subtree, then the root itself is left boundary or right boundary. 
//		Note this definition only applies to the input binary tree, and not applies to any subtrees.
//		The left-most node is defined as a leaf node you could reach when you always firstly travel to 
//		the left subtree if exists. If not, travel to the right subtree. Repeat until you reach a leaf node.
//		The right-most node is also defined by the same way with left and right exchanged.
//		Return an array of integers denoting the boundary values of tree in anti-clockwise order.
//		Input 1:					Output:
//		    _____1_____					[1, 2, 4, 7, 8, 9, 10, 6, 3]
//		   /           \
//		  2             3
//		 / \            / 
//		4   5          6   
//		   / \        / \
//		  7   8      9  10  
public class BoundryTraversal {
	 public ArrayList<Integer> solve(TreeNode A) {
	        Queue<TreeNode> q = new LinkedList<>();
	        ArrayList<Integer> lv = new ArrayList<>();
	        ArrayList<Integer> rv = new ArrayList<>();
	        ArrayList<Integer> bv = new ArrayList<>();

	        q.add(A);
	        while(q.size()>0){
	            int n = q.size();
	            int k =0;  
	            for(int i=1; i<=n; i++){
	                TreeNode top = q.peek();
	                if(top.right==null && top.left==null){
	                    bv.add(k, top.val);  // to add bv in sequence of level, i.e. higher order will be added first
	                    k++;
	                }
	                else{
	                    if(i==1){
	                        lv.add(top.val);
	                    }
	                    if(n>1 && i==n){
	                        rv.add(0, top.val);  // to maintain reverse right view
	                    }
	                }

	                if(top.left!=null){
	                    q.add(top.left);
	                }
	                if(top.right!=null){
	                    q.add(top.right);
	                }

	                q.remove();
	            }
	        }

	        ArrayList<Integer> ans = lv;
	        ans.addAll(bv);
	        ans.addAll(rv);

	        return ans;
	    }

}
