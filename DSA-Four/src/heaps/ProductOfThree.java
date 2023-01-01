package heaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

//		Given an integer array A of size N.
//		You have to find the product of the three largest integers 
//		in array A from range 1 to i, where i goes from 1 to N.
//		Return an array B where B[i] is the product of the largest 3 integers 
//		in range 1 to i in array A. If i < 3, then the integer at index i in B should be -1.
//		Input :							Output:
//			 A = [1, 2, 3, 4, 5]			 [-1, -1, 6, 24, 60]
public class ProductOfThree {

	public static ArrayList<Integer> solve(ArrayList<Integer> A) {
		PriorityQueue<Integer> minh = new PriorityQueue<>();

		ArrayList<Integer> arr = new ArrayList<>();
		for (int i = 0; i < 3 && i < A.size(); i++) {
			minh.add(A.get(i)); // adding first element
			if (i < 2)
				arr.add(-1); // since one element is missing so adding -1 to ans
			else {
				arr.add(A.get(0) * A.get(1) * A.get(2)); // for 3rd element taking multiplication
			}
		}

		for (int i = 3; i < A.size(); i++) {
			int ele = A.get(i);
			if (ele > minh.peek()) { // if coming element is greater than top , removing top and adding
				minh.poll();
				minh.add(ele);
			}
			int m1 = minh.poll();
			int m2 = minh.poll(); // taking top 3 element
			int m3 = minh.poll();
			arr.add(m1 * m2 * m3); // adding multiplication to arr
			minh.add(m1);
			minh.add(m2); // again making things as is
			minh.add(m3);
		}
		return arr;
	}

	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
		ArrayList<Integer> ans = solve(arr);
		for (int i = 0; i < ans.size(); i++) {
			System.out.print(ans.get(i) + " ");
		}

	}

}
