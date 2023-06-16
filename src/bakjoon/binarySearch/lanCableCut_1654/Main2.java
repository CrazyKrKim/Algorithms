package bakjoon.binarySearch.lanCableCut_1654;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main2 {		
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] arrN = new int[N];
		
		long max = 0;
		
		for(int i = 0; i < N; i++) {
			arrN[i] = Integer.parseInt(br.readLine());
			
			if(max < arrN[i]) {
				max = arrN[i];
			}
		}
		
		max++;
		
		long min = 0;
		long mid = 0;
		
		while(min < max) {
			mid = (max + min) / 2;
			
			long count = 0;
			
			for(int i = 0; i < N; i++) {
				count += (arrN[i] / mid);
			}
			
			if(count < M) {
				max = mid;
			} else {
				min = mid + 1;
			}
		}
		
		System.out.println(min - 1);
	}
}