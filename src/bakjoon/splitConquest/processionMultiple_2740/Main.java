package bakjoon.splitConquest.processionMultiple_2740;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {	
	static int[][] firstArr;
	static int[][] secondArr;
	static int[][] resultArr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int firstY = Integer.parseInt(st.nextToken());
		int firstX = Integer.parseInt(st.nextToken());
		
		firstArr = new int[firstY][firstX];
		
		for(int i = 0; i < firstY; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			for(int j = 0; j < firstX; j++) {				
				firstArr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine(), " ");
		int secondY = Integer.parseInt(st.nextToken());
		int secondX = Integer.parseInt(st.nextToken());
		
		secondArr = new int[secondY][secondX];
		
		for(int i = 0; i < secondY; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			for(int j = 0; j < secondX; j++) {				
				secondArr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		resultArr = new int[firstY][secondX];
		
		for(int i = 0; i < firstY; i++) {
			for(int j = 0; j < secondX; j++) {
				int sum = 0;
				for(int k = 0; k < firstX; k++) {
					sum += firstArr[i][k] * secondArr[k][j];
				}
				
				resultArr[i][j] = sum;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < firstY; i++) {
			for(int j = 0; j < secondX; j++) {
				sb.append(resultArr[i][j]).append(" ");
			}
			
			sb.append("\n");
		}
		
		System.out.print(sb);
	}
}