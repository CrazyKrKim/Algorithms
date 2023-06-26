package programmers.lv1.paintOver_5;

import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		int n = 8;
		int m = 4;
		int[] section = {2, 3, 6};
		
		System.out.println(solution(n, m, section));
	}

    public static int solution(int n, int m, int[] section) {
        int answer = 0;
        int isSection = 0;
        
        for(int i = 0; i < section.length; i++) {
        	if(isSection < section[i]) {
        		isSection = section[i] + m - 1;
        		answer++;
        	}
        }
        
        return answer;
    }
}