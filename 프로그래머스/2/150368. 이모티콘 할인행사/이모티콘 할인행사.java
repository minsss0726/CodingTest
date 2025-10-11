import java.util.*;

class Solution {
    int[] answer = new int[2];
    ArrayList<int[]> lists = new ArrayList<>();
    
    public int[] solution(int[][] users, int[] emoticons) {
        int[] current = new int[emoticons.length];
        dfs(0, current, emoticons.length);
        
        // lists.stream().forEach(e->System.out.println(Arrays.toString(e)));
        
        for (int[] list:lists){
            // System.out.println(Arrays.toString(list));
            int plus = 0;
            int total_price = 0;
            
            User: for (int[] user:users){                
                int user_price = 0;
                for(int i = 0; i < list.length; i++){
                    if(user[0] <= list[i] * 10){
                        user_price += (emoticons[i] / 10 * (10-list[i]));
                    }
                    if (user_price >= user[1]){
                        plus++;
                        continue User;
                    }
                }
                total_price += user_price;
            }
            
            if (plus > answer[0]){
                answer[0] = plus;
                answer[1] = total_price;
                // System.out.println(Arrays.toString(list));
            } else if( plus >= answer[0] && total_price > answer[1]){
                answer[1] = total_price;
                // System.out.println(Arrays.toString(list));
            }
        }
        
        return answer;
    }
    
    public void dfs(int depth, int[] current, int n) {
        if (depth == n) {
            lists.add(current.clone());
            return;
        }

        for (int i = 1; i <= 4; i++) {
            current[depth] = i;
            dfs(depth + 1, current, n);
        }
    }
}