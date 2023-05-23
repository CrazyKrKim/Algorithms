package bakjoon.accumulatedSum.humanComputerInteraction_16139;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main2 {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				
		String str = br.readLine();		
		int N = Integer.parseInt(br.readLine());
		int length = str.length();
		
		int[][] memos = new int[length+1][26];
		
		memos[1][str.charAt(0) - 'a']++;
		
		for(int i = 2; i <= length; i++) {
			int idx = str.charAt(i-1) - 'a';
			
			for(int j = 0; j < 26; j++) {
				int before = memos[i-1][j];
				
				if(j == idx) {
					memos[i][j] = before+1;
				} else {
					memos[i][j] = before;					
				}
			}
		}
		
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int idx = st.nextToken().charAt(0) - 'a';
			
			int start = Integer.parseInt(st.nextToken())+1;
			
			int end = Integer.parseInt(st.nextToken())+1;
			
			sb.append(memos[end][idx] - memos[start-1][idx]).append("\n");
		}
		
		System.out.print(sb);
	}
}