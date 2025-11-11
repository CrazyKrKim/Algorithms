package bakjoon.level16_StackQueueDeque.burstBalloon_2346;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
    	// 1. 최초 N 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        // 2. Deque 세팅
        Deque<int[]> deque = new ArrayDeque<>();
        String[] sArr = br.readLine().split(" ");
       
        for(int i = 1; i < N; i++) {
        	int[] input = new int[2];
        	input[0] = i+1;
        	input[1] = Integer.parseInt(sArr[i]);
        	deque.addLast(input);
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append("1 ");
       
        // 3. 번호만큼 풍선을 Deque를 사용하여 돌려준다
        int move = Integer.parseInt(sArr[0]);
        for(int i = 0; i < N-1; i++) {
        	while(move != 0) {
        		if(move == 1) {
        			move = deque.peekFirst()[1];
        			sb.append(deque.pollFirst()[0]).append(" ");
        			break;
        		}
        		
        		if(move == -1) {
        			move = deque.peekLast()[1];
        			sb.append(deque.pollLast()[0]).append(" ");        	
        			break;
        		}
        		
        		if(move > 0) {
        			move--;
        			deque.addLast( deque.pollFirst() );
        		} else {
        			move++;
        			deque.addFirst( deque.pollLast() );
        		}
        	}
        }
        
        System.out.println(sb.toString());
    }
}