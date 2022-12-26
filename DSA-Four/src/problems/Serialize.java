package problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//		Given the root node of a Binary Tree denoted by A.
//		You have to Serialize the given Binary Tree in the described format.
//		Serialize means encode it into a integer array denoting the Level Order Traversal of the given Binary Tree.
//		NOTE:
//		In the array, the NULL/None child is denoted by -1.
//		For more clarification check the Example Input.
//		Input :				Output:
//		    1					[1, 2, 3, 4, 5, -1, -1, -1, -1, -1, -1]
//		  /   \
//		 2     3
//		/ \
//		4   5
public class Serialize {
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
	
	public ArrayList<Integer> solve(TreeNode A) {
        Queue<TreeNode> q=new LinkedList<>();           //using queue to store values
        ArrayList<Integer> arr=new ArrayList<>();       //ans arraylist
        q.add(A);
        arr.add(A.val);

        while(q.size()>0){                  //doing until queue size is >0
            TreeNode temp=q.remove();
            
            if(temp.left!=null){
                arr.add(temp.left.val);     //adding to queue if left not null and pushing val to arr
                q.add(temp.left);
            }
            else{
                arr.add(-1);
            }
             if(temp.right!=null){
                arr.add(temp.right.val);        //adding to queue if right not null and pushing val to arr
                q.add(temp.right);
            }
            else{
                arr.add(-1);
            }

        }
            return arr;
    }

}
