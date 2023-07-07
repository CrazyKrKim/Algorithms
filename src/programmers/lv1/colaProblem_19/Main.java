package programmers.lv1.colaProblem_19;

import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		int a = 3;
		int b = 1;
		int n = 20;
		
		solution(a, b, n);
	}
	
    public static int solution(int a, int b, int n) {
        int answer = 0;

        int cnt = 0;
        
        while(true) {               	
        	if(n < a) {
        		break;
        	} 	
        	
        	cnt = n / a;        	
        	answer += cnt * b;

        	n = (n % a) + (cnt * b);
        }
        
        return answer;
    }
}