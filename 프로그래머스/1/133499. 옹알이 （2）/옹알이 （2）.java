class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] arr = {"aya", "ye", "woo", "ma"};
        
        for(String bab:babbling){
            int len = bab.length();
            String lastSay = "";
            // System.out.println("check");
            Run2: while(true){
                // System.out.println(bab);
                for(String say:arr){
                    if(bab.startsWith(say) && !say.equals(lastSay)){
                        bab = bab.substring(say.length(),bab.length());
                        // System.out.println("remove "+say);
                        lastSay = say;
                    }
                }
                if(len == bab.length()) {
                    break Run2;
                } else if(len > 0) {
                    len = bab.length();
                    if(len == 0){
                        // System.out.println("correct");
                        answer++;
                        break Run2;
                    }
                } 
            }
        }
        
        return answer;
    }
}