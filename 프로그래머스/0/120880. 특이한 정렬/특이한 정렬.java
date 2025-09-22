import java.util.*;
class Solution {
    public int[] solution(int[] numlist, int n) {
        int[] answer = new int[numlist.length];
        
        Arrays.sort(numlist);
        
        int min = Integer.MAX_VALUE;
        int num = 0;
        int index = -1;
        
        for (int j = 0 ; j <numlist.length;j++){
            for ( int i = 0 ; i < numlist.length ; i++ ){
                if ( ((int)Math.abs(n - numlist[i])) <= min) {
                    min = ((int)Math.abs(n - numlist[i]));
                    num = numlist[i];
                    index = i;
                }
            }
            answer[j] = numlist[index];
            numlist[index] = Integer.MAX_VALUE;
            min = Integer.MAX_VALUE;
        }
        
        
        
        return answer;
    }
}