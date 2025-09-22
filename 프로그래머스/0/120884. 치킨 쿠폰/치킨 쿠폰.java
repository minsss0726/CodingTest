class Solution {
    public int solution(int chicken) {
        int answer = 0;
        
        int coupone = 0;
        
        coupone += chicken;
        chicken = 0;
        
        while (coupone > 9){
            chicken += (coupone / 10);
            answer += chicken;
            coupone %= 10;
            coupone += chicken;
            chicken = 0;
        }
         
        return answer;
    }
}