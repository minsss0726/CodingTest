package lv1;

/**
 * @title 이웃한 칸
 * @author 김민중
 * @see https://school.programmers.co.kr/learn/courses/30/lessons/250125
 * @category PCCE 기출문제
 */
public class NeighboringBlock {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        
        int[] dx = {1, -1};
        int[] dy = {1, -1};
        
        for ( int x : dx){
            if ( w + x >= 0 && w + x < board.length){
                if (board[h][w].equals(board[h][w+x])){
                    answer++;
                }
            }
        }
        
        for ( int y : dy){
            if ( h + y >= 0 && h + y < board.length){
                if (board[h][w].equals(board[h+y][w])){
                    answer++;
                }
            }
        }
        
        return answer;
    }
}
