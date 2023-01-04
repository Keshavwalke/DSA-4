package heaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

//		Given an integer array B of size N.
//		You need to find the Ath largest element in the subarray [1 to i], 
//		where i varies from 1 to N. In other words, find the Ath largest element 
//		in the sub-arrays [1 : 1], [1 : 2], [1 : 3], ...., [1 : N].
//		NOTE: If any subarray [1 : i] has less than A elements, then the output should be -1 at the ith index.
//		Input :							Output:
//			 A = 4  					[-1, -1, -1, 1, 2, 3]
//			 B = [1 2 3 4 5 6] 
public class AthLargestElement {
	public static ArrayList<Integer> solve(int A, ArrayList<Integer> B) {
		PriorityQueue<Integer> minh = new PriorityQueue<>(); // created minheap
		ArrayList<Integer> arr = new ArrayList<>();

		
		for (int i = 0; i < A; i++) { // pushing first A elements in minheap
			minh.add(B.get(i));
			if (i == A - 1)
				arr.add(minh.peek()); // if i==A pushing the Ath max value else -1
			else
				arr.add(-1);
		}

		for (int i = A; i < B.size(); i++) { // Pushing elements from A+1 to N
			minh.add(B.get(i)); // fist pushing element
			minh.poll(); // removing smallest elements so only A elements will remain in heap
			arr.add(minh.peek()); // adding top element to result
		}

		return arr;
	}

	public static void main(String[] args) {
		int A = 4;
		ArrayList<Integer> B = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));

		ArrayList<Integer> ans = solve(A, B);
		for (int i : ans) {
			System.out.print(i + " ");
		}

	}

}
