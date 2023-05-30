package bakjoon.condState.ovenClock_2525;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		int h = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int time = Integer.parseInt(br.readLine());
		
		m += time;
		
		if(m >= 60) {
			h += (m)/60;
			m = (m)%60;
		}
		
		if(h >= 24) {
			h -= 24;
		}
		
		sb.append(h).append(' ').append(m);
		System.out.println(sb);
	}

}