class Solution {
    public int solution(String s) {
        int answer = 0;
        StringBuffer sb = new StringBuffer();
        sb.append(s);
        answer += check(sb.toString());
        
        if(sb.length() == 1){
            return 0;
        }
        
        for(int i = 1; i < s.length(); i++){
            sb.append(String.valueOf(sb.charAt(0)));
            sb.delete(0,1);
            // System.out.println(sb);
            answer += check(sb.toString());
        }
        
        return answer;
    }
    
    public int check(String str1){
        int last_length = str1.length();
        
        str1 = str1.replace("()","").replace("{}","").replace("[]","");
        int now_length = str1.length();
        
        while(last_length > now_length && now_length >= 2) {
            str1 = str1.replace("()","").replace("{}","").replace("[]","");
            last_length = now_length;
            now_length = str1.length();
        }
        
        if(str1.length() > 0) return 0;
        
        return 1;
    }
}