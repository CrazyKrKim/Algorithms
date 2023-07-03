package programmers.lv1.perInfoCollectionPeriod_9;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main2 {
	public static void main(String[] args) throws IOException {
		String today = "2020.01.01";
		String[] terms = {"Z 3", "D 5"};
		String[] privacies = {"2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"};
		
		solution(today, terms, privacies);
	}
	
    public static int[] solution(String today, String[] terms, String[] privacies) {  
    	int[] answer = {};
    	
    	Map<String, String> termsMap = new HashMap<>();
    	
    	for(String term : terms) {
    		String[] termSplit = term.split(" ");
    		termsMap.put(termSplit[0], termSplit[1]);
    	}
    	
    	Integer number = 1;
    	List<Integer> result = new ArrayList<>();
    	
    	Integer todayTotalDate = getTotalDate(today, 0);
    	
    	for(String p : privacies) {
    		String[] privateSplit = p.split(" ");
    		
    		String privateDate = privateSplit[0];
    		String privateTerm = privateSplit[1];
    		
    		Integer termsMonth = Integer.valueOf(termsMap.get(privateTerm));
    		
    		Integer privateTotalDate = getTotalDate(privateDate, termsMonth) - 1;
    		
    		if(privateTotalDate < todayTotalDate) {
    			result.add(number);
    		}
    		
    		number++;
    	}
    	
    	answer = result.stream().mapToInt(Integer::intValue).toArray();        
        return answer;
    }
    
    private static Integer getTotalDate(String strDate, Integer termsMonth) {
    	String[] dateSplit = strDate.split("\\.");
    	Integer year = Integer.valueOf(dateSplit[0]);
    	Integer month = Integer.valueOf(dateSplit[1]) + termsMonth;
    	Integer day = Integer.valueOf(dateSplit[2]);
    	
    	return (year * 12 * 28) + (month * 28) + day;
    }
}