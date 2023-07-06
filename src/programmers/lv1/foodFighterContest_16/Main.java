package programmers.lv1.foodFighterContest_16;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class Main {
	public static void main(String[] args) throws IOException {
		int[] food = {1, 3, 4, 6};
		
		solution(food);
	}
	
    public static String solution(int[] food) {
        String answer = "";
        
        Deque<Integer> foodDeque = new ArrayDeque<Integer>();
        
        foodDeque.add(0);
        
        for(int i = food.length - 1; i >= 0; i--) {
        	int div = food[i] / 2;
        	
        	for(int j = 0; j < div; j++) {
        		foodDeque.addFirst(i);
        		foodDeque.addLast(i);
        	}
        }
        
        Iterator<Integer> iter = foodDeque.iterator();
        while(iter.hasNext()) {
        	answer += iter.next().toString();
        }
        
        return answer;
    }
}