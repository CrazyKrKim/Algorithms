package programmers.lv1.runRace_1;

import java.io.IOException;
import java.util.HashMap;

public class Main2 {
	public static void main(String[] args) throws IOException {
		String[] players = { "mumu", "soe", "poe", "kai", "mine" };
		String[] callings = { "kai", "kai", "mine", "mine" };

		solution(players, callings);
	}

	public static String[] solution(String[] players, String[] callings) {
		String[] answer = new String[players.length];
		
		HashMap<String, Integer> rank = new HashMap<String, Integer>();
		HashMap<Integer, String> playerRank = new HashMap<Integer, String>();

		for (int i = 0; i < players.length; i++) {
			rank.put(players[i], i);
			playerRank.put(i, players[i]);
		}
		
		for(int i = 0; i < callings.length; i++) {
			String front = callings[i];
			String back = playerRank.get(rank.get(front) - 1);
			int frontRank = rank.get(back);
			int backRank = rank.get(front);
			
			rank.put(front, frontRank);
			rank.put(back, backRank);
			
			playerRank.put(frontRank, front);
			playerRank.put(backRank, back);
		}
		
		for(int i = 0; i < players.length; i++) {
			answer[i] = playerRank.get(i);
		}
		
		return answer;
	}
}