package bakjoon.condState.ovenClock_2525;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());		// 시
		int B = Integer.parseInt(st.nextToken());		// 분
		
		int C = Integer.parseInt(br.readLine());		// 요리시간
		
		B += C;				// 분 + 요리시간
		
		// 60분을 넘으면 시간을 더하고, 60을 나눈 나머지값을 분에 넣는다.
		if(B >= 60) {
			A += B / 60;
			B = B % 60;
		}
		
		// 시간이 24를 넘으면 24를 뺀다.
		if(A >= 24) {
			A -= 24;
		}

		StringBuilder sb = new StringBuilder();
		sb.append(A).append(' ').append(B);
		System.out.println(sb);
	}
}