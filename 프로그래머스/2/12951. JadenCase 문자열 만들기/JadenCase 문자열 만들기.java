class Solution {
    public String solution(String s) {
        String answer = "";
        StringBuffer sb = new StringBuffer();
        s = s.toLowerCase();
        char ch = s.charAt(0);
        if(s.charAt(0) >= 'a' && s.charAt(0) <= 'z'){
            ch -= 32;
        }
        sb.append(String.valueOf(ch));
        
        if( s.length() > 1){
            for(int i = 1;i < s.length(); i++){
                char new_ch = s.charAt(i);
                if (ch == ' ' && new_ch != ' ' && new_ch >= 'a' && new_ch <= 'z'){
                    new_ch -= 32;
                }
                sb.append(String.valueOf(new_ch));
                ch = new_ch;
            }
        }
        
        return sb.toString();
    }
}