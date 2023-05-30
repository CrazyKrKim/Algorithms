package bakjoon.condState.diceThree_2480;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int rslt;
        
		// 주사위 3개가 같을 때
        if(A == B && B == C) {
        	rslt = 10000 + (A * 1000);
        }
        // 주사위 3개가 다를 때
        else if(A != B && B != C && A != C) {
        	if(A < B) {
        		if(B < C) {
        			rslt = C * 100;
        		} else {
        			rslt = B * 100;
        		}
        	} else {
        		if(A < C) {
        			rslt = C * 100;
        		} else {
        			rslt = A * 100;
        		}
        	}
        } 
        // 주사위 2개가 같을 때
        else {
        	if(A == B) {
        		rslt = 1000 + (A * 100);
        	} else if(B == C) {
        		rslt = 1000 + (B * 100);        		
        	} else {
        		rslt = 1000 + (A * 100);        		
        	}        	
        }

		System.out.print(rslt);
	}
}