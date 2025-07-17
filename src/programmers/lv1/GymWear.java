package lv1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * @title 체육복
 * @author 김민중
 * @see https://school.programmers.co.kr/learn/courses/30/lessons/42862
 * @category 연습문제, 그리디
 */
public class GymWear {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        //answer += (n-lost.length);
        Arrays.sort(lost);
        Arrays.sort(reserve);
        int reserve_length = reserve.length;
        
        ArrayList<Integer> lost_list = new ArrayList<>();
        LinkedList<Integer> lost_list2 = new LinkedList<>();
        LinkedList<Integer> reserve_list = new LinkedList<>();
        
        for (int i : lost){
            lost_list.add(i);
            lost_list2.add(i);
        }
        for (int i : reserve){
            reserve_list.add(i);
        }
        
        lost_list.stream().filter(e -> reserve_list.contains(e)).forEach(
        e -> {
            reserve_list.remove(e);
            lost_list2.remove(e); 
        });
        
        lost_list.stream().filter(e -> reserve_list.contains((int)e -1) || reserve_list.contains((int)e +1)).forEach(
        e -> {
            if (reserve_list.contains((int)e -1)){
                reserve_list.remove((Integer)(e-1));
                lost_list2.remove(e);
            } else {
                reserve_list.remove((Integer)(e+1));
                lost_list2.remove(e);
            }
        });
        
        answer = n - lost_list2.size();
        
        return answer;
    }
}
