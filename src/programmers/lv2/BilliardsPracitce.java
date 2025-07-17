package lv2;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @title 당구 연습
 * @author 김민중
 * @see https://school.programmers.co.kr/learn/courses/30/lessons/169198
 * @category 연습문제, 수학
 */
public class BilliardsPracitce {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];
        int answer_index = 0;
        
        for (int [] ball : balls) {
            int[][] symBalls = new int[4][2]; // 0-up , 1-rigth , 2-down , 3-left
            
            if (ball[0] != startX) {
                symBalls[0][0] = ball[0];
                symBalls[0][1] = n + n - ball[1];
                symBalls[2][0] = ball[0];
                symBalls[2][1] = -ball[1];
            } else if (ball[1] < startY){
                symBalls[0][0] = ball[0];
                symBalls[0][1] = n + n - ball[1];
                symBalls[2][0] = 0;
                symBalls[2][1] = 0;
            } else if (ball[1] > startY){
                symBalls[2][0] = ball[0];
                symBalls[2][1] = -ball[1];
                symBalls[0][0] = 0;
                symBalls[0][1] = 0;
            } 
            
            if (ball[1] != startY) {
                symBalls[1][0] = m + m - ball[0];
                symBalls[1][1] = ball[1];
                symBalls[3][0] = -ball[0];
                symBalls[3][1] = ball[1];
            }else if (ball[0] < startX){
                symBalls[1][0] = m + m - ball[0];
                symBalls[1][1] = ball[1];
                symBalls[3][0] = 0;
                symBalls[3][1] = 0;
            } else if (ball[0] > startX){
                symBalls[3][0] = -ball[0];
                symBalls[3][1] = ball[1];
                symBalls[1][0] = 0;
                symBalls[1][1] = 0;
            }
            
            ArrayList<Integer> distances = new ArrayList<>();
            
            for (int i = 0; i < 4; i++) {
                if (symBalls[i][0] != 0 && symBalls[i][1] != 0){
                    int dis = ((symBalls[i][0] - startX)*(symBalls[i][0] - startX)) + 
                        ((symBalls[i][1] - startY)*(symBalls[i][1] - startY));
                    distances.add(dis);
                }
            }
            
            Collections.sort(distances);
            //System.out.println(distances);
            
            answer[answer_index] = (int)distances.get(0);
            answer_index++;
        }
        
        return answer;
    }
}
