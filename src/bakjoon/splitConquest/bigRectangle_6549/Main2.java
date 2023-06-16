package bakjoon.splitConquest.bigRectangle_6549;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main2 {	
	
	public static int[] histogram;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		
		StringBuilder sb = new StringBuilder();
		while(true) {
			String str = br.readLine();
			
			if(str.equals("0")) {
				break;
			}
			
			st = new StringTokenizer(str, " ");
			
			int N = Integer.parseInt(st.nextToken());
			
			histogram = new int[N];
			
			for(int i = 0; i < N; i++) {
				histogram[i] = Integer.parseInt(st.nextToken());
			}
			
			sb.append(getArea(N)).append("\n");
			histogram = null;
		}
		
		System.out.println(sb);
	}
	
	static long getArea(int len) {
		int[] stack = new int[len];
		int sSize = 0;
		int top = -1;
		
		long maxArea = 0;
		
		for(int i = 0; i < len; i++) {
			while(sSize > 0 && histogram[stack[top]] >= histogram[i]) {
				int height = histogram[stack[top--]];
				sSize--;
				
				long width = sSize == 0 ? i : i - 1 - stack[top];
				
				maxArea = Math.max(maxArea, width * height);
			}
			
			stack[++top] = i;
			sSize++;
		}
		
		while(sSize > 0) {
			int height = histogram[stack[top--]];
			sSize--;
			
			long width = sSize == 0 ? len: len - 1 - stack[top];
			maxArea = Math.max(maxArea, width * height);
		}
		
		return maxArea;
	}
}