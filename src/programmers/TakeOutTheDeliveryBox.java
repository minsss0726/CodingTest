package programmers;

public class TakeOutTheDeliveryBox {
	public int solution(int n, int w, int num) {
		int answer = 0;

		int box_number = 1;
		int[] my_box = { 0, 0 };

		int l = n / w + 1;

		int[][] storage = new int[l][w];

		int[] pos = { 0, w - 1 };

		int dir = 0; // 0 - to right . 1 - to left

		for (int i = l - 1; i >= 0; i--) {
			if (dir == 0) {
				for (int j = 0; j < w; j++) {
					if (box_number <= n)
						storage[i][j] = box_number;
					System.out.print(storage[i][j] + " ");
					if (box_number == num) {
						my_box[0] = i;
						my_box[1] = j;
					}
					box_number++;
				}
				dir = 1;
			} else if (dir == 1) {
				for (int j = w - 1; j >= 0; j--) {
					if (box_number <= n)
						storage[i][j] = box_number;
					System.out.print(storage[i][j] + " ");
					if (box_number == num) {
						my_box[0] = i;
						my_box[1] = j;
					}
					box_number++;
				}
				dir = 0;
			}
			System.out.println();
		}

		for (int i = my_box[0]; i >= 0; i--) {
			if (storage[i][my_box[1]] != 0) {
				answer++;
			}
		}

		return answer;
	}
}
