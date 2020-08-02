/*
Bill Zheng
Time: 1 hour 25 min
USACO Test Cases: ************ 12/12
1-10 Difficulty: 6.5
Reflection: I don't think I was in the right mindset when approaching this problem because I felt really slow. Finding the
	initial solutions were slow and then implementing the code was even slower. I think if I did this at my best, I could have
	halved the time it took, but in the end I still got everything right. After 1 hour, I had 9/12 cases correct because I missed
	1 edge case which took me some time to find and then implement. I looked at the solution to see how to implement the edge case.
	Overall, given the time it took me and the edge case which was hard to find, it was a decently hard problem, but I could have
	done a lot better.
 */

import java.io.*;
import java.util.*;

public class herding_1902_silver {
//--------------------------------------------------------------------------------------------------------------------------
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner (new File ("herding.in"));
//--------------------------------------------------------------------------------------------------------------------------
		int N = scan.nextInt();
		int[] list = new int[N];
		
		for (int i = 0; i < N; i++) {
			list[i] = scan.nextInt();
		}
		Arrays.sort(list);
//--------------------------------------------------------------------------------------------------------------------------
		int max = 0;
		int count = 0;
		for (int i = 0; i < N; i++) {
			count = 0;
			for (int j = i; j < N; j++) {
				if (list[j] < list[i] + N) {
					count++;
				} else break;
			}
			max = Math.max(max, count);
		}
		int min_moves = N-max;
		//edge cases
		if (list[N-2]-list[0] == N-2 && list[N-1]-list[N-2] > 2) min_moves++;
		if (list[N-1]-list[1] == N-2 && list[1]-list[0] > 2) min_moves++;
//--------------------------------------------------------------------------------------------------------------------------
		int max_moves = 0;
		if (list[1]-list[0] < list[N-1]-list[N-2]) {
			max_moves = (list[N-1] - (list[1]+1))-(N-3);
		} else {
			max_moves = (list[N-2]-1)-list[0]-(N-3);
		}
//--------------------------------------------------------------------------------------------------------------------------
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("herding.out")));
		System.out.println(min_moves);
		System.out.println(max_moves);
		out.println(min_moves);
		out.println(max_moves);

		out.close();
		scan.close();
	}
}
