package bakjoon.binarySearch.numberFind_1920;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main2 {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arrN = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			arrN[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arrN);
		
		int M = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < M; i++) {
			if(binarySearch(arrN, Integer.parseInt(st.nextToken())) >= 0) {
				sb.append("1\n");
			} else {
				sb.append("0\n");				
			}
		}
		
		System.out.println(sb);
	}
	
	static int binarySearch(int[] arr, int key) {
		int lo = 0;
		int hi = arr.length - 1;
		
		while(lo <= hi) {
			int mid = (lo + hi) / 2;
			
			if(key < arr[mid]) {
				hi = mid - 1;
			} else if(key > arr[mid]) {
				lo = mid + 1;
			} else {
				return mid;
			}			
		}
		
		return -1;
	}
}