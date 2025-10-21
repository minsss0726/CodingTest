class Solution {
    public String solution(String s, int n) {
        String answer = "";
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == ' ') {
                answer += " ";
            } else {
                if(ch >= 65 && ch <= 90){
                    ch += n;
                    if( ch > 90){
                        ch -= 26;
                    }
                } else {
                    ch += n;
                    if( ch > 122){
                        ch -= 26;
                    }
                }
                answer += String.valueOf(ch);
            }
            
        }
        return answer;
    }
}