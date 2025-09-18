import java.util.*;
class Solution {
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