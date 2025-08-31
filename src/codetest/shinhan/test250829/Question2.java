package codetest.shinhan.test250829;

import java.util.*;

public class Question2 {
    public int solution(int[] numbers) {
        int answer = 0;

        Map<Integer,Integer> map = new HashMap<>();

        for(int i = 1; i <= numbers.length + 1 ; i++){
            map.put(i, 0);
        }

        for(int number:numbers){
            map.replace(number,map.get(number)+1);       
        }

        // System.out.println(map);

        int last_num = numbers.length + 1;

        for (int i = 1 ; i <= numbers.length + 1; i++) {
            if(map.get(i) >= 2){
                return i+1;
            }
            if(map.get(i) == 0){
                if (i != last_num){
                    return i;
                } else{
                    return -1;
                }
            }
        }

        return answer;
    }
}