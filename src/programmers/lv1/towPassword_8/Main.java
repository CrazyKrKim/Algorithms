package programmers.lv1.towPassword_8;

import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		String s = "aukks";
		String skip = "wbqd";
		int index = 5;
		
		solution(s, skip, index);
	}
	
    public static String solution(String s, String skip, int index) {
        String answer = "";
        
        for(int i = 0; i < s.length(); i++) {
        	char charS = s.charAt(i);
        	
        	for(int j = 0; j < index; j++) {
        		charS += 1;
        		
        		if(charS > 'z') {
        			charS -= 26;
        		}
        		
        		if(skip.contains(String.valueOf(charS))) {
        			j--;
        		}
        	}
        	
        	answer += charS;
        }
        
        System.out.println(answer);
        return answer;
    }
}