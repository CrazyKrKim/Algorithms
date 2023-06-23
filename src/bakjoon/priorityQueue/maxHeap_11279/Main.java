package bakjoon.priorityQueue.maxHeap_11279;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.io.IOException;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			int x = Integer.parseInt(br.readLine());
			
			if(x == 0) {
				if(priorityQueue.isEmpty()) {
					sb.append("0\n");
				} else {
					sb.append(priorityQueue.poll()).append("\n");
				}
			} else {
				priorityQueue.offer(x);
			}
		}
		
		System.out.println(sb);
	}
}