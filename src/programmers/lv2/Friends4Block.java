package lv2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * @title 프렌즈4블록
 * @author 김민중
 * @see https://school.programmers.co.kr/learn/courses/30/lessons/17679
 * @category 2018 KAKAO BLIND RECRUITMENT, 구현
 */
public class Friends4Block {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        
        int[][][] checkpoint = new int[][][]{ { {-1,0} , {-1,-1}, {0,-1} }, 
                                           { {1,0 } , {1,-1}, {0,-1} },
                                           { {-1,0 } , {-1,1}, {0,1} },
                                           { {1,0 } , {1,1}, {0,1} } };
        
        char[][] newBoard = new char[board.length][board[0].length()];
        
        for (int i = 0; i<board.length ; i++){
            for (int j =0 ; j<board[0].length(); j++){
                newBoard[i][j] = board[i].charAt(j);
            }
        }
        
        MainRun: while (true) {
        
            HashSet<String> removeDots = new HashSet<>();
            for (int i = 1; i < m-1 ; i++){
                Run1 : for (int j = 1; j < n-1 ; j++){
                    char ch = newBoard[i][j];
                    if (ch =='X'){
                        continue Run1;
                    }
                    for(int z = 0 ; z < checkpoint.length ; z++){
                        int count = 0;
                        ArrayList<int[]> dots = new ArrayList<>();
                        dots.add(new int[]{i,j});
                        for (int x = 0 ; x < checkpoint[z].length ; x++){
                            if ( ch == newBoard[i - checkpoint[z][x][0]][j-checkpoint[z][x][1]]){
                                count++;
                                dots.add(new int[]{i - checkpoint[z][x][0],j-checkpoint[z][x][1]});
                            }
                        }
                        if (count == 3) {
                            for (int y = 0; y < dots.size() ; y++){
                                removeDots.add( String.valueOf(dots.get(y)[0])+","+String.valueOf(dots.get(y)[1]) );
                            }
                        }
                    }
                }
            }
            
            answer += removeDots.size();
            if (removeDots.size() == 0){
                break MainRun;
            }  
            
            
            for (String removeDot:removeDots){
                String[] dot = removeDot.split(",");
                newBoard[Integer.parseInt(dot[0])][Integer.parseInt(dot[1])] = 'X';
            }

            for ( int i = 0 ; i < newBoard[0].length ; i++){
                LinkedList<Character> list = new LinkedList<>();
                for (int j = newBoard.length - 1; j >=0 ; j-- ){
                    if (newBoard[j][i] != 'X'){
                        list.add(newBoard[j][i]);
                    }
                }
                for (int j = newBoard.length - 1; j >=0 ; j-- ){
                    if ( list.size() > 0 ){
                        newBoard[j][i] = (char)list.poll();
                    } else {
                        newBoard[j][i] = 'X';
                    }
                }
            }
            
        }
        
        return answer;
    }
}
