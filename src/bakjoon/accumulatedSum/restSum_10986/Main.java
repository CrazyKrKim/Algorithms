package bakjoon.accumulatedSum.restSum_10986;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] arrN = new int[N+1];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 1; i <= N; i++) {
			arrN[i] = arrN[i-1] + Integer.parseInt(st.nextToken());
		}
		
		int count = 0;
		for(int i = N; i > 0; i--) {
			for(int j = 0; j < N - i + 1; j++) {
				int sum = arrN[j+i] - arrN[j];
				
				if(sum % M == 0) {
					count++;
				}
			}
		}
		
		System.out.print(count);
	}
}