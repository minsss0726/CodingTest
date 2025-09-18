import java.util.*;
class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        
        Arrays.sort(lottos);
        Arrays.sort(win_nums);
        
        int zeros = (int) Arrays.stream(lottos).filter( e -> e == 0).count();

        answer[1] = (int) Arrays.stream(lottos).filter( e -> Arrays.binarySearch(win_nums,e) > -1).count();
        
        //System.out.println(zeros+" "+answer[1]);
        
        answer[0] = (7 - (zeros + answer[1]) > 6) ? 6 : 7 - (zeros + answer[1]);
        answer[1] = (7 - answer[1] > 6 ) ? 6 : 7 - answer[1];
        
        
        return answer;
    }
}