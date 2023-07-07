package programmers.lv1.threesome_20;

import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		int[] number = { -2, 3, 0, 2, -5 };
		
		solution(number);
	}
	
    public static int solution(int[] number) {
        int answer = 0;
        int numberLen = number.length;
        
        for(int i = 0; i < numberLen - 2; i++) {
        	for(int j = i + 1; j < numberLen - 1; j++) {
        		for(int k = j + 1; k < numberLen; k++) {
                	if(number[i] + number[j] + number[k] == 0) {
                		answer++;
                	}                		
                }
            }	
        }
        
        return answer;
    }
}