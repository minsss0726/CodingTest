class Solution {
    public boolean solution(String s) {
        boolean answer = false;
        if (s.equals(s.toLowerCase()) && s.equals(s.toUpperCase())
           && (s.length() == 4 || s.length()==6)){
            return true;
        }
        return answer;
    }
}