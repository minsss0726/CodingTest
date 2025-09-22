import java.util.*;

class Solution {
    public int[] solution(int[][] score) {
        int[] answer = new int[score.length];
        
        double[] score_average = new double[score.length];
        double[] sorted_average = new double[score.length];
        
        for (int i = 0  ; i < score.length ; i++) {
            score_average[i] = (double)(score[i][0] + score[i][1]) / (double)2;
            sorted_average[i] = (double)(score[i][0] + score[i][1]) / (double)2;
        }
        
        Arrays.sort(sorted_average);
        
        System.out.println(Arrays.toString(score_average));
        System.out.println(Arrays.toString(sorted_average));
        
        int rank = 1;
        int up_count = 0;
        
        for ( int i = sorted_average.length -1  ; i >=0 ; i--){
           for ( int j = 0 ; j < score_average.length ; j ++){
               if (sorted_average[i] == score_average[j]){
                   answer[j] = rank; 
                   System.out.println(Arrays.toString(answer));
                   up_count++;
               }
            }
            rank += up_count;
            i -= (up_count - 1);
            up_count = 0;
        }
        
        
        return answer;
    }
}