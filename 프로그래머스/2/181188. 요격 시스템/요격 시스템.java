import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 1;
        Arrays.sort(targets,(a,b) -> {
            return (a[1] - b[1]);
        });
        Arrays.sort(targets,(a,b) -> {
            return (a[0] - b[0]);
        });
        
        // Arrays.stream(targets).forEach(e -> System.out.println(Arrays.toString(e)));
        
        int start = targets[0][0];
        int end = targets[0][1];
        
        for (int i = 1; i < targets.length; i++){
            if ((targets[i][0] < end) && 
                (targets[i][0]) < targets[i-1][1]) {
                if ( targets[i][1] < end){
                    end = targets[i][1];
                }
                continue;
            }
            start = targets[i][0];
            end = targets[i][1];
            // System.out.println(start+" "+end);
            answer++;            
        }
        
        return answer;
    }
}