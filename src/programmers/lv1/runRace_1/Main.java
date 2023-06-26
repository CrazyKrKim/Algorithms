package programmers.lv1.runRace_1;

import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		String[] players = {"mumu", "soe", "poe", "kai", "mine"};
		String[] callings = {"kai", "kai", "mine", "mine"};
		
		
		solution(players, callings);
	}
	
    public static String[] solution(String[] players, String[] callings) {
        for(int i = 0; i < callings.length; i++) {
        	for(int j = 0; j < players.length; j++) {
        		if(callings[i].equals(players[j])) {
        			String frontPlayer = players[j - 1];
        			
        			players[j - 1] = players[j];
        			players[j] = frontPlayer;
        			
        			continue;
        		}
        	}
        }
        
        return players;
    }
}