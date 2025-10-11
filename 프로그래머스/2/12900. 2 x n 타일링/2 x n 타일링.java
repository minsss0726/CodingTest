class Solution {
    public int solution(int n) {
        int answer = 0;
        
        answer = (int)fibonachi(n);
            
        return answer;
    }
    
    public static long fibonachi(int n) {
        long result = 0;
        long tmp, b = 1;
    
        for (int i = 0; i <= n; i++){
            tmp = (result + b) % 1000000007L ; 
            result = b;
            b = tmp;
        }
        
        return result;
    }
}