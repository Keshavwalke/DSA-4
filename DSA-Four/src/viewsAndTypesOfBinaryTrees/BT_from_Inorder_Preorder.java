package viewsAndTypesOfBinaryTrees;

import java.util.HashMap;

//		Given preorder and inorder traversal of a tree, construct the binary tree.
//		NOTE: You may assume that duplicates do not exist in the tree.
//		Input 1:
//			 A = [1, 2, 3]
//			 B = [2, 1, 3]
//			 Output 1:
//				   1
//				  / \
//				 2   3
public class BT_from_Inorder_Preorder {
	
	//Using Hashmap TC: O(N) SC: O(N)
	 public TreeNode buildTree1(int[] A, int[] B) {
         int s1=0;
        int e1=A.length-1;              // start and end of preorder and inorder
        int s2=0;
        int e2=B.length-1;
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<=e2;i++){             //used hashmap to store index
            hm.put(B[i],i);
        }
        return solve(A,s1,e1,B,s2,e2,hm);      //returned another function
        
    }

    public TreeNode solve(int[] A,int s1,int e1,int [] B, int s2,int e2,HashMap<Integer,Integer> hm){
        if(s1>e1 && s2>e2) return null;         //base condition
        TreeNode root=new TreeNode(A[s1]);      //created the root node
        int ind=hm.get(A[s1]);      //got the index
        int x=ind-s2;
        root.left=solve(A,s1+1,s1+x,B,s2,ind-1,hm);       //created left of tree 
        root.right=solve(A,s1+x+1,e1,B,ind+1,e2,hm);      //created right of tree
        return root;
    }
	
	//Using N2 approach
	 public TreeNode buildTree(int[] A, int[] B) {
	        int s1=0;
	        int e1=A.length-1;              // start and end of preorder and inorder
	        int s2=0;
	        int e2=B.length-1;
	        return solve(A,s1,e1,B,s2,e2);      //returned another function
	    }

	    public TreeNode solve(int[] A,int s1,int e1,int [] B, int s2,int e2){
	        if(s1>e1 && s2>e2) return null;         //base condition
	        TreeNode root=new TreeNode(A[s1]);      //created the root node
	        int ind=-1;
	        for(int i=s2;i<=e2;i++){            //found out the index of root node in inorder
	            if(A[s1]==B[i]){
	                ind=i; break;
	            }
	        }
	        int x=ind-s2;
	        root.left=solve(A,s1+1,s1+x,B,s2,ind-1);       //created left of tree 
	        root.right=solve(A,s1+x+1,e1,B,ind+1,e2);      //created right of tree
	        return root;
	    }

	public static void main(String[] args) {

	}

}
