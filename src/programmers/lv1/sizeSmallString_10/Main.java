package programmers.lv1.sizeSmallString_10;

import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		String t = "3141592";
		String p = "271";
		
		solution(t, p);
	}
	
    public static int solution(String t, String p) {      
    	int answer = 0;
    	Long pInt = Long.parseLong(p);
    	int pLength = p.length();
    	
    	for(int i = 0; i < t.length() - pLength + 1; i++) {
    		String tCompStr = t.substring(i, pLength + i);
    		Long tComp = Long.parseLong(tCompStr);
    		
    		if(tComp <= pInt) {
    			answer++;
    		}
    	}
    	
    	System.out.println(answer);
    	return answer;
    }
}