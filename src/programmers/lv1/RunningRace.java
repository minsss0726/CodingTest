package lv1;

import java.util.HashMap;

/**
 * @title 달리기 경주
 * @author 김민중
 * @see https://school.programmers.co.kr/learn/courses/30/lessons/178871
 * @category 연습문제
 */
public class RunningRace {
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
        return players;
    }
}
