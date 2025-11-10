package bakjoon.level16_StackQueueDeque.dokidoki_12789;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
    	// 1. 최초 N 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 2. 변수 설정
        int index = 1;
        String result = "Nice";	
        String[] sArr = br.readLine().split(" ");
        Stack<Integer> stack = new Stack<>();

        // 3. 입력받는 값을 Stack에 넣을지, index를 넣을 지 분기처리
        for(int i = 0; i < N; i++){
            int currentNum = Integer.parseInt(sArr[i]);
            if(index != currentNum){
                if(!stack.isEmpty() && index == stack.peek()){
                    index++;
                    i--;
                    stack.pop();
                } else {
                    stack.push(currentNum);
                }
            } else {
                index++;
            }
        }

        // 4. 최종 Stack에서 Sad / Nice여부 체크
        while(!stack.isEmpty()){
            int pop = stack.pop();
            if(pop == index){
                index++;
            } else {
                result = "Sad";
                break;
            }
        }
        System.out.println(result);
    }
}