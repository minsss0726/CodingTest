class Solution {
    public int solution(int M, int N) {
        int answer = 0;
        
        int n_a = 0;
        
        while ( N > 1) {
            n_a++;
            N--;
        }
        
        answer += (n_a*M);
        
        
        while (M > 1) {
            answer++;
            M--;
        }
    
        
        return answer;
    }
}