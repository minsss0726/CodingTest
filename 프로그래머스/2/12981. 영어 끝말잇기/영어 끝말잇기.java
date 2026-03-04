import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];

        LinkedList<String> list = new LinkedList<>();
        list.add(words[0]);
        for(int i = 1; i < words.length; i++){
            if (list.contains(words[i])) break;
            
            String now = list.peekLast();
            if( now.charAt(now.length()-1) != words[i].charAt(0)) break;
            
            list.add(words[i]);
        }
        
        // System.out.println(list.size());
        
        if(list.size() != words.length) {
            answer[0] = ((list.size() + 1) % n) > 0 ? (list.size() + 1) % n : n;
            answer[1] = ((list.size() + 1) / n) + (((list.size() + 1) % n) > 0 ? 1 : 0);
        }

        return answer;
    }
}