package bakjoon.priorityQueue.absHeap_11286;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.io.IOException;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> {
			int abs1 = Math.abs(o1);
			int abs2 = Math.abs(o2);
			
			if(abs1 == abs2) {
				return o1 > o2 ? 1 : -1;
			}
			
			return abs1 - abs2;
		});
		
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