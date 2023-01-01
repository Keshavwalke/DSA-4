package heaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

//		Given an array of integers, A denoting a stream of integers. 
//		New arrays of integer B and C are formed.
//		Each time an integer is encountered in a stream, append it at the end of B 
//		and append the median of array B at the C.
//		Find and return the array C.
//		NOTE:
//		If the number of elements is N in B and N is odd, 
//		then consider the median as B[N/2] ( B must be in sorted order).
//		If the number of elements is N in B and N is even, then consider 
//		the median as B[N/2-1]. ( B must be in sorted order).
//		Input :							Output:
//			 A = [1, 2, 5, 4, 3]			 [1, 1, 2, 2, 3]
public class RunningMedian {

	public static ArrayList<Integer> solve(ArrayList<Integer> A) {
		PriorityQueue<Integer> minh = new PriorityQueue<Integer>(); // minheap
		PriorityQueue<Integer> maxh = new PriorityQueue<>(Comparator.reverseOrder()); // maxheeap
		ArrayList<Integer> arr = new ArrayList<>();
		maxh.add(A.get(0)); // inserted first element in maxheap and arr
		arr.add(A.get(0));

		for (int i = 1; i < A.size(); i++) { // Idea: storing smallest element in maxheap & and biggest ele in minheap
			int ele = A.get(i);
			if (ele < maxh.peek()) { // if coming element less than max of maxheap pushing inside maxheap
				maxh.add(ele);
			} else {
				minh.add(ele); // else in minheap
			}
			if (maxh.size() - minh.size() > 1) { // if size diff greater than 1 mean maxheap has extra element
				int trans = maxh.poll(); // removing top element and pushing to minheap
				minh.add(trans);
			}
			if (maxh.size() - minh.size() < 0) { // if size diff less than 0 means minheap has extra element
				int trans = minh.poll(); // pushing min element to maxheap
				maxh.add(trans);
			}
			
			arr.add(maxh.peek()); // pushing top ele of maxheap
		}
		return arr;
	}

	public static void main(String[] args) {
		ArrayList<Integer> arr= new ArrayList<>(Arrays.asList(1,2,5,4,3));
		System.out.println(solve(arr));
	}

}
