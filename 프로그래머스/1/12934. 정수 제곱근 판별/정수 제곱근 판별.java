class Solution {
    public long solution(long n) {
        long answer = 0;
        
        double sqrt = Math.sqrt(n);
        int sqrt_int = (int)Math.sqrt(n);
        
        if(sqrt == (double)sqrt_int){
            answer = (long)Math.pow(sqrt_int+1,2);
        } else {
            answer = -1;
        }
        
        return answer;
    }
}