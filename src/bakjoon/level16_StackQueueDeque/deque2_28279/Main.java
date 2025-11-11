package bakjoon.level16_StackQueueDeque.deque2_28279;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.io.IOException;

public class Main {	
	public static void main(String[] args) throws IOException {
		// 1. 값을 입력받는다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		int N = Integer.parseInt(br.readLine());
		
		// 2. 관련 변수 선언
		StringBuilder resultSb = new StringBuilder();		
		Deque<Integer> deque = new ArrayDeque<Integer>();
		
		// 3. 입력받은 값을 for문으로 실행
		for(int i = 0; i < N; i++) {
			String inputStr = br.readLine();
			String command = inputStr.substring(0, 1);
			
			// 3-1. 명령어 1~8 수행
			if(command.equals("1")) {
				deque.addFirst( Integer.parseInt(inputStr.substring(2)) );
			}

			if(command.equals("2")) {
				deque.addLast( Integer.parseInt(inputStr.substring(2)) );
			}
			
			if(command.equals("3")) {
				if(deque.size() > 0) {
					resultSb.append(deque.removeFirst());
					resultSb.append("\n");
				} else {
					resultSb.append("-1\n");
				}
			}
			
			if(command.equals("4")) {
				if(deque.size() > 0) {
					resultSb.append(deque.removeLast());
					resultSb.append("\n");
				} else {
					resultSb.append("-1\n");
				}
			}
			
			if(command.equals("5")) {
				resultSb.append(deque.size());
				resultSb.append("\n");
			}
			
			if(command.equals("6")) {
				if(deque.size() > 0) {
					resultSb.append("0\n");
				} else {
					resultSb.append("1\n");
				}
			}			
			
			if(command.equals("7")) {
				if(deque.size() > 0) {
					resultSb.append(deque.peekFirst());
					resultSb.append("\n");
				} else {
					resultSb.append("-1\n");
				}
			}
			
			if(command.equals("8")) {
				if(deque.size() > 0) {
					resultSb.append(deque.peekLast());
					resultSb.append("\n");
				} else {
					resultSb.append("-1\n");
				}
			}
		}
		
		// 4. 결과 출력
		System.out.print(resultSb.toString());
	}
}