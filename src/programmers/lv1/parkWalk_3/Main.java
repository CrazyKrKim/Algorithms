package programmers.lv1.parkWalk_3;

import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		String[] park = {"0S0", "000", "0X0", "000"};
		String[] routes = {"E 2", "S 3", "W 1"};
		
		solution(park, routes);
		
		System.out.print(startY + " " + startX);
	}
	
	static int startX = 0;
	static int startY = 0;

	public static int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        
        String[][] parkTwoArr = new String[park.length][park[0].length()];
        
        for(int i = 0; i < park.length; i++) {
        	for(int j = 0; j < park[0].length(); j++) {
        		parkTwoArr[i][j] = park[i].substring(j, j+1);
        		
        		if(park[i].substring(j, j+1).equals("S")) {
        			startY = i;
        			startX = j;
        		}
        	}
        }
        
        for(int i = 0; i < routes.length; i++) {
        	StringTokenizer st = new StringTokenizer(routes[i], " ");
        	String direction = st.nextToken();
        	int distance = Integer.parseInt(st.nextToken());
        	
        	if(!isObstacle(parkTwoArr, direction, distance)) {
        		continue;
        	}
        	
        	switch(direction) {
        		case "N":
        			startY = startY - distance;
        			break;
        		case "S":
        			startY = startY + distance;
        			break;
        		case "W":
        			startX = startX - distance;
        			break;
        		case "E":
        			startX = startX + distance;
        			break;
        		default:
        			break;
        	}
        }
        
        answer[0] = startY;
        answer[1] = startX;        
        
        return answer;
    }
	
	public static boolean isObstacle(String[][] parkTwoArr, String direction, int distance) {
		boolean isObstacle = true;
		
		if(direction.equals("N")) {
			if(startY - distance < 0) {
				return false;
			}
			
			for(int i = startY; i >= startY - distance; i--) {
				if(parkTwoArr[i][startX].equals("X")) {
					return false;
				}
			}
		}
		
		if(direction.equals("S")) {
			if(startY + distance >= parkTwoArr.length) {
				return false;
			}
			
			for(int i = startY; i <= startY + distance; i++) {
				if(parkTwoArr[i][startX].equals("X")) {
					return false;
				}
			}
		}	
		
		if(direction.equals("W")) {
			if(startX - distance < 0) {
				return false;
			}
			
			for(int i = startX; i >= startX - distance; i--) {
				if(parkTwoArr[startY][i].equals("X")) {
					return false;
				}
			}
		}	
		
		if(direction.equals("E")) {
			if(startX + distance >= parkTwoArr[0].length) {
				return false;
			}
			
			for(int i = startX; i <= startX + distance; i++) {
				if(parkTwoArr[startY][i].equals("X")) {
					return false;
				}
			}
		}	
		
		return isObstacle;
	}
}