package bakjoon.dynamicProgramming2.downhillRoad_1520;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {	
	static int row;
	static int col;
	static int[][] arr;
	static boolean[][] dp;
	static int count;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		
		arr = new int[row][col];
		dp = new boolean[row][col];
		
		for(int i = 0; i < row; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < col; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = true;
			}
		}
		
		dp(0, 0, "");
		
		System.out.println(count);
	}
	
	static void dp(int r, int c, String dir) {
		if(r == row-1 && c == col-1) {
			count++;
			return;
		}
		
		if(dp[r][c] == false) {
			return;
		}

		// 동쪽에서 옴
		if(dir.equals("E")) {
			if(arr[r][c] >= arr[r][c-1]) {
				dp[r][c] = false;
				return;
			}
		}

		// 서쪽에서 옴
		if(dir.equals("W")) {
			if(arr[r][c] >= arr[r][c+1]) {
				dp[r][c] = false;
				return;
			}
		}

		// 남쪽에서 옴
		if(dir.equals("S")) {
			if(arr[r][c] >= arr[r-1][c]) {
				dp[r][c] = false;
				return;
			}
		}

		// 북쪽에서 옴
		if(dir.equals("N")) {
			if(arr[r][c] >= arr[r+1][c]) {
				dp[r][c] = false;
				return;
			}
		}
		
		// 동쪽으로 이동
		if(c < col-1) {
			dp(r, c + 1, "E");
		}
		
		// 서쪽으로 이동
		if(c > 0) {
			dp(r, c - 1, "W");
		}
		
		// 남쪽으로 이동
		if(r < row-1) {
			dp(r + 1, c, "S");
		}
		
		// 북쪽으로 이동
		if(r > 0) {
			dp(r - 1, c, "N");
		}
	}
}