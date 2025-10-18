import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        
        int[] prev = new int[1];
        int[] now = new int[2];
        
        prev[0] = triangle[0][0];
        
        for(int i = 1; i < triangle.length; i++){
            for(int j = 0; j < triangle[i].length; j++){
                if(j == 0){
                    now[j] = prev[j] + triangle[i][j];
                } else if(j == triangle[i].length - 1){
                    now[j] = prev[j-1] + triangle[i][j];
                } else {
                    int max1 = prev[j];
                    int max2 = prev[j-1];
                    if(max1 > max2){
                        now[j] = prev[j] + triangle[i][j];
                    } else {
                        now[j] = prev[j-1] + triangle[i][j];
                    }
                }
                if(now[j] > answer) answer = now[j];
            }
            prev = Arrays.copyOf(now, now.length);
            // System.out.println(Arrays.toString(prev));
            if(i < triangle.length - 1) {
                now = new int[triangle[i+1].length];
            }
        }
        
        return answer;
    }
}