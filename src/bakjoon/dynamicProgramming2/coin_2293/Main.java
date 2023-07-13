package bakjoon.dynamicProgramming2.coin_2293;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {	
	static int[] coin;
	static int[] dp;
	static int n;
	static int k;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		coin = new int[n];
		dp = new int[k + 1];
		
		for(int i = 0; i < n; i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}
		
		dp[0] = 1;
		
		for(int i = 0; i < n; i++) {
			for(int j = 1; j <= k; j++) {
				if(j >= coin[i]) {
					dp[j] += dp[j - coin[i]];
				}
			}
		}
		
		System.out.println(dp[k]);
	}
}