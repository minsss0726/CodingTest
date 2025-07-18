package lv1;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @title 햄버거 만들기
 * @author 김민중
 * @see https://school.programmers.co.kr/learn/courses/30/lessons/133502
 * @category 연습문제
 */
public class MakingHamburgers {
    public int solution(int[] ingredient) {
        int answer = 0;
        
        Stack<Integer> stack = new Stack<>();
        
        Stack<Integer> stack2 = new Stack<>();
        
        LinkedList<Integer> list = new LinkedList<>();
        
        for ( int i:ingredient ){
            
            stack.push(i);
            list.add(i);
            
            if ( list.size() > 4 ){
                list.poll();
            }
            if (list.equals(List.of(1,2,3,1)) ){
                answer++;
                stack.pop();
                stack.pop();
                stack.pop();
                stack.pop();
                list.clear();
                while (stack.size() > 0 && stack2.size() < 3){
                    stack2.push(stack.pop());
                }
                while (stack2.size() > 0 && list.size() < 3){
                    list.add(stack2.peek());
                    stack.push(stack2.pop());
                }
            }
            //System.out.println(stack+"   "+list);
        }
        
        
        return answer;
    }
}
