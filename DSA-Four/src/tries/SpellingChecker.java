package tries;

import java.util.ArrayList;
import java.util.HashMap;
//		Given an array of words A (dictionary) and another array B (which contain some words).
//		You have to return the binary array (of length |B|) as the answer where 1 denotes that 
//		the word is present in the dictionary and 0 denotes it is not present.
//		Formally, for each word in B, you need to return 1 if it is present in Dictionary and 0 if not.

public class SpellingChecker {
	public ArrayList<Integer> solve(ArrayList<String> A, ArrayList<String> B) {
		Node root = new Node(); // created root node
		ArrayList<Integer> ans = new ArrayList<>();

		for (int i = 0; i < A.size(); i++) {
			insert(root, A.get(i)); // inserted array A words in tree
		}
		for (int i = 0; i < B.size(); i++) {
			if (search(root, B.get(i)) == true) { // iterated over array B if word there in A added 1 else 0
				ans.add(1);
			} else {
				ans.add(0);
			}
		}
		return ans;
	}

	public void insert(Node root, String data) { // insert function root node and words given parameters
		Node temp = root;
		int l = data.length();
		for (int i = 0; i < l; i++) { // iterated over length of word
			char ch = data.charAt(i);
			if (temp.hm.containsKey(ch)) { // if char already present moved temp pointer
				temp = temp.hm.get(ch);
			} else {
				Node nn = new Node(); // else created new node, updated temp to nn
				temp.hm.put(ch, nn);
				temp = nn;
			}
		}
		temp.isEnd = true;
	}

	public boolean search(Node root, String data) {
		Node temp = root;
		int l = data.length();
		for (int i = 0; i < l; i++) {
			char ch = data.charAt(i);
			if (temp.hm.containsKey(ch)) {
				temp = temp.hm.get(ch);
			} else {
				return false; // if char is not there means direct false
			}
		}
		return temp.isEnd;
	}

	public class Node { // class Node
		boolean isEnd;
		HashMap<Character, Node> hm;

		public Node() { // constructor of class Node
			hm = new HashMap<Character, Node>(); // initialized hashmap and isEnd=false
			isEnd = false;
		}
	}

}
