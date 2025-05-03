package codetest.test07;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class AccountSearch {

	public int[] solution(String[] nums) {

		Map<ArrayList<Integer>, Integer> rank_check = new HashMap<>();

		Run: for (String num : nums) {
			// 끝이 "-"인지 판단
			if (num.endsWith("-")) {
				continue Run;
			}
			// "-" 개수 파악을 위해 스플릿
			String[] num_split = num.split("-");
			// "-" 최대갯수가 3개 이므로 스플릿 개수는 최대 4일 수 있음
			if (num_split.length < 5) {
				// count 를 통해 계좌의 숫자 개수 파악
				int count = 0;
				for (String str : num_split) {
					// 만약 split 햇을때 "" 이 생기나면 "--" 형태가 있다는 뜻
					if (str.equals("")) {
						continue Run;
					}
					// 숫자만 있는지 확인
					for (int i = 0; i < str.length(); i++) {
						if (str.charAt(i) < 48 || str.charAt(i) > 57) {
							continue Run;
						}
					}
					count += str.length();
				}
				// 숫자 개수 파악
				if (count < 11 || count > 14) {
					continue Run;
				}
				// 같은 은행의 계좌번호를 판단하기 위해 "-" 스플릿 된 num 요소의 길이 파악
				ArrayList<Integer> split_length = new ArrayList<>();

				for (String str : num_split) {
					split_length.add(str.length());
				}

				// 파악된 계좌 형태를 Map 에 저장하면서 처음 은행이면 생성하고 이미 같은 은행이 Map 안에 있으면 +1
				if (rank_check.containsKey(split_length)) {
					rank_check.put(split_length, rank_check.get(split_length) + 1);
				} else {
					rank_check.put(split_length, 1);
				}
			}
		}

		// map에 저장되어 있는 value 값들을 stream 통해 정렬과 int[] 전환을 한번에 진행
		int[] answer = rank_check.values().stream().sorted(Comparator.reverseOrder()).mapToInt(Integer::intValue)
				.toArray();

		return answer;
	}

}