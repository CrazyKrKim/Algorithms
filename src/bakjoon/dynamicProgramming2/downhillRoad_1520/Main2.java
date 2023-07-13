package bakjoon.dynamicProgramming2.downhillRoad_1520;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main2 {	
	static int row;
	static int col;
	static int[][] arr, dp;
	static int[] rangeX = { -1, 0, 1, 0};
	static int[] rangeY = { 0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		
		arr = new int[row + 1][col + 1];
		dp = new int[row + 1][col + 1];
		
		for(int i = 1; i <= row; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 1; j <= col; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = -1;
			}
		}
		
		System.out.println(dp(1, 1));
	}
	
	static int dp(int r, int c) {
		if(r == row && c == col) {
			return 1;
		}
		
		if(dp[r][c] != -1) {
			return dp[r][c];
		}
		
		dp[r][c] = 0;
		for(int i = 0; i < 4; i++) {
			int dx = r + rangeX[i];
			int dy = c + rangeY[i];
			
			if(dx < 1 || dy < 1 || dx > row || dy > col) {
				continue;
			}
			
			if(arr[r][c] > arr[dx][dy]) {
				dp[r][c] += dp(dx, dy);
			}
		}
		
		return dp[r][c];
	}
}