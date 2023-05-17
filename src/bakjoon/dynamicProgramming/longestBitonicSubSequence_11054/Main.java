package bakjoon.dynamicProgramming.longestBitonicSubSequence_11054;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
	static int[] seq;
	static Integer[] down_dp;
	static Integer[] up_dp;

	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		
		seq = new int[N];
		down_dp = new Integer[N];
		up_dp = new Integer[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			seq[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < N; i++) {
			LIS(i);
			LDS(i);
		}
		
		int max = -1;
		
		for(int i = 0; i < N; i++) {
			max = Math.max(down_dp[i] + up_dp[i], max);
		}
		
		System.out.println(max - 1);
	}
	
	static int LIS(int N) {
		if(down_dp[N] == null) {
			down_dp[N] = 1;
			
			for(int i = N - 1; i >= 0; i--) {
				if(seq[i] < seq[N]) {
					down_dp[N] = Math.max(down_dp[N], LIS(i) + 1);
				}
			}
		}
		return down_dp[N];
	}
	
	static int LDS(int N) {
		if(up_dp[N] == null) {
			up_dp[N] = 1;
			
			for(int i = N + 1; i < up_dp.length; i++) {
				if(seq[i] < seq[N]) {
					up_dp[N] = Math.max(up_dp[N], LDS(i) + 1);
				}
			}
		}
		return up_dp[N];
	}
}