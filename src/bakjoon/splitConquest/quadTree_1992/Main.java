package bakjoon.splitConquest.quadTree_1992;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {	
	static String result = "";
	static int[][] board;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			
			for(int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(str.substring(j, j+1));
			}	
		}
		
		partition(0, 0, N);
		
		System.out.println(result);
	}
	
	static void partition(int row, int col, int size) {
		if(colorCheck(row, col, size)) {
			if(board[row][col] == 0) {
				result = result + "0";
			} else {
				result = result + "1";
			}
			
			return;
		}
		
		int newSize = size / 2;

		result = result + "(";
		partition(row, col, newSize);
		partition(row, col + newSize, newSize);
		partition(row + newSize, col, newSize);
		partition(row + newSize, col + newSize, newSize);
		result = result + ")";		
	}
	
	static boolean colorCheck(int row, int col, int size) {
		int color = board[row][col];
		
		for(int i = row; i < row + size; i++) {
			for(int j = col; j < col + size; j++) {
				if(board[i][j] != color) {
					return false;
				}
			}
		}
		
		return true;
	}
}