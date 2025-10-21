import java.util.*;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        for(int i = 0; i < n; i++){
            String numBin = Integer.toBinaryString(arr1[i] | arr2[i]);
            answer[i] = numBin;
        }
        
        for(int i = 0; i < n; i++){
            answer[i] = answer[i].replace("1","#").replace("0"," ");
            if(answer[i].length() < n){
                for(int j = 0; j <= n - answer[i].length(); j++){
                    answer[i] = " " + answer[i];
                }
            } else if(answer[i].length() > n){
                answer[i] = answer[i].substring( answer[i].length()-n, answer[i].length());
            }
        }
        
        return answer;
    }
}