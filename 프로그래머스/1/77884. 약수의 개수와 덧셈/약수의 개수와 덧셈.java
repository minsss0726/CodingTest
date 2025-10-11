import java.util.*;

class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        
        for(int i = left; i<=right; i++){
            if(isDivisorEven(i)){
                answer += i;
            } else {
                answer -= i;
            }
        }
        
        return answer;
    }
    
    public boolean isDivisorEven(int num){
        Set<Integer> set = new HashSet();
        for(int i = 1; i<=num;i++){
            if(num%i==0) set.add(i);
        }
        if(set.size() % 2 == 0){
            return true;
        }
        return false;
    }
}