package bakjoon.binarySearch.treeCut_2805;

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
		
		int[] arrN = new int[N];
		
		int max = 0;
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			arrN[i] = Integer.parseInt(st.nextToken());
			
			if(max < arrN[i]) {
				max = arrN[i];
			}
		}
		
		int min = 0;
		int mid = 0;
		
		while(min < max) {
			mid = (max + min) / 2;
			
			long sum = 0;
			
			for(int i = 0; i < N; i++) {
				int height = arrN[i] - mid;
				
				if(height < 0) {
					height = 0;
				}
				sum += height;
			}
			
			if(sum < M) {
				max = mid;
			} else {
				min = mid + 1;
			}
		}
		
		System.out.println(min - 1);
	}
}