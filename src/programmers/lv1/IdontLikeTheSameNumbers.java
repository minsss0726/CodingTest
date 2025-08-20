package lv1;

import java.util.*;

/**
 * @title 같은 숫자는 싫어
 * @author 김민중
 * @see https://school.programmers.co.kr/learn/courses/30/lessons/12906
 * @category 스택/큐
 */
public class IdontLikeTheSameNumbers {
    public int[] solution(int []arr) {
        LinkedList<Integer> que = new LinkedList<>();
        
        for (int i : arr){
            if (que.size() == 0){
                que.add(i);
            } else if (que.peekLast() != i){
                que.add(i);
            }
        }
        
        int[] answer = new int[que.size()];
        int index = 0;
        while(que.size() != 0){
            answer[index] = que.poll();
            index++;
        }
        
        return answer;
    }
}
