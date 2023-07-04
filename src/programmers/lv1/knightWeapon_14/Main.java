package programmers.lv1.knightWeapon_14;

import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		int number = 5;
		int limit = 3;
		int power = 2;
		
		solution(number, limit, power);
	}
	
    public static int solution(int number, int limit, int power) {
        int answer = 0;
        
        for(int i = 1; i <= number; i++) {
        	int divCnt = divCntCalcul(i);
        	
        	if(divCnt > limit) {
        		answer += power;
        	} else {
        		answer += divCnt;
        	}
        }
        
        return answer;
    }
    
    public static int divCntCalcul(int N) {
    	int cnt = 0;
    	
    	for(int i = 1; i * i <= N; i++) {
    		if(i * i == N) {
    			cnt++;
    		} else if(N % i == 0) {
    			cnt += 2;
    		}
    	}
    	
    	return cnt;
    }
}