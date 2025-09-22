class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        int[] answer = {0,0};
        
        int rl_max_dot = board[0] / 2;
        int ud_max_dot = board[1] / 2;
        
        for (String str:keyinput){
            switch (str) {
                case "up":
                    if ( answer[1] < ud_max_dot) answer[1]++;
                    break;
                case "down":
                    if ( answer[1] > -ud_max_dot) answer[1]--;
                    break;
                case "right":
                    if ( answer[0] < rl_max_dot) answer[0]++;
                    break;
                case "left":
                    if ( answer[0] > -rl_max_dot) answer[0]--;
                    break;
            }
        }
        
        return answer;
    }
}