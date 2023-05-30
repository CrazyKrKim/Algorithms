package bakjoon.greedyAlgorithm.lostBracket_1541;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		String beforeStr = "";
		String beforeCal = "";
		int sum = 0;
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) >= '0' && str.charAt(i) <= '9') {
				beforeStr += str.substring(i, i+1);
			} else {
				if(beforeCal.equals("")) {
					sum += Integer.parseInt(beforeStr);
				} else if(beforeCal.equals("-")) {
					sum -= Integer.parseInt(beforeStr);
				}
				
				beforeStr = "";
				
				if(str.charAt(i) == '-') {
					beforeCal = "-";
				}
			}
			
			if(str.length() - 1 == i) {
				if(beforeCal.equals("-")) {
					sum -= Integer.parseInt(beforeStr);						
				} else {				
					sum += Integer.parseInt(beforeStr);					
				}				
			}
		}
		
		System.out.print(sum);
	}
}