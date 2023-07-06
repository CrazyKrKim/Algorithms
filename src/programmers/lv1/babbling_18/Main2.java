package programmers.lv1.babbling_18;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Main2 {
	public static ArrayList<String> babblingArr = new ArrayList<String>(Arrays.asList("aya", "ye", "woo", "ma"));
	
	public static void main(String[] args) throws IOException {
		String[] babbling = { "ayaye", "uuu", "yeye", "yemawoo", "ayaayaa" };
		
		solution(babbling);
	}
	
    public static int solution(String[] babbling) {
        int answer = 0;
        
        for(int i = 0; i < babbling.length; i++) {
        	if(isBabbling(babbling[i], "")) {
        		answer++;
        	}
        }
        
        System.out.println(answer);
        
        return answer;
    }
    
    public static boolean isBabbling(String babbling, String beforeStr) {    	
    	int babblingLen = babbling.length();
    	if(babblingLen == 1) {
    		return false;
    	}
    	
    	String babblingSub2 = babbling.substring(0, 2);
    	
    	if(beforeStr.equals(babblingSub2)) {
    		return false;
    	}
    	
    	if(babblingLen == 2 && babblingArr.contains(babblingSub2)) {
    		return true;
    	} else if(babblingArr.contains(babblingSub2)) {
    		return isBabbling(babbling.substring(2), babblingSub2);
    	}
    	
    	if(babblingLen > 2) {
        	String babblingSub3 = babbling.substring(0, 3);
        	
        	if(beforeStr.equals(babblingSub3)) {
        		return false;
        	}
        	
        	if(babblingLen == 3 && babblingArr.contains(babblingSub3)) {
        		return true;
        	} else if(babblingArr.contains(babblingSub3)) {
        		return isBabbling(babbling.substring(3), babblingSub3);
        	}    		
    	}

		return false;    	
    }
}