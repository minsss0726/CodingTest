import java.util.*;

class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;
        int big = 0;
        int small = 0;
        
        if ( a > b)  {
            big = a;
            small = b;
        } else {
            big = b;
            small = a;
        }
        
        
        
        // if ((big > n / 2) && (small <= n / 2)) {
        //     return get2(n);
        // }
        
        while (!((big > n / 2) && (small <= n / 2))) { 
            if(small > n / 2) {
                big -= (n / 2);
                small -= (n / 2);
            }
            n = n / 2;
        }
    
        return get2(n);
    }
    
    public int get2(int n){
        int count = 0;
        while(n > 1){
            n = n / 2;
            count++;
        }
        return count;
    }

}