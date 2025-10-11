import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        // System.out.println(Arrays.toString(arr));
        for(char ch : arr){
            answer = String.valueOf(ch) + answer;
        }
        return answer;
    }
}