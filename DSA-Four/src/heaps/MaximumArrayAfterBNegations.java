package heaps;

import java.util.PriorityQueue;

//		Given an array of integers A and an integer B. You must modify the array 
//		exactly B number of times. In a single modification,
//		we can replace any one array element A[i] by -A[i].
//		You need to perform these modifications in such a way that after exactly B modifications, 
//		sum of the array must be maximum.
//		Input 	:								Output:
//			 A = [24, -68, -29, -9, 84]				196
//			 B = 4
public class MaximumArrayAfterBNegations {

	public static int solve(int[] A, int B) {
		PriorityQueue<Integer> minh = new PriorityQueue<>(); // created minheap

		for (int i = 0; i < A.length; i++) {
			minh.add(A[i]); // added all element in minheap
		}

		for (int i = 1; i <= B; i++) {
			int ele = -1 * (minh.poll()); // smallest element * -1
			minh.add(ele); // added to minheap
		}
		int sum = 0;
		while (minh.size() > 0) {
			sum += minh.poll(); // sumed up all elements from minheap
		}

		return sum;
	}

	public static void main(String[] args) {
		int[] A = { 24, -68, -29, -9, 84 };
		int B = 4;
		System.out.println(solve(A, B));

	}

}
