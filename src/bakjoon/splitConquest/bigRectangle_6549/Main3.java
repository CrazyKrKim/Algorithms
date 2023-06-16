package bakjoon.splitConquest.bigRectangle_6549;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main3 {	
	
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
			
			sb.append(getArea(0, N - 1)).append("\n");
			histogram = null;
		}
		
		System.out.println(sb);
	}
	
	static long getArea(int lo, int hi) {
		if(lo == hi) {
			return histogram[lo];
		}
		
		int mid = (lo + hi) / 2;
		
		long leftArea = getArea(lo, mid);
		long rightArea = getArea(mid + 1, hi);
		
		long max = Math.max(leftArea, rightArea);
		
		max = Math.max(max,  getMidArea(lo, hi, mid));
		
		return max;
	}
	
	static long getMidArea(int lo, int hi, int mid) {
		int toLeft = mid;
		int toRight = mid;
		
		long height = histogram[mid];
		
		long maxArea = height;
		
		while(lo < toLeft && toRight < hi) {
			if(histogram[toLeft - 1] < histogram[toRight + 1]) {
				toRight++;
				height = Math.min(height, histogram[toRight]);
			} else {
				toLeft--;
				height = Math.min(height, histogram[toLeft]);
			}
			
			maxArea = Math.max(maxArea, height * (toRight - toLeft + 1));
		}
		
		while(toRight < hi) {
			toRight++;
			height = Math.min(height, histogram[toRight]);
			maxArea = Math.max(maxArea, height * (toRight - toLeft + 1));
		}
		
		while(lo < toLeft) {
			toLeft--;
			height = Math.min(height,  histogram[toLeft]);
			maxArea = Math.max(maxArea, height * (toRight - toLeft + 1));
		}
		
		return maxArea;
	}
}