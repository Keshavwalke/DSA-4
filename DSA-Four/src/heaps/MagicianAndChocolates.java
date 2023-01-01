package heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

//		Given N bags, each bag contains Bi chocolates. There is a kid and a magician.
//		In a unit of time, the kid can choose any bag i, and eat Bi chocolates from it, 
//		then the magician will fill the ith bag with floor(Bi/2) chocolates.
//		Find the maximum number of chocolates that the kid can eat in A units of time.
//		NOTE:
//		floor() function returns the largest integer less than or equal to a given number.
//		Return your answer modulo 10^9 + 7
//		Input :				Output:
//			 A = 3				14
//			 B = [6, 5]
public class MagicianAndChocolates {
	public static int solve(int A, int[] B) {
		PriorityQueue<Integer> maxh = new PriorityQueue<>(Comparator.reverseOrder());

		for (int i = 0; i < B.length; i++) {
			maxh.add(B[i]);
		}

		long sum = 0;
		int m = 1000000007;

		for (int i = 1; i <= A; i++) {
			int ele = maxh.poll();
			sum = (sum + ele) % m;
			maxh.add(ele / 2);
		}

		return (int) sum;
	}

	public static void main(String[] args) {
		int A = 3;
		int[] B = { 6, 5 };
		System.out.println(solve(A, B));

	}

}
