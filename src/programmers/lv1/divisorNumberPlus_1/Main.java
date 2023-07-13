package programmers.lv1.divisorNumberPlus_1;

import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		int left = 13;
		int right = 17;
		
		solution(left, right);
	}
	
    public static int solution(int left, int right) {
        int answer = 0;
        
        for(int i = left; i <= right; i++) {
        	int number = isOddDivisor(i);
        	
        	if(number % 2 == 1) {
        		answer -= i;
        	} else {
        		answer += i;
        	}
        }
        
        return answer;
    }
    
    public static int isOddDivisor(int n) {
    	int cnt = 0;
    	
    	for(int i = 1; i <= n; i++) {
    		if(i * i == n) cnt++;
    		else if(n % i == 0) cnt+=2;
    	}
    	
    	return cnt;
    }
}