class Solution {
    public int solution(int[][] board) {
        int answer = 0;
        
        int boardSize = board.length;
        
        boolean[][] safeZone = new boolean[boardSize+2][boardSize+2];
        
        
        
        for (int i = 0; i < boardSize; i++){
            for (int j = 0; j < boardSize; j++) {
                if (board[i][j] == 1){
                    safeZone[i+1][j+1] = true;
                    safeZone[i+1][j] = true;
                    safeZone[i+1][j+2] = true;
                    safeZone[i][j+1] = true;
                    safeZone[i+2][j+1] = true;
                    safeZone[i+2][j+2] = true;
                    safeZone[i+2][j] = true;
                    safeZone[i][j+2] = true;
                    safeZone[i][j] = true;
                }
            }
        }
        
        for (int i = 0; i < boardSize+2;i++){
            for (int j = 0 ; j < boardSize+2;j++){
                System.out.print(safeZone[i][j]+" ");
            }
            System.out.println();
        }
        
        for (int i = 1; i < boardSize+1; i++){
            for (int j = 1; j < boardSize+1; j++){
                if (safeZone[i][j]) {
                    
                } else{
                    answer++;
                }
            }
        }
        
        
        
        return answer;
    }
}