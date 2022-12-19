package viewsAndTypesOfBinaryTrees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

//		Given a Binary Tree A consisting of N integer nodes, 
//		you need to print the bottom view from left to right.
//		A node x is there in output if x is the bottom-most node at its horizontal distance.
//		Horizontal distance of left child of a node x is equal to horizontal distance of x minus 1, 
//		and that of right child is horizontal distance of x plus 1.
//		Note: If there are multiple bottom-most nodes for a horizontal distance from root, 
//		then print the later one in level traversal.
//			Input:					Output:
//			   20						[5, 10, 3, 14, 25]
//			 /    \
//			8     22
//		  /   \     \
//		 5     3    25
//			  / \      
//			10    14
public class BottomViewBinaryTree {
	  public ArrayList<Integer> solve(TreeNode A) {
	        ArrayList<Integer> res=new ArrayList<Integer>();  //created ans arraylist
	        HashMap<Integer,ArrayList<Integer>> hm=new HashMap<Integer,ArrayList<Integer>>();  //created hashmap to store key as integer and value as list
	        Queue<Pair> q=new LinkedList<Pair>();       //created queue of type Pair(class defined in below)
	        int min=Integer.MAX_VALUE;
	        int max=Integer.MIN_VALUE;
	        q.add(new Pair(A,0));       //added root node to queue

	        while(q.size()!=0){
	            TreeNode temp=q.peek().node;        //took the front element value
	            int level=q.peek().level;           //took the front element level
	            max=Math.max(max,level);            
	            min=Math.min(min,level);            //updated the max and min
	            q.remove();                         //removed the first element
	            if(hm.containsKey(level)){
	                ArrayList<Integer> lt2=hm.get(level);   //if this level already exist copied element to new arraylist
	                lt2.add(temp.val);              //added our element to that list
	                hm.put(level,lt2);              // pushed updated list in hashmap
	            }
	            else{
	                ArrayList<Integer> lt1=new ArrayList<Integer>();        //created arraylist
	                lt1.add(temp.val);              //pushed value to list
	                hm.put(level, lt1);             //pushed list to hashmap
	            }

	            if(temp.left!=null){
	              q.add(new Pair(temp.left,level-1));           //added the left child to queue if available
	            }
	            if(temp.right!=null){                           //added the right child to queue if available
	                q.add(new Pair(temp.right,level+1));
	            }
	        }
	        for(int i=min;i<=max;i++){          //Iterated from min level to max level 
	            int last=hm.get(i).size();
	            res.add(hm.get(i).get(last-1));     //added the last element in each level
	        }
	        return res;
	    }
	}
	class Pair{
		    TreeNode node;                          //created class Pair
		    int level;

		    public Pair(TreeNode node, int level){
		        this.node=node;                     //created constructor of class Pair
		        this.level=level;
		    }  

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
