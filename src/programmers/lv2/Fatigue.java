package lv2;

import java.util.LinkedList;
import java.util.List;

public class Fatigue {
    List<Integer> list = new LinkedList<>();
        
    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        
        boolean[] visited = new boolean[dungeons.length];
        // { false, false, false }
        
        dfs(k, dungeons, visited, 0, dungeons.length);
        
        // System.out.println(list); 
        answer = list.stream().mapToInt(Integer::valueOf).max().getAsInt();
        
        return answer;
    }
    
    public void dfs(int k, int[][]dungeons, boolean[] visited, int count, int length){
        // if(count >= length || k <= 0){
        //     list.add(count);
        //     return;
        // }
        
        for(int i = 0; i < length; i++){
            if(visited[i] == false && k >= dungeons[i][0] && k - dungeons[i][1] >= 0){
                visited[i] = true;
                dfs( k - dungeons[i][1], dungeons, visited, count + 1,length);
                visited[i] = false;
            } 
        }
        
        list.add(count);
    }
}
