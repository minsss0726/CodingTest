import java.util.*;

class Solution {
    
    ArrayList<LinkedList<Integer>> tree = new ArrayList<LinkedList<Integer>>();
    boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        for(int i = 0; i <= n; i++){
            tree.add(new LinkedList<Integer>());
        }
        for(int i = 0; i < computers.length; i++){
            for (int j = 0; j < computers[i].length; j++){
                if(i != j && computers[i][j] == 1){
                    tree.get(i+1).add(j+1);
                }
            }
        }
        
        // for(LinkedList<Integer> tr:tree){
        //     System.out.println(tr);
        // }
        
        visited = new boolean[n+1];
        
        for(int i = 1; i <= n; i++){
            if(visited[i] == false){
                LinkedList<Integer> que = new LinkedList<>();
                que.add(i);
                bfs: while(true){
                    for(int j:tree.get(que.pollFirst())){
                        if(visited[j] == false){
                            visited[j] = true;
                            que.add(j);
                        }
                    }
                    if(que.size() == 0) {
                        answer++;
                        break bfs;
                    };
                }
            }
        }
        
        return answer;
    }
    
    
}