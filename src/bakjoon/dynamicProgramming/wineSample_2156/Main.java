package bakjoon.dynamicProgramming.wineSample_2156;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
	static int[] stair;
	static Integer[] dp;

	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		
		stair = new int[N + 1];
		dp = new Integer[N + 1];
		
		for(int i = 1; i <= N; i++) {
			stair[i] = Integer.parseInt(br.readLine());
		}
		
		dp[0] = 0;
		dp[1] = stair[1];
		
		if(N > 1) {
			dp[2] = stair[1] + stair[2];
		}
		
		System.out.print(find(N));
	}
	
	// 재귀함수
	static int find(int N) {
		if(dp[N] == null) {
			dp[N] = Math.max(Math.max(find(N - 2), find(N - 3) + stair[N - 1]) + stair[N], find(N - 1));
		}
		
		return dp[N];
	}
}