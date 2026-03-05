class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        
        String changeStr = "";
        int num = 0;
        while (changeStr.length() < t * m) {
            changeStr += Integer.toString(num++,n).toUpperCase();
        }
        
        // System.out.println(changeStr);
        
        for(int i = p - 1; i < changeStr.length(); i = i + m){
            answer += String.valueOf(changeStr.charAt(i));
            if(answer.length() == t) break;
        }
        
        return answer;
    }
}