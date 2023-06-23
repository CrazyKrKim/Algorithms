package bakjoon.dynamicProgramming2.fileCombine_11066;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		for(int t = 0; t < T; t++) {
			int K = Integer.parseInt(br.readLine());
			int[] novel = new int[K + 1];
			int[] sum = new int[K + 1];
			int[][] dp = new int[K + 1][K + 1];
			
			st = new StringTokenizer(br.readLine(), " ");
			
			for(int i = 1; i <= K; i++) {
				novel[i] = Integer.parseInt(st.nextToken());
				sum[i] = sum[i - 1] + novel[i];
			}
			
			for(int n = 1; n <= K; n++) {
				for(int from = 1; from + n <= K; from++) {
					int to = from + n;
					
					dp[from][to] = Integer.MAX_VALUE;
					
					for(int divide = from; divide < to; divide++) {
						dp[from][to] = Math.min(dp[from][to], dp[from][divide] + dp[divide + 1][to] + sum[to] - sum[from - 1]);
					}
				}
			}
			
			System.out.println(dp[1][K]);
		}
	}
}