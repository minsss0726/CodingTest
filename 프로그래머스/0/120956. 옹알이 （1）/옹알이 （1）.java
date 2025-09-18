class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] baby = {"aya", "ye", "woo", "ma"};
        
        for (String str1:babbling){
            while ( str1.startsWith(baby[0]) || str1.startsWith(baby[1]) ||
                   str1.startsWith(baby[2]) || str1.startsWith(baby[3]) ){
                for (String str2:baby){
                    if (str1.startsWith(str2)){
                        str1 = str1.substring(str2.length());
                        System.out.println("str1 length :" + str1.length());
                        
                    }
                }
                if ( str1.length() == 0 ) {
                    answer++;
                    System.out.println("anwser :" + answer);}
                     
            }
            
        }
        
        return answer;
    }
}