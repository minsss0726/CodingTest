import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        ArrayList<ArrayList<Integer>> edges = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i <= n; i++){
            edges.add(new ArrayList<Integer>());
        }
        for(int[] wire:wires){
            edges.get(wire[0]).add(wire[1]);
            edges.get(wire[1]).add(wire[0]);
        }
        
        // for(ArrayList<Integer> edge:edges){
        //     System.out.println(edge);
        // }
        
        for(int[] removeWire:wires){
            edges.get(removeWire[0]).remove((Integer)removeWire[1]);
            edges.get(removeWire[1]).remove((Integer)removeWire[0]);
            
            // for(ArrayList<Integer> edge:edges){
            //     System.out.println(edge);
            // }
            
            LinkedList<Integer> que = new LinkedList<>();
            int count = 1;
            boolean[] visited = new boolean[n+1];
            que.add(1);
            visited[1] = true;
            
            while(que.size() > 0){
                int peek = que.peekFirst();
                for(int i = 0; i < edges.get(peek).size(); i++){
                    if(!visited[edges.get(peek).get(i)]){
                        que.add(edges.get(peek).get(i));
                        visited[edges.get(peek).get(i)] = true;
                        count++;
                    }
                }
                que.pollFirst();
                // System.out.println(que);
            }
            if(answer > Math.abs(count - (n - count))) answer = Math.abs(count - (n - count));
            // System.out.println("answer: "+answer);
            edges.get(removeWire[0]).add(removeWire[1]);
            edges.get(removeWire[1]).add(removeWire[0]);
        }
        
        return answer;
    }
}