package programmers.lv1.hamburgerMake_17;

import java.io.IOException;
import java.util.Stack;

public class Main2 {
	public static void main(String[] args) throws IOException {
		int[] ingredient = {2, 1, 1, 2, 3, 1, 2, 3, 1};
		
		solution(ingredient);
	}
	
    public static int solution(int[] ingredient) {
        int answer = 0;
        
        Stack<Integer> inStack = new Stack<Integer>();
        
        for(int in : ingredient) {
        	inStack.push(in);
        	
        	if(inStack.size() >= 4) {
        		if(inStack.get(inStack.size()-4) == 1
        		&& inStack.get(inStack.size()-3) == 2
				&& inStack.get(inStack.size()-2) == 3
				&& inStack.get(inStack.size()-1) == 1) {
        			answer++;
        			inStack.pop();
        			inStack.pop();
        			inStack.pop();
        			inStack.pop();
        		}
        	}
        }
        
        return answer;
    }
}