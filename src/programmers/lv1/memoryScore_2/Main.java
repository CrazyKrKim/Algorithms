package programmers.lv1.memoryScore_2;

import java.io.IOException;
import java.util.HashMap;

public class Main {
	public static void main(String[] args) throws IOException {
		String[] name = { "may", "kein", "kain", "radi" };
		int[] yearning = { 5, 10, 1, 3 };
		String[][] photo = { {"may", "kein", "kain", "radi"}, { "may", "kein", "brin", "deny" }, { "kon", "kain", "may", "coni"} };

		solution(name, yearning, photo);
	}

	public static int[] solution(String[] name, int[] yearning, String[][] photo) {
	        int[] answer = new int[photo.length];
	        
	        HashMap<String, Integer> nameScore = new HashMap<String, Integer>();
	        
	        for(int i = 0; i < name.length; i++) {
	        	nameScore.put(name[i], yearning[i]);
	        }
	        
	        for(int i = 0; i < photo.length; i++) {
	        	int sum = 0;
	        	
	        	for(int j = 0; j < photo[i].length; j++) {
	        		if(nameScore.containsKey(photo[i][j])) {
	        			sum += nameScore.get(photo[i][j]);
	        		}
	        	}
	        	
	        	answer[i] = sum;
	        }
	        
	        return answer;
	    }
}