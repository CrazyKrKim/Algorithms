package programmers.lv1.perInfoCollectionPeriod_9;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException, ParseException {
		String today = "2020.01.01";
		String[] terms = {"Z 3", "D 5"};
		String[] privacies = {"2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"};
		
		solution(today, terms, privacies);
	}
	
    public static int[] solution(String today, String[] terms, String[] privacies) throws ParseException {        
        HashMap<String, Integer> termsHash = new HashMap<String, Integer>();
        
        for(int i = 0; i < terms.length; i++) {
        	termsHash.put(terms[i].substring(0, 1), Integer.parseInt(terms[i].substring(2)));
        }
        
        int count = 0;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy.mm.dd");
        SimpleDateFormat formatter2 = new SimpleDateFormat("yyyymmdd");
        Date currDate = formatter.parse(today);
        
        List<Integer> answerList = new ArrayList<Integer>();
        for(int i = 0; i < privacies.length; i++) {
        	String termStr = privacies[i].substring(11);
        	
        	int term = termsHash.get(termStr);
        	
        	int year = Integer.parseInt(privacies[i].substring(0, 4));
        	int month = Integer.parseInt(privacies[i].substring(5, 7));
        	int day = Integer.parseInt(privacies[i].substring(8, 10));
        	
        	if(day - 1 == 0) {
        		day = 28;
        		month--;
        	} else {
        		day--;
        	}

        	year += (month + term) / 12;
        	month = (month + term) % 12;

        	String dayStr;
        	String monthStr;
        	String yearStr;
        	
        	if(day < 10) {
        		dayStr = "0" + day;
        	} else {
        		dayStr = String.valueOf(day);
        	}
        	
        	if(month < 10) {
        		monthStr = "0" + month;
        	} else {
        		monthStr = String.valueOf(month);
        	}
        	
        	if(year < 10) {
        		yearStr = "000" + year;
        	} else if(year < 100) {
        		yearStr = "00" + year;        		
        	} else if(year < 1000) {
        		yearStr = "0" + year;        		
        	} else {
                yearStr = String.valueOf(year);
            }

            Date diffDate = formatter2.parse(yearStr+monthStr+dayStr);
            
            int result = currDate.compareTo(diffDate);
            
            if(result > 0) {
            	answerList.add(i+1);         
                count++;
            }
        }

        int[] answer = new int[count];
        int answerCnt = 0;
        
        for(Integer e : answerList) {
        	answer[answerCnt] = e;
        	answerCnt++;
        }
        
        return answer;
    }
}