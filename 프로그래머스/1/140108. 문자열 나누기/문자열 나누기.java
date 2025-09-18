class Solution {
    public int solution(String s) {
        int answer = 0;
        
        int count1 = 0;
        int count2 = 0;
        
        char ch = s.charAt(0);
        
        for (int i = 0 ; i < s.length() ; i++ ){
            if (count1 == count2) ch = s.charAt(i);
            if (ch == s.charAt(i)) {
                count1++;
            } else {
                count2++;
            }
            if (count2 > 0 && count1 == count2){
                answer++;
                count1 = 0;
                count2 = 0;
            }
        }
        
        if (count1 != count2) answer++;
        
        return answer;
    }
}