class Solution {
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];
        
        for (int i = 0 ; i < quiz.length ;i ++){
            String[] str = quiz[i].split(" ");
            
            if ( "+".equals(String.valueOf(str[1]))) {
                if ( Integer.parseInt(String.valueOf(str[0])) + Integer.parseInt(String.valueOf(str[2])) ==
                   Integer.parseInt(String.valueOf(str[4])) ) {
                    answer[i] = "O";
                }
                else answer[i] = "X";
            } else {
                if ( Integer.parseInt(String.valueOf(str[0])) - Integer.parseInt(String.valueOf(str[2])) ==
                   Integer.parseInt(String.valueOf(str[4])) ) {
                    answer[i] = "O";
                }
                else answer[i] = "X";
            }
            
            
            
        }
        
        return answer;
    }
}