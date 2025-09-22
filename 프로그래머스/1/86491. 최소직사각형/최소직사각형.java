import java.util.*;
class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        
        List<Integer> highs = new ArrayList<>();
        List<Integer> lows = new ArrayList<>();
        
        for (int[] size:sizes){
            highs.add(Math.max(size[0],size[1]));
            lows.add(Math.min(size[0],size[1]));
        }
        
        System.out.println(highs);
        System.out.println(lows);
        
        int max_highs = highs.stream().mapToInt(Integer::intValue).max().getAsInt();
        int max_lows = lows.stream().mapToInt(Integer::intValue).max().getAsInt();
        
        answer = max_highs * max_lows;
        return answer;
    }
}