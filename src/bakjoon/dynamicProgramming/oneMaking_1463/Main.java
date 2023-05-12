package bakjoon.dynamicProgramming.oneMaking_1463;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		
		System.out.print(find(N, 0));
	}
	
	// 재귀함수
	static int find(int N, int count) {
		if(N < 2) {
			return count;
		}
		
		return Math.min(find(N / 2, count + 1 + (N % 2)), find(N / 3, count + 1 + (N % 3)));
	}
}