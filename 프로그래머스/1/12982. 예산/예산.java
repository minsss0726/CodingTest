import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);
        
        for (int need : d){
            if (budget - need >= 0){
                budget -= need;
                answer++;
            } else {
                break;
            }
        }
        
        return answer;
    }
}