package programmers.lv1.hallOfFame_13;

import java.io.IOException;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {
		int k = 3;
		int[] score = {10, 100, 20, 150, 1, 100, 200};
		
		solution(k, score);
	}
	
    public static int[] solution(int k, int[] score) {
    	int scoreLen = score.length;
        int[] answer = new int[scoreLen];
        
        PriorityQueue<Integer> fameQueue = new PriorityQueue<>();
        
        for(int i = 0; i < scoreLen; i++) {
        	if(fameQueue.size() < k) {
        		fameQueue.add(score[i]);
        		answer[i] = fameQueue.peek();
        	} else {
        		if(fameQueue.peek() < score[i]) {
            		fameQueue.add(score[i]);
            		fameQueue.remove();
            		answer[i] = fameQueue.peek();
        		} else {
            		answer[i] = fameQueue.peek();        			
        		}
        	}
            
            System.out.println(answer[i]);
        }
        
        return answer;
    }
}