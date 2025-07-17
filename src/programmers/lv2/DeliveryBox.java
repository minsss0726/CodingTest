package lv2;

import java.util.*;

/**
 * @title 택배 상자
 * @author 김민중
 * @see https://school.programmers.co.kr/learn/courses/30/lessons/131704
 * @category 연습문제
 */
public class DeliveryBox {
    public int solution(int[] order) {
        int answer = 0;
        int len = order.length;
        Deque<Integer> deque = new ArrayDeque<>();
        
        for (int i=0; i<len; ++i) {
            int currBox = i+1;
            if (currBox == order[answer]) {
                ++answer;
                // System.out.println("#currBox: "+currBox + " i: "+i);
            }
            else if (!deque.isEmpty() && order[answer] == deque.peekFirst()) {
                ++answer;
                deque.pollFirst();
                --i;
                // System.out.println("$currBox: "+currBox + " i: "+i);
            }
            else {
                deque.addFirst(currBox);
            }
            // System.out.println("deque : " + deque);
        }
        
        while (!deque.isEmpty()) {
            if (order[answer] == deque.peekFirst())
            {
                ++answer;
                deque.pollFirst();
            }
            else
                break;
        }
        return answer;
    }
}
