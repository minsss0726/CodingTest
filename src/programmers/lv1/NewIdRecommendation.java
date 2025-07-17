package lv1;

/**
 * @title 신규 아이디 추천
 * @author 김민중
 * @see https://school.programmers.co.kr/learn/courses/30/lessons/72410
 * @category 2021 KAKAO BLIND RECRUITMENT, 문자열
 */
public class NewIdRecommendation {
    public String solution(String new_id) {
        String answer = "";
        
        String[] special_words = {"~","!","@","#","$","%","^","&"
                                 ,"*","(",")","=","+","[","{","]","}",":"
                                ,"?",",","<",">","/"};
        
        String dots = "..";
        
        new_id = new_id.toLowerCase();
        
        System.out.println(new_id);
        
        for (String special_word:special_words){
            new_id = new_id.replace(special_word,"");
        }
        System.out.println(new_id);
        
        for (int i = 0; i < new_id.length(); i++){
            new_id = new_id.replace(dots,".");
        }
        System.out.println(new_id);
        
        if ( new_id.startsWith(".") ){
            new_id = new_id.substring(1,new_id.length());
        }
        if ( new_id.endsWith(".") ){
            new_id = new_id.substring(0,new_id.length()-1);
        }
        System.out.println(new_id);
        
        new_id = new_id.replace(" ","a");
        if (new_id.length() == 0){
            new_id = "a";
        }
        System.out.println(new_id);
        
        if (new_id.length() >= 16){
            new_id = new_id.substring(0,15);
        }
        System.out.println(new_id);
        
        if ( new_id.startsWith(".") ){
            new_id = new_id.substring(1,new_id.length());
        }
        if ( new_id.endsWith(".") ){
            new_id = new_id.substring(0,new_id.length()-1);
        }
        System.out.println(new_id);
        
        new_id = new_id.replace(" ","a");
        if (new_id.length() == 0){
            new_id = "a";
        }
        
        while ((new_id.length() < 3) && (new_id.length() >= 1)){
            new_id = new_id + String.valueOf(new_id.charAt(new_id.length()-1));
        }
        System.out.println(new_id);
        
        answer = new_id;
        
        return answer;
    }
}
