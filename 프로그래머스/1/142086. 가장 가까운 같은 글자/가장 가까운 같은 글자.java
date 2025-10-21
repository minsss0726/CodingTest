import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        HashMap<String,Integer> map = new HashMap<>();
        
        for(int i = 0; i < s.length(); i++){
            String ch = String.valueOf(s.charAt(i));
            if(map.containsKey(ch)){
                answer[i] = i - map.get(ch);
                map.replace(ch, i);
            } else {
                answer[i] = -1;
                map.put(ch, i);
            }
        }
        
        return answer;
    }
}