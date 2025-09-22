import java.util.*;
class Solution {
    public String solution(String[] id_pw, String[][] db) {
        String answer = "fail";
        
        long isID = Arrays.stream(db).filter(e -> e[0].equals(id_pw[0]) ).count(); 

        long isPW = Arrays.stream(db).filter(e -> e[0].equals(id_pw[0]) && e[1].equals(id_pw[1]) ).count(); 
        
        if ( isID > 0 && isPW > 0) return "login";
        else if ( isID > 0 ) return "wrong pw";
        
        return answer;
    }
}