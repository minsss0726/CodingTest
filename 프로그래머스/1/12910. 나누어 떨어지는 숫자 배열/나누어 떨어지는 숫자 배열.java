import java.util.*;
class Solution {
    public int[] solution(int[] arr, int divisor) {
        int[] answer = {};
        List<Integer> list = new ArrayList<>();
        
        for(int number:arr){
            if(number % divisor == 0){
                list.add(number);
            }
        }
        
        
        if(list.isEmpty()){
            answer = new int[]{ -1 };
            return answer;
        }
        
        answer = new int[list.size()];
        
        for(int i = 0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        
        Arrays.sort(answer);
        return answer;
    }
}