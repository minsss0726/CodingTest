package programmers;

public class MostReceivedGift {
	public int solution(String[] friends, String[] gifts) {
		int answer = 0;
		int x = 0;

		int friendsCount = friends.length;

		int[][] giftBoard = new int[friendsCount][friendsCount];

		int[] giftPoint = new int[friendsCount];

		int[] giveGift = new int[friendsCount];

		for (int i = 0; i < friendsCount; i++) {
			for (int j = 0; j < friendsCount; j++) {
				for (int k = 0; k < gifts.length; k++) {
					if ((gifts[k].startsWith(friends[i] + " ")) && (gifts[k].endsWith(" " + friends[j]))) {
						giftBoard[i][j]++;
					}
				}
			}
		}

		for (int i = 0; i < friendsCount; i++) {
			for (int j = 0; j < friendsCount; j++) {
				if (i != j) {
					giftPoint[i] += giftBoard[i][j];
					giftPoint[i] -= giftBoard[j][i];
				}
			}
		}

		for (int i = 0; i < friendsCount; i++) {
			for (int j = 0; j < friendsCount; j++) {
				if (i != j) {
					if (giftBoard[i][j] > giftBoard[j][i]) {
						giveGift[i]++;
					} else if (giftBoard[i][j] == giftBoard[j][i]) {
						if (giftPoint[i] > giftPoint[j]) {
							giveGift[i]++;
						}
					}
				}
			}
		}

		/*
		 * for (int i = 0; i < friendsCount; i++){ System.out.print(giveGift[i]+" "); }
		 */

		int maxCount = Integer.MIN_VALUE;

		for (int i = 0; i < friendsCount; i++) {
			if (giveGift[i] > maxCount) {
				maxCount = giveGift[i];
			}
		}

		return maxCount;
	}
}
