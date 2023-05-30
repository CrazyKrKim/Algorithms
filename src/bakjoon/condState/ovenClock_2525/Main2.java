package bakjoon.condState.ovenClock_2525;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int A = Integer.parseInt(st.nextToken());	// 시
		int B = Integer.parseInt(st.nextToken());	// 분
		
		int C = Integer.parseInt(br.readLine());	// 요리시간
		
		int min = 60 * A + B + C;					// 총 시간
 
		// 총 시간에서 60으로 나누고 24로 나눈 나머지를 구한 값이 시간이 된다.
		// 총 시간에서 60을 나눈 나머지 값은 분이 된다.
        int hour = (min / 60) % 24;
        int minute = min % 60;
		
        StringBuilder sb = new StringBuilder();
		sb.append(hour).append(" ").append(minute);

		System.out.print(sb);
	}
}