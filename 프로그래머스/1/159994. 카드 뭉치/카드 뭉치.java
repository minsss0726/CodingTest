import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";
        LinkedList<String> cards1List = new LinkedList<>();
        LinkedList<String> cards2List = new LinkedList<>();
        for(String card:cards1){
            cards1List.add(card);
        }
        for(String card:cards2){
            cards2List.add(card);
        }
        
        for (String g:goal){
            if(cards1List.size() > 0 && g.equals(cards1List.peekFirst())){
                cards1List.pollFirst();
                continue;
            } else if (cards2List.size() > 0 && g.equals(cards2List.peekFirst())){
                cards2List.pollFirst();
                continue;
            }
            return "No";
        }
        
        return answer;
    }
}