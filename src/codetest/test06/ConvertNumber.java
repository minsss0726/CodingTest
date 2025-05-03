package codetest.test06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConvertNumber {

	/*
	 * 0 - O () // 1 - I // 2 - Z // S 7_ // 3 - E B // 4 - A // 5 - Z S // 6 - B C
	 * // 7 - T Y // 8 - B E3 //9 - q p
	 * 
	 * 복수 문자 2 , 5 - Z , S // 3 , 8 - B
	 */

	ArrayList<ArrayList<String>> list = new ArrayList<>(
			Arrays.asList(new ArrayList<>(Arrays.asList("O", "()")), new ArrayList<>(Arrays.asList("I")),
					new ArrayList<>(Arrays.asList("Z", "S", "7_")), new ArrayList<>(Arrays.asList("E", "B")),
					new ArrayList<>(Arrays.asList("A")), new ArrayList<>(Arrays.asList("Z", "S")),
					new ArrayList<>(Arrays.asList("b", "G")), new ArrayList<>(Arrays.asList("T", "Y")),
					new ArrayList<>(Arrays.asList("B", "E3")), new ArrayList<>(Arrays.asList("q", "p"))));

	ArrayList<String> convert_nums = new ArrayList<>();

	public int[] solution(String[] numstrs, String[] words) {
		int[] answer = new int[words.length];

		// 중복 가능성이 있는 문자를 제외한 문자들을 숫자로 치환
		for (String numstr : numstrs) {
			for (int i = 0; i < numstr.length(); i++) {
				for (int j = 0; j < list.size(); j++) {
					if (list.get(j).contains(String.valueOf(numstr.charAt(i)))) {
						if (numstr.charAt(i) != 'Z' && numstr.charAt(i) != 'S' && numstr.charAt(i) != 'B'
								&& numstr.charAt(i) != 'E') {
							numstr = numstr.replace(String.valueOf(numstr.charAt(i)), String.valueOf(j));
						}
					}
				}
			}
			numstr = numstr.replace("7_", "2");

			System.out.println(numstr);

			// 중복 금지를 체크하기 위해 만든 array 값이 0 이면 사용할 수 있고 1이면 사용할 수 없다.
			// index 위치, l
			// 0 - 2가 S 금지
			// 1 - 2가 Z 금지
			// 2 - 5가 S 금지
			// 3 - 5가 Z 금지
			// 4- 3이 B 금지
			// 5 - 8이 B 금지
			ArrayList<Integer> locked = new ArrayList<>(List.of(0, 0, 0, 0, 0, 0));
			
			dfs(numstr, 0, "", new ArrayList<Integer>(locked));
			System.out.println(convert_nums);
			System.out.println("출력");
			int answer_index = 0;
			for (String word : words) {
				int isContain = (int) convert_nums.stream().filter(e -> e.contains(word)).count();
				if (isContain > 0) {
					System.out.println("exist " + word + "   index " + answer_index);
					answer[answer_index]++;
				}
				answer_index++;
			}
			
			
		}

		return answer;
	}

	public void dfs(String numstr, int index, String convert_numstr, ArrayList<Integer> locked) {
		if (index == numstr.length()) {
			convert_nums.add(convert_numstr);
			return;
		}

		if (index + 1 < numstr.length() && numstr.charAt(index) == 'E' && numstr.charAt(index + 1) == '3') {
			dfs(numstr, index + 2, convert_numstr + "8", new ArrayList<Integer>(locked));
			return;
		}

		char ch = numstr.charAt(index);
		switch (ch) {
		case 'Z':
			if (locked.get(1) == 0) {
				dfs(numstr, index + 1, convert_numstr + "2", setlocked(locked, 3));
			}
			if (locked.get(3) == 0) {
				dfs(numstr, index + 1, convert_numstr + "5", setlocked(locked, 1));
			}
			break;
		case 'S':
			if (locked.get(0) == 0) {
				dfs(numstr, index + 1, convert_numstr + "2", setlocked(locked, 2));
			}
			if (locked.get(2) == 0) {
				dfs(numstr, index + 1, convert_numstr + "5", setlocked(locked, 0));
			}
			break;
		case 'B':
			if (locked.get(4) == 0) {
				dfs(numstr, index + 1, convert_numstr + "3", setlocked(locked, 5));
			}
			if (locked.get(5) == 0) {
				dfs(numstr, index + 1, convert_numstr + "8", setlocked(locked, 4));
			}
			break;
		case 'E':
			dfs(numstr, index + 1, convert_numstr + "3", new ArrayList<Integer>(locked));
			break;
		default:
			dfs(numstr, index + 1, convert_numstr + ch, new ArrayList<Integer>(locked));
		}

	}

	public ArrayList<Integer> setlocked(ArrayList<Integer> locked, int index) {
		ArrayList<Integer> newlocked = new ArrayList<Integer>(locked);
		newlocked.set(index, 1);
		return newlocked;
	}

}