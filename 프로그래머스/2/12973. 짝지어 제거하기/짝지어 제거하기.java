import java.util.*;

class Solution
{
    public int solution(String s)
    {
        int answer = 1;

        LinkedList<Character> que = new LinkedList<>();
        
        que.add(s.charAt(0));
        
        for(int i = 1; i < s.length(); i++){
            if(que.size() > 0 && que.peekLast() == s.charAt(i)){
                que.pollLast();
            } else {
                que.add(s.charAt(i));
            }
        }
        
        if (que.size() > 0) return 0;

        return answer;
    }
}