class Solution {
    public String solution(int n) {
        StringBuffer sb = new StringBuffer();
        
        for (int i = 1; i <= n ;i++){
            sb.append( i % 2 == 0 ? "박" : "수");
        }
        
        return sb.toString();
    }
}