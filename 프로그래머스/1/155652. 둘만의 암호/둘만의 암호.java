class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        
        for (int i = 0; i < s.length() ;i++){
            char ch = s.charAt(i);
            for (int j = 1; j <= index ; j++){
                ch++;
                if (ch > 122) {
                        ch = 'a';
                    }  
                while (skip.contains(String.valueOf(ch))){
                    ch++;
                    if (ch > 122) {
                        ch = 'a';
                    }   
                }
                System.out.print(ch);
            }
            answer += String.valueOf(ch);
            System.out.println();
        }
        
        return answer;
    }
}