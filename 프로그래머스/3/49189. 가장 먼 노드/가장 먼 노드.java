import java.util.*;

class Solution {
    
    public int solution(int n, int[][] edge) {
        int answer = 0;
        LinkedList<Integer> q = new LinkedList<>();
        int[] arr = new int[n+1];
        boolean[] visited = new boolean[n+1];
        
        ArrayList<Integer>[] list = new ArrayList[n+1];
        
        for (int i = 1; i<=n ; i++){
            list[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < edge.length; i++){
            list[edge[i][0]].add(edge[i][1]);
            list[edge[i][1]].add(edge[i][0]);
        }
        
        q.add(1);
        visited[1] = true;
        
        while(!q.isEmpty()){
            int node = q.poll();
            for (int next : list[node]){
                if(visited[next]){
                    continue;
                }
                q.add(next);
                visited[next] = true;
                arr[next] = arr[node] + 1;
            }
        }
        
        // System.out.println(Arrays.toString(arr));
        Arrays.sort(arr);
        
        int max = arr[n];
        
        answer = (int)Arrays.stream(arr).filter(e -> e == max).count();
        
        return answer;
    }
}