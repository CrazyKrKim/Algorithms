package bakjoon.greedyAlgorithm.coin_11047;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main2 {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] arrRest = new int[N];
		
		for(int i = 0; i < N; i++) {
			arrRest[i] = Integer.parseInt(br.readLine());
		}
		
		int count = 0;
		for(int i = N - 1; 0 <= i; i--) {
			if(arrRest[i] <= K) {
				count = count + (K / arrRest[i]);
				K = K % arrRest[i];
			}
		}
		
		System.out.print(count);
	}
}