package bakjoon.dynamicProgramming.longestUpSubSequence_11053;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
	static int[] seq;
	static Integer[] dp;

	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		
		seq = new int[N ];
		dp = new Integer[N ];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			seq[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < N; i++) {
			find(i);
		}
		
		int max = dp[0];
		
		for(int i = 1; i < N; i++) {
			max = Math.max(max, dp[i]);
		}
		
		System.out.println(max);
	}
	
	// 재귀함수
	static int find(int N) {
		if(dp[N] == null) {
			dp[N] = 1;
			
			for(int i = N - 1; i >= 0; i--) {
				if(seq[i] < seq[N]) {
					dp[N] = Math.max(dp[N], find(i) + 1);
				}
			}
		}
		return dp[N];
	}
}