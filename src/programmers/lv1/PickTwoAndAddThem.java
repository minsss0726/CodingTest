package lv1;

import java.util.*;

/**
 * @title 두 수의 합
 * @author 김민중
 * @see https://school.programmers.co.kr/learn/courses/30/lessons/68644
 * @category 월간 코드 챌린지 시즌1
 */
public class PickTwoAndAddThem {
    public int[] solution(int[] numbers) {
        int[] answer = {};
        HashSet<Integer> set = new HashSet<>();
        
        for (int i = 0; i < numbers.length; i++){
            for (int j = i+1; j < numbers.length; j++){
                set.add(numbers[i]+numbers[j]);
            }
        }
        
        answer = set.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(answer);
        return answer;
    }
}
