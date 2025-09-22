import java.util.*;

class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int)(right-left)+1];
        //int[][] arr = new int[n][n];
        int index = 0;
        Run1: for (int i = 0; i < n; i++){
            for (int j = 0; j < n ; j++){
                long arrIndex = (long)n * (long)i + (long)j;
                
                if ( arrIndex < left - ( left % (long)n ) ) {
                    continue Run1;
                } 
                
                
                
                if ( arrIndex >= left ){
                    answer[index] = Math.max(i + 1,j + 1);
                    index++;
                }
                if ( arrIndex >= right){
                    break Run1;
                }
            }
        }
        
        return answer;
    }
}