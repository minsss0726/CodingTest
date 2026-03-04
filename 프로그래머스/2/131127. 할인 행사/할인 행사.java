import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        HashMap<String,Integer> wants = new HashMap<String,Integer>();
        for(int i = 0; i < want.length; i++){
            wants.put(want[i],number[i]);
        }
        
        HashMap<String,Integer> discounts = new HashMap<String,Integer>();
        
        for(int i = 0; i < 10; i++){
            if(discounts.containsKey(discount[i])){
                discounts.replace(discount[i], discounts.get(discount[i]) + 1);
            } else {
                discounts.put(discount[i], 1);
            }
        }
        
        boolean isCorrect = true;
        
        for (String wa:want){
            if( wants.get(wa) != discounts.get(wa) ){
                isCorrect = false;
                break;
            } 
        }
        if (isCorrect == true) answer++;
        
        Loop1: for (int i = 1; i <= discount.length - 10; i++){
            
            discounts.replace(discount[i-1], discounts.get(discount[i-1]) - 1);
            
            if(discounts.containsKey(discount[i+9])){
                discounts.replace(discount[i+9], discounts.get(discount[i+9]) + 1);
            } else {
                discounts.put(discount[i+9], 1);
            }
            
            Loop2: for (String wa:want){
                if( wants.get(wa) != discounts.get(wa) ){
                    continue Loop1;
                } 
            }
            
            answer++;
        }
        
        return answer;
    }
}