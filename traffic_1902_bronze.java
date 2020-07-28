/*
Bill Zheng
Time: 35 min
USACO Test Cases: ********** 10/10
1-10 Difficulty: 3.5 because of the tricky test case
Reflection: Overall the solution to this problem is not that hard, it's just how to implement the solution and make sense of the
	problem. I think I spent the most time understanding what the problem was asking for, and then implementing the solution
	was pretty quick. I had to debug for test case 2 and eventually looked at the input file for test case 2. I didn't think
	about negative numbers and had to put that into by code to finally get test case 2. I got 9/10 at 25 min and 10/10 at 35.
 */

import java.io.*;
import java.util.*;

public class traffic_1902_bronze {
//--------------------------------------------------------------------------------------------------------------------------
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner (new File ("traffic.in"));
//--------------------------------------------------------------------------------------------------------------------------
		int N = scan.nextInt();
		int[][] traf = new int[N+1][3];
		
		for (int i = 1; i < N+1; i++) {
			String status = scan.next();
			if (status.equals("on")) traf[i][0] = 1;
			else if (status.equals("off")) traf[i][0] = 0;
			else traf[i][0] = -1;
			traf[i][1] = scan.nextInt();
			traf[i][2] = scan.nextInt();
		}
//--------------------------------------------------------------------------------------------------------------------------
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("traffic.out")));

		int lower = -99999999;
		int higher = 99999999;
		for (int i = N; i >= 1; i--) { //going backwards to find before 1
			if (traf[i][0] == 0) { //off
				lower += traf[i][1];
				higher += traf[i][2];
			} else if (traf[i][0] == 1) { //on
				lower -= traf[i][2];
				higher -= traf[i][1];
			} else {
				lower = Math.max(lower, traf[i][1]);
				higher = Math.min(higher, traf[i][2]);
			}
			lower = Math.max(0, lower); //tricky test case
			higher = Math.max(0, higher);
		}
		System.out.println(lower + " " + higher);
		out.println(lower + " " + higher);
//--------------------------------------------------------------------------------------------------------------------------
		lower = -99999999;
		higher = 99999999;
		for (int i = 1; i < N+1; i++) { //going forwards to find after N
			if (traf[i][0] == 1) { //on
				lower += traf[i][1];
				higher += traf[i][2];
			} else if (traf[i][0] == 0) { //off
				lower -= traf[i][2];
				higher -= traf[i][1];
			} else {
				lower = Math.max(lower, traf[i][1]);
				higher = Math.min(higher, traf[i][2]);
			}
			lower = Math.max(0, lower);
			higher = Math.max(0, higher);
		}
		System.out.println(lower + " " + higher);
		out.println(lower + " " + higher);
//--------------------------------------------------------------------------------------------------------------------------
		out.close();
		scan.close();
	}
}
