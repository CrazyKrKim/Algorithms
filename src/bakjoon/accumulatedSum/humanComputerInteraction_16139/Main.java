package bakjoon.accumulatedSum.humanComputerInteraction_16139;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				
		String str = br.readLine();
		char[] arrStr = new char[str.length()];
		
		for(int i = 0; i < str.length(); i++) {
			arrStr[i] = str.charAt(i);
		}
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			char text = st.nextToken().charAt(0);
			
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			int count = 0;
			for(int j = start; j <= end; j++) {
				if(arrStr[j] == text) {
					count++;
				}
			}
			
			sb.append(count).append("\n");
		}
		
		System.out.print(sb);
	}
}