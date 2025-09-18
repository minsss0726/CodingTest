import java.util.*;
class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        
        while (check(wallet,bill)){
            if (bill[0] < bill[1] ){
                bill[1] /= 2;
            } else {
                bill[0] /= 2;
            }
            answer++;
        }
        
        return answer;
    }
    
    public boolean check(int[] wallet, int[]bill){
        
        int min_w = (int) Math.min(wallet[0],wallet[1]);
        int max_w = (int) Math.max(wallet[0],wallet[1]);
        
        int min_b = (int) Math.min(bill[0],bill[1]);
        int max_b = (int) Math.max(bill[0],bill[1]);
        
        if ( min_b <= min_w && max_b <= max_w){
            return false;
        }
        
        return true;
    }
}