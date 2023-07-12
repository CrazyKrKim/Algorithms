package programmers.lv1.smallestRectangle_24;

import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		int[][] sizes = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
		
		solution(sizes);
	}
	
    public static int solution(int[][] sizes) {
    	int min = Integer.MIN_VALUE;
    	int max = Integer.MIN_VALUE;
    	
    	for(int i = 0; i < sizes.length; i++) {
    		int col = sizes[i][0];
    		int row = sizes[i][1];
    		
    		if(row >= col) {
    			if(min < col) {
    				min = col;
    			}
    		} else {
    			if(min < row) {
    				min = row;
    			}    			
    		}
    		
    		if(max < row) {
    			max = row;
    		}
    		
    		if(max < col) {
    			max = col;
    		}
    	}
    	
    	return min * max;
    }
}