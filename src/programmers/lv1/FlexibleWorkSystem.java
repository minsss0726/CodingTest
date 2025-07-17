package lv1;

import java.util.Arrays;

/**
 * @title 유연근무제
 * @author 김민중
 * @see https://school.programmers.co.kr/learn/courses/30/lessons/388351
 * @category 2025 프로그래머스 코드챌린지 1차 예선
 */
public class FlexibleWorkSystem {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        
        int[] weekend = new int[2];
        
        int check_count = 0;
        
        weekend[0] = 7 -startday;
        if ( 7 - startday - 1 < 0){
            weekend[1] = 6;
        } else weekend[1] = 7 - startday - 1;
        
        for (int i = 0 ; i < schedules.length; i++){
            if ( (schedules[i] + 10) % 100 >= 60){
                schedules[i] = ((schedules[i] / 100 + 1) * 100) + (schedules[i] % 10);
                //if (schedules[i] / 100 >= 11) schedules[i] = 1100;
                } else schedules[i] += 10;
            }
        
        System.out.println(Arrays.toString(schedules));
        System.out.println(Arrays.toString(weekend));
        
        for (int i = 0; i < schedules.length; i++){
            for (int j = 0; j < timelogs[i].length; j++){
                if (( j != weekend[0]) && (j != weekend[1])){
                    if ( schedules[i] >= timelogs[i][j]) check_count++;
                }
            }
            if (check_count == 5) answer++;
            check_count = 0;
        }
        
        return answer;
    }
}
