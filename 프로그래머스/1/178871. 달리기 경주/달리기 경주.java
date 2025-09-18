import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = new String[players.length];
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for (int i = 0 ; i < players.length ; i++ ){
            map.put(players[i], i+1);
        }
        
        for (String player:callings){
            
            int rank = map.get(player);
            
            String over_player = players[rank-2];
            
            map.replace(player, rank-1);
            map.replace(over_player, rank);
            
            players[rank-1] = over_player;
            players[rank-2] = player;
         
        }
        
        
        
        
        /*LinkedList<String> list = new LinkedList<>();
        
        for (String player:players){
            list.add(player);
        }
        
        for (String player:callings){
            int index = list.indexOf(player);
            
            String over_player = list.get(index - 1);
            
            list.set(index, over_player);
            list.set(index-1, player);
            
        }
        
        for (int i = 0 ; i < answer.length ; i++) {
            answer[i] = list.poll();
        }*/
        
        
        
        return players;
    }
}