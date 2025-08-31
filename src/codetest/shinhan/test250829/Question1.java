package codetest.shinhan.test250829;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Question1 {
    public int[] solution(int[][] company, int[] benefit, int k) {
        int[] answer = new int[2];

        Map<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < company.length; i++){
            map.put(company[i][0],benefit[i]);
        }

        // System.out.println(map);

        Arrays.sort(company,(a,b) -> {
            return a[0] - b[0];
        });

        // for(int[] com:company){
        //     System.out.println(Arrays.toString(com));
        // }
        
        int sol1_1 = 0;
        int sol1_2 = 0;
        for(int i = 0; i < k; i++){
            sol1_1 += company[i][1];
            sol1_2 += map.get(company[i][0]);
        }
        
        answer[0] = Math.abs(sol1_1 - sol1_2);

        Arrays.sort(company,(a,b) -> {
            return b[1] - a[1];
        });

        int sol2_1 = 0;
        int sol2_2 = 0;
        for(int i = 0; i < k; i++){
            sol2_1 += company[i][1];
            sol2_2 += map.get(company[i][0]);
        }

        answer[1] = Math.abs(sol2_1 - sol2_2);

        return answer;
    }
}
