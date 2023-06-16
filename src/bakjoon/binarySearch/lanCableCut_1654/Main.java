package bakjoon.binarySearch.lanCableCut_1654;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {	
	static int result = 0;
	static int[] arrN;
	static int N;
	static int M;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arrN = new int[N];
		
		int sum = 0;
		for(int i = 0; i < N; i++) {
			int cable = Integer.parseInt(br.readLine());
			sum += cable;
			arrN[i] = cable;
		}
		
		result = sum / M;
		while(true) {
			if(findCable(result)) {
				break;
			}
			
			result--;
		}
		
		System.out.println(result);
	}
	
	static boolean findCable(int result) {
		int divM = 0;
		for(int i = 0; i < N; i++) {
			divM += arrN[i] / result;
		}
		
		if(divM == M) {
			return true;
		} else {
			return false;
		}
	}
}