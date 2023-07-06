package programmers.lv1.hamburgerMake_17;

import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		int[] ingredient = {2, 1, 1, 2, 3, 1, 2, 3, 1};
		
		solution(ingredient);
	}
	
    public static int solution(int[] ingredient) {
        int answer = 0;
        
        String hamburgerStr = "";
        
        for(int i = 0; i < ingredient.length; i++) {
        	hamburgerStr += ingredient[i];
        }
        
        while(true) {
        	int indexOf = hamburgerStr.indexOf("1231");
        	
        	if(indexOf == -1) {
        		break;
        	} else {
        		answer++;
        		hamburgerStr = hamburgerStr.substring(0, indexOf) + hamburgerStr.substring(indexOf+4);
        	}
        }
        
        return answer;
    }
}