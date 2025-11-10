package bakjoon.level16_StackQueueDeque.stack2_28278;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.io.IOException;

public class Main {	
	public static void main(String[] args) throws IOException {
		// 1. 값을 입력받는다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		int N = Integer.parseInt(br.readLine());
		
		// 2. 관련 변수 선언
		StringBuilder resultSb = new StringBuilder();		
		Stack<Integer> stack = new Stack<>();
		
		// 3. 입력받은 값을 for문으로 실행
		for(int i = 0; i < N; i++) {
			String inputStr = br.readLine();
			String command = inputStr.substring(0, 1);
			
			// 3-1. 명령어 1~5 수행
			if(command.equals("1")) {
				stack.add( Integer.parseInt(inputStr.substring(2)) );
			}
			
			if(command.equals("2")) {
				if(stack.size() > 0) {
					resultSb.append(stack.pop());
					resultSb.append("\n");
				} else {
					resultSb.append("-1\n");
				}
			}
			
			if(command.equals("3")) {
				resultSb.append(stack.size());
				resultSb.append("\n");
			}
			
			if(command.equals("4")) {
				if(stack.size() > 0) {
					resultSb.append("0\n");
				} else {
					resultSb.append("1\n");
				}
			}			
			
			if(command.equals("5")) {
				if(stack.size() > 0) {
					resultSb.append(stack.peek());
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