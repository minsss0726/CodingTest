import java.util.*;
class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        
        double stay = 0d;
        double clear = 0d;
        double fail = 0d;
        
        Map<Integer, Double> map = new TreeMap<>();
        
        for ( int i = 1 ; i <= N ; i++){
            stay = 0d;
            clear = 0d;
            for (int stage:stages) {
                if ( stage >= i ){
                    clear += (double)1;
                    if (stage == i){
                        stay += (double)1;
                    }
                }
            }
            
            if ( clear != 0 ){
                fail = stay / clear;
            } else {
                fail = 0d;
            }
            
            map.put(i , fail);
        }
        
        answer = map.entrySet().stream()
                .sorted((e1, e2) -> Double.compare(e2.getValue(), e1.getValue())) 
                .mapToInt(Map.Entry::getKey) 
                .toArray(); 
        
        
        return answer;
    }
}