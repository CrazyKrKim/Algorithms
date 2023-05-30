package bakjoon.greedyAlgorithm.gasStation_13305;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main3 {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		long[][] arr = new long[2][N];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N - 1; i++) {
			arr[0][i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N - 1; i++) {
			arr[1][i] = Integer.parseInt(st.nextToken());
		}
		
		long min = arr[1][0];
		long sum = arr[0][0] * arr[1][0];
		
		for(int i = 1; i < N - 1; i++) {
			if(min > arr[1][i]) {
				min = arr[1][i];
				
				sum += arr[0][i] * arr[1][i];
			} else {
				sum += arr[0][i] * min;
			}
		}		
		
		System.out.print(sum);
	}
}