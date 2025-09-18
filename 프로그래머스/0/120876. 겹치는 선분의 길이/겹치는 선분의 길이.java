class Solution {
    public int solution(int[][] lines) {
        int answer = 0;
        
        int startDot = 100;
        int endDot = -100;
        
        for ( int i = 0; i< 3; i++) {
            if (lines[i][0] < startDot ){
                startDot = lines[i][0];
            }
        }
        for ( int i = 0; i< 3; i++) {
            if (lines[i][1] > endDot ){
                endDot = lines[i][1];
            }
        }
        
        
        if (startDot < 0) {
            for (int i = 0 ; i < 3; i++){     
                lines[i][0] -= startDot;
                lines[i][1] -= startDot;              
            }
            endDot = endDot - startDot;
            startDot = startDot - startDot;
        }
        
        
        
        boolean[][] answerLines = new boolean[3][endDot];
        
        for (int i = 0; i < 3; i++){
            for (int j = 0;j<endDot; j++){
                if ((j >= lines[i][0]) && (j < lines[i][1])){
                    answerLines[i][j] = true;
                }
                System.out.print(answerLines[i][j]+" ");
            }
            System.out.println();
        }
    
        
        for (int i = 0 ; i < endDot; i++){
            if ((answerLines[0][i] && answerLines[1][i]) || (answerLines[0][i] && answerLines[2][i]) || (answerLines[1][i] && answerLines[2][i])) {
                answer++;
            }
        }
        
        
        return answer;
    }
}