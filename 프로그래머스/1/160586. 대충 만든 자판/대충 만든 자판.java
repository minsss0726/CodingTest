class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        
        int answer_index = 0;
        
        boolean isType = false;
        
        int touch = Integer.MAX_VALUE;
        
        Run : for (String target:targets){
            for ( int i = 0; i < target.length(); i++){
                touch = Integer.MAX_VALUE;
                isType = false;
                for (String key:keymap){
                    if (key.contains(String.valueOf(target.charAt(i)))){
                        int now = key.indexOf(target.charAt(i)) + 1;
                        if ( now < touch) {
                            touch = now;
                        }
                        isType = true;
                    }
                }
                if (isType == true) {
                answer[answer_index] += touch;
                } else {
                    answer[answer_index] = -1;
                    answer_index++;
                    continue Run;
                }
            }
            answer_index++;
        }
        
        return answer;
    }
}