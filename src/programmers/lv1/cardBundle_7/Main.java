package programmers.lv1.cardBundle_7;

import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		String[] cards1 = { "i", "water", "drink" };
		String[] cards2 = { "want", "to" };
		String[] goal = { "i", "want", "to", "drink", "water" };

		System.out.println(solution(cards1, cards2, goal));
	}

	public static String solution(String[] cards1, String[] cards2, String[] goal) {
		String answer = "Yes";

		int cardsCnt1 = 0;
		int cardsCnt2 = 0;

		for (int i = 0; i < goal.length; i++) {
			if(cardsCnt1 >= cards1.length && cardsCnt2 >= cards2.length) {
				return "No";
			}
			
			if(cardsCnt1 < cards1.length) {
				if (cards1[cardsCnt1].equals(goal[i])) {
					cardsCnt1++;
					continue;
				} else {
					if(cardsCnt2 >= cards2.length) {
						return "No";
					}
				}
			}
			
			if(cardsCnt2 < cards2.length) {
				if (cards2[cardsCnt2].equals(goal[i])) {
					cardsCnt2++;
				} else {
					return "No";
				}
			}
		}

		return answer;
	}
}