import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        String[] answerSplit = s.split(" ");
        int max = Arrays.stream(answerSplit).mapToInt(Integer::parseInt).max().getAsInt();
        int min = Arrays.stream(answerSplit).mapToInt(Integer::parseInt).min().getAsInt();
        answer = String.valueOf(min) + " " + String.valueOf(max);
        return answer;
    }
}