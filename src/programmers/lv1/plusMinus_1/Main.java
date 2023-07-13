package programmers.lv1.plusMinus_1;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException, ParseException {
		int[] absolutes = { 4,7,12 };
		boolean[] signs = { true, false, true };
		
		solution(absolutes, signs);
	}
	
    public static int solution(int[] absolutes, boolean[] signs) {
    	int answer = 0;
    	
    	for(int i = 0; i < absolutes.length; i++) {
    		if(signs[i]) {
    			answer += absolutes[i];
    		} else {
    			answer -= absolutes[i];
    		}
    	}
    	
    	return answer;
    }
}