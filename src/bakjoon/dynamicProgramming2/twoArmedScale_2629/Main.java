package bakjoon.dynamicProgramming2.twoArmedScale_2629;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {	
	static boolean[][] isPossible;
	static int[] weight;
	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		weight = new int[N];
		isPossible = new boolean[N + 1][15001];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			weight[i] = Integer.parseInt(st.nextToken());
		}
		
		dp(0, 0);
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < M; i++) {
			int bead = Integer.parseInt(st.nextToken());
			
			if(bead > 15000) {
				sb.append("N ");
			} else {
				if(isPossible[N][bead]) {
					sb.append("Y ");
				} else {
					sb.append("N ");
				}
			}
		}
		
		System.out.println(sb.toString());
	}
	
	static void dp(int cnt, int w) {
		if(isPossible[cnt][w]) {
			return;
		}
		
		isPossible[cnt][w] = true;
		
		if(cnt == N) {
			return;
		}
		
		dp(cnt + 1, w + weight[cnt]);
		
		dp(cnt + 1, w);
		
		dp(cnt + 1, Math.abs(w - weight[cnt]));
	}
}