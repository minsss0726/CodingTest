package lv1;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @title 숫자 짝꿍
 * @author 김민중
 * @see https://school.programmers.co.kr/learn/courses/30/lessons/131128
 * @category 연습문제
 */
public class NumberPartner {
    public String solution(String X, String Y) {
        StringBuilder answer = new StringBuilder();
        
        Map<String, Integer> x_map = new HashMap<>();
        Map<String, Integer> y_map = new HashMap<>();
        
        for ( int i = 0; i < X.length(); i++ ){
            if (x_map.containsKey(String.valueOf(X.charAt(i)))) {
                x_map.replace(String.valueOf(X.charAt(i)), x_map.get(String.valueOf(X.charAt(i))) + 1);
            } else {
                x_map.put(String.valueOf(X.charAt(i)), 1);
            }
        }
        for ( int i = 0; i < Y.length(); i++ ){
            if (y_map.containsKey(String.valueOf(Y.charAt(i)))) {
                y_map.replace(String.valueOf(Y.charAt(i)), y_map.get(String.valueOf(Y.charAt(i))) + 1);
            } else {
                y_map.put(String.valueOf(Y.charAt(i)), 1);
            }
        }
        //System.out.println(x_map);
        //System.out.println(y_map);            
        
        Map<String, Integer> combi = new TreeMap<>();
                                             
        if ( x_map.size() < y_map.size() ) {
            x_map.entrySet().stream().filter( e -> y_map.containsKey(e.getKey())).forEach( e -> {
                int yVal = y_map.get(e.getKey());
                int xVal = e.getValue();
                combi.put(e.getKey(), Math.min(yVal, xVal));
            });
        } else {
             y_map.entrySet().stream().filter( e -> x_map.containsKey(e.getKey())).forEach( e -> {
                int yVal = e.getValue();
                int xVal = x_map.get(e.getKey());
                combi.put(e.getKey(), Math.min(yVal, xVal));
            });
        }                                
        
        //System.out.println(combi);
        
        if (combi.size() < 1){
            return "-1";
        }
        
        combi.entrySet().stream().forEach( e -> {
            for (int i = 0; i < (int)e.getValue(); i++){
                answer.append(e.getKey());
            }
        });
        
        answer.reverse();
        
        String answer2 = answer.toString();
        
        if (answer2.startsWith("0")){
            return "0";
        }
        
        return answer2;
    }
}
