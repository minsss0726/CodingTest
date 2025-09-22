class Solution {
    public int solution(int[][] dots) {
        int answer = 0;
        
        int[] length1 = { 0,0 };
        
        for (int i = 0 ; i < dots.length - 1 ; i++){
            if (dots[i][0] != dots[i+1][0]){
                length1[0] =(int)Math.abs(dots[i][0] - dots[i+1][0]);
                break;
            }
        }
        
        for (int i = 0 ; i < dots.length - 1 ; i++){
            if (dots[i][1] != dots[i+1][1]){
                length1[1] =(int)Math.abs(dots[i][1] - dots[i+1][1]);
                break;
            }
        }
        
        answer = length1[0] * length1[1];
        
        return answer;
    }
}