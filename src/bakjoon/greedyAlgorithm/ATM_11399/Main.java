package bakjoon.greedyAlgorithm.ATM_11399;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");;
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int sum = 0;
		int sumSum = 0;
		
		for(int i = 0; i < N; i++) {
			sumSum = sumSum + arr[i];
			sum = sum + sumSum;
		}
		
		System.out.print(sum);
	}
}