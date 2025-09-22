class Solution {
    public String solution(String s) {
        String answer = "";
        s = s.toLowerCase();
        StringBuffer sb = new StringBuffer();
        
        int index = 0;
        
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if ( ch >= 'a' && ch <= 'z' && index % 2 == 0){
                ch -= 32;
            }
            index++;
            if ( ch == ' ') {
                index = 0;
            }
            sb.append(ch);
        }
        
        return sb.toString();
    }
}