package bakjoon.dynamicProgramming.oneMaking_1463;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main2 {
	static Integer[] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		
		dp = new Integer[N + 1];
		dp[0] = dp[1] = 0;
		
		System.out.print(find(N));
	}
	
	// 재귀함수
	static int find(int N) {
		if(dp[N] == null) {
			if(N % 6 == 0) {
				dp[N] = Math.min(find(N - 1), Math.min(find(N / 3), find(N / 2))) + 1;
			} else if(N % 3 == 0) {
				dp[N] = Math.min(find(N / 3), find(N - 1)) + 1;
			} else if(N % 2 == 0) {
				dp[N] = Math.min(find(N / 2), find(N - 1)) + 1;
			} else {
				dp[N] = find(N - 1) + 1;
			}
		}
		
		return dp[N];
	}
}