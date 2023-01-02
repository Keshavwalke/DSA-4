package heaps;

import java.util.PriorityQueue;

//		You are given an array A of integers that represent the lengths of ropes.
//		You need to connect these ropes into one rope. 
//		The cost of joining two ropes equals the sum of their lengths.
//		Find and return the minimum cost to connect these ropes into one rope.
//				Input :							Output:
//					 A = [1, 2, 3, 4, 5]			33

public class ConnectRopes {
	public static int solve(int[] A) {
		PriorityQueue<Integer> minh = new PriorityQueue<>(); // created minimum heap

		for (int i = 0; i < A.length; i++) { // added all elements in MinHeap
			minh.add(A[i]);
		}

		int sum = 0;
		while (minh.size() != 0) { // running until size is not 0
			int ele1 = minh.poll();
			int ele2 = minh.poll();
			int total = ele1 + ele2; // removed top 2 element added to total
			sum += total; // adding the total to sum
			if (minh.size() > 0) { // if there is something in heap means we can add our result
				minh.add(total);
			}
		}
		return sum;
	}

	public static void main(String[] args) {
		int A[] = { 1, 2, 3, 4, 5 };
		System.out.println(solve(A));

	}

}
