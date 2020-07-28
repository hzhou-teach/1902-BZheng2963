/*
Bill Zheng
Time: 22 min
USACO Test Cases: ********** 10/10
1-10 Difficulty: 3.5 because the solution wasn't super clear to me
Reflection: This problem was tricky because I didn't really understand how to find the solution initially. I didn't know if there
	was a trick or something, but once I started coding and just trying to find a "bronze" solution, the code ultimately worked out.
	The problem felt like it was tougher or more tricky than it actually was, so I think I shouldn't be as scared going into problems
	like these in the future.
 */

import java.io.*;
import java.util.*;

public class revegetate_1902_bronze {
//--------------------------------------------------------------------------------------------------------------------------
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner (new File ("revegetate.in"));
//--------------------------------------------------------------------------------------------------------------------------
		int N = scan.nextInt();
		int M = scan.nextInt();
		int[] fields = new int[N+1];
		boolean[][] con = new boolean[N+1][N+1];
		
		for (int i = 0; i < M; i++) {
			int a = scan.nextInt();
			int b = scan.nextInt();
			con[a][b] = true;
			con[b][a] = true;
		}
		fields[1] = 1;
//--------------------------------------------------------------------------------------------------------------------------
		boolean one = false;
		boolean two = false;
		boolean three = false;
		boolean four = false;
		for (int i = 2; i < N+1; i++) {
			one = false;
			two = false;
			three = false;
			four = false;
			for (int j = 1; j < N+1; j++) {
				if (con[i][j]) {
					if (fields[j] == 1) one = true;
					if (fields[j] == 2) two = true;
					if (fields[j] == 3) three = true;
					if (fields[j] == 4) four = true;
				}
			}
			if (!one) fields[i] = 1;
			else if (!two) fields[i] = 2;
			else if (!three) fields[i] = 3;
			else if (!four) fields[i] = 4;
		}
//--------------------------------------------------------------------------------------------------------------------------
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("revegetate.out")));
		for (int i = 1; i < N+1; i++) {
			System.out.print(fields[i]);
			out.print(fields[i]);
		}

		out.close();
		scan.close();
	}
}
