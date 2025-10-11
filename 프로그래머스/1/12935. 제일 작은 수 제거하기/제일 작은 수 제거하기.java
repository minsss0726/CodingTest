import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        int[] answer = {};
        if(arr.length - 1 == 0){
            return new int[]{-1};
        }
        answer = new int[arr.length-1];
        int min = Arrays.stream(arr).min().getAsInt();
        
        int index = 0;
        for (int i = 0; i < arr.length; i++){
            if(arr[i] != min){
                answer[index]=arr[i];
                index++;
            }
        }
        
        return answer;
    }
}