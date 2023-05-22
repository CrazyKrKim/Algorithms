package bakjoon.dynamicProgramming.cable_2565;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
	static int[][] wire;
	static Integer[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		
		dp = new Integer[N];
		wire = new int[N][2];
		
		StringTokenizer st;
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			wire[i][0] = Integer.parseInt(st.nextToken());
			wire[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(wire, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});
		
		int max = 0;
		
		for(int i = 0; i < N; i++) {
			max = Math.max(wire(i), max);
		}
		
		System.out.print(N - max);
	}
	
	// 재귀함수
	static int wire(int N) {
		if(dp[N] == null) {
			dp[N] = 1;
			
			for(int i = N; i < dp.length; i++) {
				if(wire[N][1] < wire[i][1]) {
					dp[N] = Math.max(dp[N], wire(i) + 1);
				}
			}
		}
		
		return dp[N];
	}
}