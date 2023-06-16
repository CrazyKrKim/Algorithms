package bakjoon.splitConquest.bigRectangle_6549;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {	
	
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
		Stack<Integer> stack = new Stack<Integer>();
		
		long maxArea = 0;
		
		for(int i = 0; i < len; i++) {
			while((!stack.isEmpty() && histogram[stack.peek()] >= histogram[i])) {
				int height = histogram[stack.pop()];
				
				long width = stack.isEmpty() ? i : i - 1 - stack.peek();
				
				maxArea = Math.max(maxArea, height * width);
			}
			
			stack.push(i);
		}
		
		while(!stack.isEmpty()) {
			int height = histogram[stack.pop()];
			
			long width = stack.isEmpty() ? len: len - 1 - stack.peek();
			maxArea = Math.max(maxArea,  width * height);
		}
		
		return maxArea;
	}
}