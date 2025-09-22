import java.util.*;

class Solution {
    List<Integer> list = new LinkedList<>();
    
    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        
        boolean[] visited = new boolean[dungeons.length];
        
        dfs(k, dungeons, visited, 0, dungeons.length);
        
        // System.out.println(list); 
        answer = list.stream().mapToInt(Integer::valueOf).max().getAsInt();
        
        int[] arr = {1,2,3,4,5};
        
        // for (int i = 0; i < arr.length ; i++){
        //     for (int j = 0 ; j < arr.length; j++){
        //         if( i != j) {
        //             for (int k = 0; k < arr.length; k ++){
        //                 if (k != i && k != j){
        //                     System.out.println(arr[i] + " " + arr[j] + " "+ arr[k]);
        //                 }
        //             }
        //         }
        //     }
        // }        
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
                // System.out.println(Arrays.toString(dungeons[i]));
                dfs( k - dungeons[i][1], dungeons, visited, count + 1,length);
                visited[i] = false;
            } 
        }
        // System.out.println("dfs end");
        
        list.add(count);
    }
}