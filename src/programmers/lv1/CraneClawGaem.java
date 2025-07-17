package lv1;

import java.util.LinkedList;

/**
 * @title 크레인 인형뽑기 게임
 * @author 김민중
 * @see https://school.programmers.co.kr/learn/courses/30/lessons/64061
 * @category 2019 카카오 개발자 겨울 인턴십, 구현
 */
public class CraneClawGaem {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        LinkedList<Integer> list = new LinkedList<>(); 
        
        int board_size = board.length;
        
        for ( int move: moves) {
            move = move - 1; // set arr line
            int doll = 0;
            for (int i = 0 ; i < board_size ; i ++){
                if ( board[i][move] != 0 ) {
                    doll = board[i][move];
                    board[i][move] = 0;
                    break;
                }
            }
            
            if( doll != 0) {
                if ( list.size() < 1 ){
                    list.addFirst(doll);
                } else {
                    if ( list.element() == doll ){
                        list.poll();
                        answer += 2;
                    }
                    else {
                        list.addFirst(doll);
                    }
                }
            
            }
        }
        
        return answer;
    }
}
