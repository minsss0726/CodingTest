import java.util.*;
class Solution {
    public String solution(String polynomial) throws Exception {
        int[] answer = {0,0};
        
        String[] poly_split = polynomial.split(" ");
        
        for ( String str:poly_split ){
            
            if ( str.endsWith("x") ){
                if ( !str.equals("x") ) {
                    answer[0] += Integer.parseInt(str.substring(0,str.length()-1));
                }else {
                    answer[0]++;
                }
            } else if ( !(str.equals("+")) ) {
                answer[1] += Integer.parseInt(str);
            }            
        }
        String answer_string = "";
        
        if (answer[1] == 0 && answer[0] == 0){
            return "";
        } else if ( answer[1] != 0 && answer[0] == 0){
            answer_string = String.valueOf(answer[1]);
        } else if ( answer[1] == 0 && answer[0] == 1){
            answer_string = "x";
        } else if ( answer[1] != 0 && answer[0] == 1){
            answer_string = "x + "+String.valueOf(answer[1]);
        } else if ( answer[1] == 0 && answer[0] > 1){
            answer_string = String.valueOf(answer[0])+"x";
        } else if ( answer[1] != 0 && answer[0] > 1){
            answer_string = String.valueOf(answer[0])+"x + "+String.valueOf(answer[1]);
        }
        
        
        return answer_string;
    }
}