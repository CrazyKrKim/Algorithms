package programmers.lv1.stringDivision_12;

import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		String s = "banana";
		
		solution(s);
	}
	
    public static int solution(String s) {
    	int sLen = s.length();
    	int answer = 1;

		char sChar = s.charAt(0);
		int same = 1;
		int diff = 0;
    	for(int i = 1; i < sLen; i++) {
    		if(same == 0) {
    			sChar = s.charAt(i);
    			same++;
				answer++;
    			continue;
    		}
    		
    		if(sChar == s.charAt(i)) {
    			same++;
    			
    			if(same == diff) {
    				same = 0;
    				diff = 0;
    			}
    		} else {
    			diff++;
    			
    			if(same == diff) {
    				same = 0;
    				diff = 0;
    			}
    		}
    	}
    	
    	return answer;
    }
}