package programmers.lv1.nearestSameString_11;

import java.io.IOException;
import java.util.HashMap;

public class Main {
	public static void main(String[] args) throws IOException {
		String s = "banana";
		
		solution(s);
	}
	
    public static int[] solution(String s) {
    	int sLen = s.length();
    	int[] answer = new int[sLen];
    	
    	HashMap<Character, Integer> sHash = new HashMap<Character, Integer>();
    	
    	for(int i = 0; i < sLen; i++) {
    		char sChar = s.charAt(i);
    		
    		if(!sHash.containsKey(sChar)) {
    			answer[i] = -1;
    		} else {
    			answer[i] = i - sHash.get(sChar);
    		}
    		
			sHash.put(sChar, i);
    	}
    	
    	return answer;
    }
}