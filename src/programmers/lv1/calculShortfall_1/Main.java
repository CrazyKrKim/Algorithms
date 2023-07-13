package programmers.lv1.calculShortfall_1;

import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		int price = 3;
		int money = 20;
		int count = 4;
		
		solution(price, money, count);
	}
	
    public static long solution(int price, int money, int count) {      
        long sum = 0;
        
        for(int i = 1; i <= count; i++) {
        	sum += i * price;
        }
        
        if(sum <= money) {
        	sum = 0;
        } else {
        	sum = sum - money;
        }
        
        return sum;
    }
}