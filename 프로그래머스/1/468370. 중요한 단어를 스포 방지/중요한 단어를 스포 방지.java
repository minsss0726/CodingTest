import java.util.*;

class Solution {
    public int solution(String message, int[][] spoiler_ranges) {
        int answer = 0;
        StringBuilder sb = new StringBuilder(message);
        
        ArrayList<String> origin = new ArrayList<>();
        ArrayList<String> filter = new ArrayList<>();
        HashSet<String> checked = new HashSet<>();
        
        for(int[] sr:spoiler_ranges){
            for(int i = sr[0]; i <= sr[1]; i++){
                if(sb.charAt(i) != ' '){
                    sb.replace(i,i+1,"*");
                }
            }
        }
        
        // System.out.println(sb);
        
        for(String me:message.split(" ")){
            origin.add(me);
        }
        for(String me:sb.toString().split(" ")){
            filter.add(me);
        }
        
        for(int i = 0; i < filter.size(); i++){
            String s = filter.get(i);
            if (s.indexOf("*") >= 0){
                String secret = origin.get(i);
                // System.out.println(secret);
                if(!filter.contains(secret) && !checked.contains(secret)){
                    checked.add(secret);
                    answer++;
                }   
            }
        }
        
        
        
        return answer;
    }
}