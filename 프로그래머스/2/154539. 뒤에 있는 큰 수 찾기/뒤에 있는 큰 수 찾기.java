import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        
        Stack<Integer> stack = new Stack<>();
        stack.push(numbers[0]);
        
        for (int i = 1 ; i < numbers.length ; i++){
            int index = i - 1;
            while ( !stack.empty() && (int)stack.peek() < numbers[i] ){
                if( answer[index] == 0) {
                    answer[index] = numbers[i];
                    stack.pop();
                }
                index--;
            }
            stack.push(numbers[i]);
        }
        
        for (int i = 0 ; i < answer.length; i++){
            answer[i] = answer[i] == 0 ? -1 : answer[i];
        }
        
        return answer;
    }
}