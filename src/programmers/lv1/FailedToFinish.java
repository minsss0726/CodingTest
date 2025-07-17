package lv1;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @title 완주하지 못한 선수
 * @author 김민중
 * @see https://school.programmers.co.kr/learn/courses/30/lessons/42576
 * @category 연습문제
 */
public class FailedToFinish {
    public String solution(String[] participant, String[] completion) {
        String answer = "";

        Arrays.sort(participant);
        Arrays.sort(completion);
        
        LinkedList<String> list1 = new LinkedList<>();
        LinkedList<String> list2 = new LinkedList<>();
                
        for(String str : participant) {
            list1.add(str ); 
        }
        for(String str : completion) {
            list2.add(str ); 
        }
        
        //System.out.println(list1);
        //System.out.println(list2);
        
        while (list2.size() > 0){
            answer = list1.poll();
            String com_string = list2.poll();
            if (!(answer.equals(com_string))) {
                break;
            } else if (list1.size() == 1){
                answer = list1.poll();
                break;
            }
        }
        if (answer.equals("")) {
            answer = list1.poll();
        }
        
        return answer;
    }
}
