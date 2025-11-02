import java.util.*;

class Solution {
    public int solution(int a, int b, int c, int d) {
        int answer = 1;
        
        HashSet<Integer> set = new HashSet<>();
        
        int[] dice = new int[7];
        dice[a]++;
        dice[b]++;
        dice[c]++;
        dice[d]++;
        
        set.add(a);
        set.add(b);
        set.add(c);
        set.add(d);
        
        if(set.size() == 1){
            return 1111 * a;
        } else if(set.size() == 4){
            Integer[] integerArray = set.toArray(new Integer[0]);
            int[] intArray = set.stream()
                                .mapToInt(Integer::intValue)
                                .toArray();
            int min = Arrays.stream(intArray).min().getAsInt();
            return min;
        } else if(set.size() == 2){
            int[] at2 = new int[2];
            boolean is3 = false;
            
            for(int i = 1; i <= 6; i++){
                if (dice[i] == 3) {
                    at2[0] = i;
                    is3 = true;
                };
                if (dice[i] == 1) at2[1] = i;
            }
            if(is3) return ( 10 * at2[0] + at2[1] ) * ( 10 * at2[0] + at2[1] );
            
            int index = 0;
            for(int i = 1; i <= 6; i++){
                if (dice[i] == 2) {
                    at2[index] = i;
                    index++;
                };
            }
            return (at2[0] + at2[1]) * Math.abs(at2[0]-at2[1]);
            
        }
        
        int[] at3 = new int[3];
        
        for(int i = 1; i <= 6; i++){
            if (dice[i] == 1) answer = answer*i;
        }
        
        
        return answer;
    }
}