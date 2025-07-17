package lv1;

import java.util.ArrayList;
import java.util.List;

/**
 * @title 키패드 누르기
 * @author 김민중
 * @see https://school.programmers.co.kr/learn/courses/30/lessons/67256
 * @category 2020 카카오 인턴십, 구현
 */
public class TpyeKeypad {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        
        ArrayList<Integer> left_nums = new ArrayList<>(List.of(1,4,7,-1));
        ArrayList<Integer> right_nums = new ArrayList<>(List.of(3,6,9,-2));
        ArrayList<Integer> mid_nums = new ArrayList<>(List.of(2,5,8,0));
        
        int[] left_pos = { 1 , 3 };
        int[] right_pos = { 3, 3 };
        int[] mid_pos = { 2 , -1}; // [0] == 0 left , [0] == 1 right
        
        
        for (int num : numbers){
            if (right_nums.contains(num)){
                answer += "R";
                right_pos[0] = 3;
                right_pos[1] = right_nums.indexOf(num);
            } else if (left_nums.contains(num)){
                answer += "L";
                left_pos[0] = 1;
                left_pos[1] = left_nums.indexOf(num);
            } else {
                mid_pos[1] = mid_nums.indexOf(num);
                int left_dis = (int)(Math.abs(left_pos[0] - mid_pos[0]) + Math.abs(left_pos[1] - mid_pos[1]));
                int right_dis = (int)(Math.abs(right_pos[0] - mid_pos[0]) + Math.abs(right_pos[1] - mid_pos[1]));
                if (left_dis == right_dis){
                    if (hand.equals("right")){
                        answer += "R";
                        right_pos[0] = 2;
                        right_pos[1] = mid_nums.indexOf(num);
                    } else {
                        answer += "L";
                        left_pos[0] = 2;
                        left_pos[1] = mid_nums.indexOf(num);
                    }
                } else if ( left_dis > right_dis){
                    answer += "R";
                    right_pos[0] = 2;
                    right_pos[1] = mid_nums.indexOf(num);
                } else {
                    answer += "L";
                    left_pos[0] = 2;
                    left_pos[1] = mid_nums.indexOf(num);
                }
            }
            //System.out.println(Arrays.toString(left_pos)+"  "+Arrays.toString(right_pos)+"  "+num +"  "+ answer);
        }
        
        
        
        return answer;
    }
}
