package programmers.lv1.numberPartner_21;

import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		String X = "12321";
		String Y = "42531";
		
		solution(X, Y);
	}
	
    public static String solution(String X, String Y) {
        String answer = "";
        
        int[] XArr = new int[10];
        int[] YArr = new int[10];
        
        for(int i = 0; i < X.length(); i++) {
        	XArr[X.charAt(i) - '0']++;
        }
        
        for(int i = 0; i < Y.length(); i++) {
        	YArr[Y.charAt(i) - '0']++;
        }
        
        for(int i = 9; i >= 0; i--) {
        	int cnt = 0;
        	
        	if(XArr[i] > 0 && YArr[i] > 0) {
        		cnt = Math.min(XArr[i], YArr[i]);
        	}
        	
        	for(int j = 0; j < cnt; j++) {
        		answer += i;
        	}
        }
        
        if(answer.equals("")) {
        	answer = "-1";
        } else if(answer.charAt(0) == '0') {
        	answer = "0";
        }
        
        return answer;
    }
}