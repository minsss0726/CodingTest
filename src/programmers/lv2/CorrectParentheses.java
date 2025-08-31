package lv2;

import java.util.*;

/**
 * @title 올바른 괄호
 * @author 김민중
 * @see https://school.programmers.co.kr/learn/courses/30/lessons/12909
 * @category 스택
 */
public class CorrectParentheses {
    boolean solution(String s) {
        boolean answer = false;

        LinkedList<Character> stack = new LinkedList<>();
        
        for(int i = 0; i < s.length(); i++){
            if ( s.charAt(i) == '('){
                stack.add('(');
            } else if (s.charAt(i) == ')' && !stack.isEmpty() 
                       && stack.peekLast() == '('){
                stack.pop();
            } else {
                stack.add(s.charAt(i));
            }
        }
        
        if(stack.isEmpty()) return true;

        return answer;
    }
}