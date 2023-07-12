package programmers.lv1.MBTI_22;

import java.io.IOException;
import java.util.HashMap;

public class Main {
	public static void main(String[] args) throws IOException {
		String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
		int[] choices = {5, 3, 2, 7, 5};
		
		solution(survey, choices);
	}
	
    public static String solution(String[] survey, int[] choices) {        
        HashMap<String, Integer> MBTIHashMap = new HashMap<String, Integer>() {{
        	put("R", 0);
        	put("T", 0);
        	put("C", 0);
        	put("F", 0);
        	put("J", 0);
        	put("M", 0);
        	put("A", 0);
        	put("N", 0);
        }};
        
        for(int i = 0; i < survey.length; i++) {
        	String surveyF = survey[i].substring(0, 1);
        	String surveyL = survey[i].substring(1, 2);
        	
        	switch(choices[i]) {
        	case 1:
        		MBTIHashMap.put(surveyF, MBTIHashMap.get(surveyF) + 3);
        		break;
        	case 2:
        		MBTIHashMap.put(surveyF, MBTIHashMap.get(surveyF) + 2);
        		break;
        	case 3:
        		MBTIHashMap.put(surveyF, MBTIHashMap.get(surveyF) + 1);
        		break;
        	case 5:
        		MBTIHashMap.put(surveyL, MBTIHashMap.get(surveyL) + 1);
        		break;
        	case 6:
        		MBTIHashMap.put(surveyL, MBTIHashMap.get(surveyL) + 2);
        		break;
        	case 7:
        		MBTIHashMap.put(surveyL, MBTIHashMap.get(surveyL) + 3);
        		break;
        	}
        }
        
        StringBuilder sb = new StringBuilder();
        
        if(MBTIHashMap.get("R") >= MBTIHashMap.get("T")) {
        	sb.append("R");
        } else {
        	sb.append("T");
        }
        
        if(MBTIHashMap.get("C") >= MBTIHashMap.get("F")) {
        	sb.append("C");
        } else {
        	sb.append("F");
        }
        
        if(MBTIHashMap.get("J") >= MBTIHashMap.get("M")) {
        	sb.append("J");
        } else {
        	sb.append("M");
        }
        
        if(MBTIHashMap.get("A") >= MBTIHashMap.get("N")) {
        	sb.append("A");
        } else {
        	sb.append("N");
        }
        
        return sb.toString();
    }
}