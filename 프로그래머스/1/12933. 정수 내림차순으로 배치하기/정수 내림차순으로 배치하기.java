import java.util.*;
class Solution {
    public long solution(long n) {
        long answer = 0;
        int[] arr = new int[String.valueOf(n).length()];
        
        int index = 0;
        while(n>0){
            arr[index] = (int)(n % 10);
            n /= 10;
            index++;
        }
        
        Arrays.sort(arr);
        
        for(int i = 0; i<arr.length; i++){
            answer += arr[i] * Math.pow(10,i);
        }
        
        return answer;
    }
}