import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        
        for (int i = 0; i < score.length; i ++){
            int[] sortScore = Arrays.copyOf(score, i+1);
            Arrays.sort(sortScore);
            int len = sortScore.length;
            // System.out.println(Arrays.toString(sortScore));
            if(len < k){
                answer[i] = sortScore[len - 1 - i];
            } else {
                answer[i] = sortScore[len - 1 - (k - 1)];
            }
        }
        return answer;
    }
}