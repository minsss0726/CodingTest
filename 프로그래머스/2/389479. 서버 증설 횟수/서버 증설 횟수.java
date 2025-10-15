import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int servers = 0;
        int[] addServers = new int[24];
        
        for (int i = 0; i < players.length; i++){ 
            if (i >= k && addServers[i-k] > 0){
                    servers -= addServers[i-k];
                }
            if (players[i] < m){
                // System.out.println(servers);
                continue;
            }
            int server = players[i] / m;
            if(servers < server){
                answer += (server - servers);
                addServers[i] = server - servers;
                servers = server;
            } 
            // System.out.println(servers);
        }
        // System.out.println(Arrays.toString(addServers));
        return answer;
    }
}