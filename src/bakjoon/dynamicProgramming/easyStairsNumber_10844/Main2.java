package bakjoon.dynamicProgramming.easyStairsNumber_10844;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main2 {
	static long[][] dp;
	static int N;
	final static long MOD = 1000000000;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		
		dp = new long[N + 1][10];
		
		for(int i = 1; i < 10; i++) {
			dp[1][i] = 1;
		}
		
		long result = 0;
		
		for(int i = 2; i <= N; i++) {
			for(int j = 0; j < 10; j++) {
				
				if(j == 0) {
					dp[i][0] = dp[i - 1][1] % MOD;
				} else if(j == 9) {
					dp[i][9] = dp[i - 1][8] % MOD;
				} else {
					dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % MOD;
				}
			}
		}
		
		for(int i = 0; i < 10; i++) {
			result += dp[N][i];
		}
		
		System.out.print(result % MOD);
	}
}