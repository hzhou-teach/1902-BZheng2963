/*
Bill Zheng
Time: 10 min bronze method 5/10 --- 1+ hours
USACO Test Cases: *********t 9/10
1-10 Difficulty: 7
Reflection: I did the bronze method quickly but then couldn't figure out a better solution. I spent 30 min trying stuff and then
	resorted to checking the solution which said to use a prefix sum. I tried to implement one, but failed. Ended up copying the solution
	to see if I could understand and code it. I understood the solution in the end which was good, but for some reason the 10th case
	kept timing out still.
 */

import java.io.*;
import java.util.*;

public class paintbarn_1902_silver {
//--------------------------------------------------------------------------------------------------------------------------
	public static void main(String[] args) throws IOException {
		//Scanner scan = new Scanner(new File("D:\\eclipse-workspace\\USACO\\Silver\\testSilver.txt"));
		Scanner scan = new Scanner (new File ("paintbarn.in"));
//--------------------------------------------------------------------------------------------------------------------------
		int N = scan.nextInt();
		int K = scan.nextInt();
//--------------------------------------------------------------------------------------------------------------------------
		int[][] grid = new int[1000][1001];
		
		for (int i = 0; i < N; i++) {
			int x1 = scan.nextInt();
			int y1 = scan.nextInt();
			int x2 = scan.nextInt();
			int y2 = scan.nextInt();
			for (int j = x1; j < x2; j++) {
				grid[j][y1]++;
				grid[j][y2]--;
			}
		}
//--------------------------------------------------------------------------------------------------------------------------
		int count = 0;
		for (int i = 0; i < 1000; i++) {
			for (int j = 0; j < 1000; j++) {
				if (grid[i][j]==K) count++;
				grid[i][j+1] += grid[i][j];
			}
		}
//--------------------------------------------------------------------------------------------------------------------------
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("paintbarn.out")));
		out.println(count);

		out.close();
		scan.close();
	}
}
