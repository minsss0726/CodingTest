import java.util.*;

class Solution {
    public int solution(int[][] signals) {
        int answer = -1;
        int repeat = 1;
        String[] sa = new String[signals.length];
        int min_len = Integer.MAX_VALUE;
    
        for(int[] signal:signals){
            int sum = 0;
            for(int si:signal){
                sum += si;
            }
            repeat *= sum;
        }
        
        for(int j = 0; j < signals.length; j++){
            String s = "";
            for(int i = 0; i < signals[j].length; i++){
                if( i == 0 ){
                    s += "G".repeat(signals[j][i]);
                } else if(i == 1){
                    s += "Y".repeat(signals[j][i]);
                } else if(i == 2){
                    s += "R".repeat(signals[j][i]);
                }
            }
            sa[j] = s.repeat(repeat);
            if(sa[j].length() < min_len){
                min_len = sa[j].length();
            }
        }
        
        // System.out.println(Arrays.toString(sa));
        // System.out.println(min_len);
        
        for(int i = 0; i < min_len; i++){
            
            HashSet<Character> set = new HashSet<>();
            
            for(String s:sa){
                set.add(s.charAt(i));
            }
            
            // System.out.println(set);
            
            if(set.size() == 1 && set.contains('Y')){
                answer = i + 1;
                break;
            }
            
        }
        
        return answer;
    }
}