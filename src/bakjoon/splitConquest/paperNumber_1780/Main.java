package bakjoon.splitConquest.paperNumber_1780;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {	
	static int low = 0;
	static int middle = 0;
	static int high = 0;
	static int[][] board;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		
		StringTokenizer st;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			for(int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}	
		}
		
		partition(0, 0, N);
		
		System.out.println(low);
		System.out.println(middle);
		System.out.println(high);
	}
	
	static void partition(int row, int col, int size) {
		if(paperCheck(row, col, size)) {
			if(board[row][col] == -1) {
				low++;
			} else if(board[row][col] == 0) {
				middle++;
			} else {
				high++;
			}
			
			return;
		}
		
		int newSize = size / 3;
		
		partition(row, col, newSize);
		partition(row, col + newSize, newSize);
		partition(row, col + (newSize * 2), newSize);
		partition(row + newSize, col, newSize);
		partition(row + newSize, col + newSize, newSize);
		partition(row + newSize, col + (newSize * 2), newSize);
		partition(row + (newSize * 2), col, newSize);
		partition(row + (newSize * 2), col + newSize, newSize);
		partition(row + (newSize * 2), col + (newSize * 2), newSize);
	}
	
	static boolean paperCheck(int row, int col, int size) {
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