package lv1;

import java.util.HashMap;
import java.util.Map;

/**
 * @title 성격 유형 검사하기
 * @author 김민중
 * @see https://school.programmers.co.kr/learn/courses/30/lessons/118666
 * @category 2022 KAKAO BLIND RECRUITMENT, 구현
 */
public class TestPersonalityType {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        
        int cnt = survey.length;
        
        Map<String, Integer> map = new HashMap<>();
        
        map.put("R" , 0);
        map.put("T" , 0);
        map.put("C" , 0);
        map.put("F" , 0);
        map.put("J" , 0);
        map.put("M" , 0);
        map.put("A" , 0);
        map.put("N" , 0);
        
        for ( int i = 0; i < cnt ; i++ ) {
            if ( choices[i] < 4 ) {
                map.replace(String.valueOf(survey[i].charAt(0)), map.get(String.valueOf(survey[i].charAt(0))) + (int)Math.abs(choices[i] - 4) );
            } else if( choices[i] > 4) {
                map.replace(String.valueOf(survey[i].charAt(1)), map.get(String.valueOf(survey[i].charAt(1))) + choices[i] - 4 );
            }
        }
        
        System.out.println(map);
        
        String[] rcja = { "R" , "C" , "J" , "A" };
        String[] tfmn = { "T" , "F" , "M" , "N" };
        
        for (int i = 0 ; i < 4 ; i++){
            if (map.get(rcja[i]) == map.get(tfmn[i])){
                answer += rcja[i];
            } else if (map.get(rcja[i]) > map.get(tfmn[i])) {
                answer += rcja[i];
            } else {
                answer += tfmn[i];
            }
            
            
        }
        
        return answer;
    }
}
