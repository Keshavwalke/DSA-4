package problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import problems.Serialize.TreeNode;

//		You are given an integer array A denoting the Level Order Traversal of the Binary Tree.
//		You have to Deserialize the given Traversal in the Binary Tree and return the root of the Binary Tree.
//		NOTE:
//		In the array, the NULL/None child is denoted by -1.
//		For more clarification check the Example Input.
//		Input :
//			 A = [1, 2, 3, 4, 5, -1, -1, -1, -1, -1, -1]
//			 
//			 Output :
//		           1
//		         /   \
//		        2     3
//		       / \
//		      4   5
public class Deserialize {
	 public TreeNode solve(ArrayList<Integer> A) {
	        TreeNode root=new TreeNode(A.get(0));
	        Queue<TreeNode> q=new LinkedList<>();   //creating q to store the treenode later will deleter one by one
	        q.add(root);
	        int i=1;
	        
	        while(q.size()>0){
	            TreeNode temp=q.remove();
	            if(A.get(i)!=-1){                               //left child of temp at i
	                temp.left=new TreeNode(A.get(i));
	                q.add(temp.left);
	            }
	            if(A.get(i+1)!=-1){
	                temp.right=new TreeNode(A.get(i+1));        //right child of temp at i+1
	                q.add(temp.right);
	            }
	            i=i+2;
	        }
	        return root;

}
}
