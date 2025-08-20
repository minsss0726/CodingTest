package lv2;

/**
 * @title 모음사전
 * @author 김민중
 * @see https://school.programmers.co.kr/learn/courses/30/lessons/84512
 * @category 완전탐색
 */
public class VowelDictionary {
    class Solution {
        char[] docs = new char[]{'A','E','I','O','U'};
    
        public int solution(String word) {
            int answer = 1;
            String now = "A";
            
            MainLoop: while (!word.equals(now)){
                answer++;
                // System.out.println(now);
                char first_char = now.charAt(0);
                if (now.charAt(0) == first_char && now.length() < 5){
                    now += "A";
                    continue MainLoop;
                }
                
                while (now.charAt(now.length()-1) == 'U' && now.length() > 1){
                    now = now.substring(0,now.length()-1);
                }
                now = goNext(now);
                
            }
            
            
            return answer;
        }
        
        public String goNext(String now){
            if (now.charAt(now.length()-1) == 'A'){
                now = now.substring(0,now.length()-1) + 'E';
            } else if (now.charAt(now.length()-1) == 'E'){
                now = now.substring(0,now.length()-1) + 'I';
            } else if (now.charAt(now.length()-1) == 'I'){
                now = now.substring(0,now.length()-1) + 'O';
            } else if (now.charAt(now.length()-1) == 'O'){
                now = now.substring(0,now.length()-1) + 'U';
            } 
            
            
            return now;
        }
    }
}
