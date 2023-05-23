package bakjoon.accumulatedSum.progression_2559;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main2 {
	static int max = Integer.MIN_VALUE;
	
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
		
		for(int i = 1; i <= N-M+1; i++) {
			int comp = arrN[i + M - 1] - arrN[i-1];
			if(max < comp) {
				max = comp;
			}
		}
		
		System.out.print(max);
	}
}