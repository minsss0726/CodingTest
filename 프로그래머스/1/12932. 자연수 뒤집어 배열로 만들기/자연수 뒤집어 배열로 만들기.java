class Solution {
    public int[] solution(long n) {
        int[] answer = new int[String.valueOf(n).length()];
        
        String str = String.valueOf(n);
        
        for (int i= 0; i < str.length(); i++){
            answer[i] = Integer.parseInt(String.valueOf(str.charAt(str.length()-i-1)));
        }
        
        return answer;
    }
}