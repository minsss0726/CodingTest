class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        
        int index = section[0] + m;
        answer++;
        
        for(int sec:section){
            if(sec < index) continue;
            index = sec + m;
            answer++;
            if(index > n) break;
        }
        
        return answer;
    }
}