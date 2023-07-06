package programmers.lv1.babbling_18;

import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		String[] babbling = { "ayaye", "uuu", "yeye", "yemawoo", "ayaayaa" };
		
		solution(babbling);
	}
	
    public static int solution(String[] babbling) {
        int answer = 0;
        
        for(int i = 0; i < babbling.length; i++) {
        	if(isBabbling(babbling[i])) {
        		answer++;
        	}
        }
        
        System.out.println(answer);
        
        return answer;
    }
    
    public static boolean isBabbling(String babbling) {    
    	if(babbling.contains("ayaaya") || babbling.contains("yeye") || babbling.contains("woowoo") || babbling.contains("mama")) {
    		return false;
    	}
    	
    	babbling = babbling.replace("aya", " ");
    	babbling = babbling.replace("ye", " ");
    	babbling = babbling.replace("woo", " ");
    	babbling = babbling.replace("ma", " ");
    	babbling = babbling.replace(" ", "");
    	
    	if(babbling.length() == 0) {
    		return true;
    	} else {
    		return false;
    	}
    }
}