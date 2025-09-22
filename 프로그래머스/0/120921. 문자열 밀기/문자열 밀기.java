import java.util.*;

class Solution {
    public int solution(String A, String B) {
        int answer = 0;
        
        LinkedList<String> A_list = new LinkedList<>();
        LinkedList<String> B_list = new LinkedList<>();
        
        for (int i = 0 ; i < B.length(); i++){
            B_list.add(String.valueOf(B.charAt(i)));
        }
        
        for (int i = 0 ; i < A.length(); i++){
            A_list.add(String.valueOf(A.charAt(i)));
        }
        
        if (A_list.equals(B_list)) return 0;
        
        for (int i = 0; i < B.length() ; i++){
            A_list.addFirst(A_list.pollLast());
            answer++;
            if ( B_list.equals(A_list) ) {
                return answer;
            }   
        }
        
        return -1;
    }
}