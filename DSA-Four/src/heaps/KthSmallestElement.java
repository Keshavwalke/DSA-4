package heaps;

import java.util.PriorityQueue;

//		Find the Bth smallest element in given array A .
//		NOTE: Users should try to solve it in less than equal to B swaps.
//		Input :						Output:
//		A = [2, 1, 4, 3, 2]				2
//		B = 3
public class KthSmallestElement {
	public static int kthsmallest(int[] A, int B) {
		PriorityQueue<Integer> minh = new PriorityQueue<>();

		for (int i = 0; i < A.length; i++) {
			minh.add(A[i]); // Inserted all elements to minheap
		}
		for (int i = 1; i < B; i++) { // removed B-1 elements
			minh.poll();
		}
		return minh.poll(); // return head element which is Bth smallest element
	}

	public static void main(String[] args) {
		int[] A = { 2, 1, 4, 3, 2 };
		int B = 3;
		System.out.println(kthsmallest(A, B));

	}

}
