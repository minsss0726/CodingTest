import java.util.*;

class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        Arrays.sort(arr);
        answer = arr[0];
        
        Run1: for (int i = 1; i < arr.length ; i++){
            for (int j = 1; j <= answer ; j++){
                for (int z = 1; z <= arr[i]; z++){
                    if ( arr[i] * j == answer * z){
                        answer = answer * z;
                        continue Run1;
                    }
                }
            }
        }
        
        return answer;
    }
}