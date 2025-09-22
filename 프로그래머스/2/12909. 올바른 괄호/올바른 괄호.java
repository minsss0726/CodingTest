import java.util.*;
class Solution {
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