package bakjoon.dynamicProgramming2.arrMultiSeq_11049;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
	
	static int N;
	static int row;
	static int col;
	static int[][] arr;
	static int[][] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N][2];
		dp = new int[N][N];
		
		StringTokenizer st;
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			row = Integer.parseInt(st.nextToken());
			col = Integer.parseInt(st.nextToken());
			
			arr[i][0] = row;
			arr[i][1] = col;
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(i == j) {
					dp[i][j] = 0;
				} else {
					dp[i][j] = Integer.MAX_VALUE;
				}
			}
		}
		
		for(int col = 1; col < N; col++) {
			for(int i = 0; i + col < N; i++) {
				calculate(i, i + col);
			}
		}
		
		System.out.println(dp[0][N - 1]);
	}
	
	static void calculate(int start, int end) {
		for(int i = start; i < end; i++) {
			int cost = dp[start][i] + dp[i + 1][end] + arr[start][0] * arr[i][1] * arr[end][1];
			dp[start][end] = Math.min(dp[start][end], cost);
		}
	}
}