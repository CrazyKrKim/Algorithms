package programmers.lv1.fruitSeller_15;

import java.io.IOException;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {
		int k = 3;
		int m = 4;
		int[] score = {1, 2, 3, 1, 2, 3, 1};
		
		solution(k, m, score);
	}
	
    public static int solution(int k, int m, int[] score) {
        int answer = 0;
        int scoreLen = score.length;
        
        PriorityQueue<Integer> scoreQueue = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i = 0; i < scoreLen; i++) {
        	scoreQueue.add(score[i]);
        }
        
        for(int i = 1; i <= scoreLen; i++) {
        	if(i % m == 0) {
        		answer = answer + (scoreQueue.poll() * m);
        	} else {
        			scoreQueue.poll();
        	}
        }
        
        return answer;
    }
}