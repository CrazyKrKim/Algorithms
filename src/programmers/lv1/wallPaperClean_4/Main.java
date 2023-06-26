package programmers.lv1.wallPaperClean_4;

import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		String[] wallpaper = { "..........", ".....#....", "......##..", "...##.....", "....#....." };

		solution(wallpaper);
	}

	static public int[] solution(String[] wallpaper) {
		int minX = Integer.MAX_VALUE;
		int maxX = Integer.MIN_VALUE;
		int minY = Integer.MAX_VALUE;
		int maxY = Integer.MIN_VALUE;

		for (int i = 0; i < wallpaper.length; i++) {
			if (wallpaper[i].indexOf("#") != -1) {
				// minY를 구함
				if (minY > i) {
					minY = i;
				}

				// minX를 구함
				if (minX > wallpaper[i].indexOf("#")) {
					minX = wallpaper[i].indexOf("#");
				}

				// maxY를 구함
				if (maxY < i) {
					maxY = i;
				}

				if (maxX < wallpaper[i].lastIndexOf("#") + 1) {
					maxX = wallpaper[i].lastIndexOf("#") + 1;
				}
			}
		}

		maxY++;		
		int[] answer = {minY, minX, maxY, maxX};		
		return answer;
	}
}