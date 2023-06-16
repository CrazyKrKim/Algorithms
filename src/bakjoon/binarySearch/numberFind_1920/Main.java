package bakjoon.binarySearch.numberFind_1920;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arrN = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			arrN[i] = Integer.parseInt(st.nextToken());
		}
		
		int M = Integer.parseInt(br.readLine());
		
		int[] arrM = new int[M];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < M; i++) {
			arrM[i] = Integer.parseInt(st.nextToken());
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < M; i++) {
			boolean isFind = false;
			
			for(int j = 0; j < N; j++) {
				if(arrN[j] == arrM[i]) {
					isFind = true;
					break;
				}
			}
			
			if(isFind) {
				sb.append("1\n");
			} else {
				sb.append("0\n");				
			}
		}
		
		System.out.println(sb);
	}
}