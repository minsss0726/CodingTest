import java.util.*;

class Solution {
    int answer = 0;
    public int solution(int[] number) {
        Arrays.sort(number);
        dfs(0,number,0,0);
        return answer;
    }
    
    public void dfs(int sum, int[] number, int start, int depth){
        if(depth == 3){
            // System.out.println("done "+sum);
            if(sum == 0){
                answer++;
            }
            return;
        }
        
        for(int i = start ; i < number.length; i++){
            dfs(sum + number[i], number, i+1, depth+1);
        }
    }
}