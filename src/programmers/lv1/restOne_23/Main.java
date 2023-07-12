package programmers.lv1.restOne_23;

import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		int n = 12;
		
		solution(n);
	}
	
    public static int solution(int n) {
    	int answer = 0;
    	while(true) {
    		answer++;
    		
    		if(n % answer == 1) {
    			break;
    		}
    	}
    	
    	return answer;
    }
}