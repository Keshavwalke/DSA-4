package heaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

//		N people having different priorities are standing in a queue.
//		The queue follows the property that each person is standing at most B places 
//		away from its position in the sorted queue.
//		Your task is to sort the queue in the increasing order of priorities.
//		NOTE:
//		No two persons can have the same priority.
//		Use the property of the queue to sort the queue with complexity O(NlogB).
//		Input :							Output:
//			 A = [1, 40, 2, 3]				 [1, 2, 3, 40]
//			 B = 2
public class KPlacesApart {
	public static ArrayList<Integer> solve(ArrayList<Integer> A, int B) {
		PriorityQueue<Integer> minh = new PriorityQueue<>(); // created minheap
		ArrayList<Integer> arr = new ArrayList<>();

		for (int i = 0; i < B; i++) { // first added B elements to heap
			minh.add(A.get(i));
		}
		for (int i = B; i < A.size(); i++) { // each time adding 1 element removing 1 element
			minh.add(A.get(i));
			arr.add(minh.poll()); // since sorted position is B apart so this logic will work
		}
		while (minh.size() > 0) {
			arr.add(minh.poll()); // adding rest elements from heap to ArrayList
		}
		return arr;

	}

	public static void main(String[] args) {
		ArrayList<Integer> A=new ArrayList<>(Arrays.asList(1,40,2,3));
		int B=2;
		
		System.out.println(solve(A,B));

	}

}
