package bakjoon.accumulatedSum.restSum_10986;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main2 {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		long[] arrN = new long[N+1];
		long[] cnt = new long[M];
		long result = 0;
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 1; i < N + 1; i++) {
			arrN[i] = (arrN[i-1] + Integer.parseInt(st.nextToken())) % M;
			
			if(arrN[i] == 0) {
				result++;
			}
			
			cnt[(int) arrN[i]]++;
		}
		
        for(int i=0; i<M; i++) {
            if(cnt[i] > 1) {
                result += (cnt[i] * (cnt[i] - 1) / 2);
            }
        }
        
        System.out.println(result);
	}
}