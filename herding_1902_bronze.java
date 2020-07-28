/*
Bill Zheng
Time: 8 min
USACO Test Cases: ********** 10/10
1-10 Difficulty: 2
Reflection: Finding the solution is the hardest part though still easy, just some math and thinking. Missed case 2 initially
	then found the edge case and fixed it easily. Code is pretty simple.
 */

import java.io.*;
import java.util.*;

public class herding_1902_bronze {
//--------------------------------------------------------------------------------------------------------------------------
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner (new File ("herding.in"));
//--------------------------------------------------------------------------------------------------------------------------
		int a = scan.nextInt();
		int b = scan.nextInt();
		int c = scan.nextInt();
//--------------------------------------------------------------------------------------------------------------------------
		int min = 0;
		int max = -1;
		
		int dist1 = Math.abs(a-b);
		int dist2 = Math.abs(b-c);
		
		if (dist1 == 2 || dist2 == 2) {
			min = 1;
		} else if (dist1 == 1 && dist2 == 1) {
			min = 0;
		} else min = 2;
		
		max = Math.max(dist1, dist2)-1;
//--------------------------------------------------------------------------------------------------------------------------
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("herding.out")));
		out.println(min);
		out.println(max);

		out.close();
		scan.close();
	}
}
