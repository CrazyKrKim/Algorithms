package programmers.lv1.lotto_1;

import java.io.IOException;
import java.util.HashSet;

public class Main {
	public static void main(String[] args) throws IOException {
		int[] lottos = {44, 1, 0, 0, 31, 25};
		int[] win_nums = {31, 10, 45, 1, 6, 19};
		
		solution(lottos, win_nums);
	}
	
    public static int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        
        int winCnt = 7;
        int loseCnt = 7;
        
        HashSet<Integer> winNumsHash = new HashSet<Integer>();
        
        for(int i = 0; i < 6; i++) {
        	winNumsHash.add(win_nums[i]);
        }

        for(int i = 0; i < 6; i++) {
        	if(lottos[i] == 0) {
        		winCnt--;
        	} else {
        		if(winNumsHash.contains(lottos[i])) {
        			winCnt--;
        			loseCnt--;
        		}
        	}
        }
        
        if(loseCnt == 7) {
        	loseCnt = 6;
        }
        
        if(winCnt == 7) {
        	winCnt = 6;
        } else if(winCnt < 1) {
        	winCnt = 1;
        }
        
        answer[0] = winCnt;
        answer[1] = loseCnt;
        
    	return answer;
    }
}