import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        LinkedList<Integer> que = new LinkedList<>();
        LinkedList<Integer> index = new LinkedList<>();
        
        for(int i = 0; i < priorities.length; i++){
            que.add(priorities[i]);
            index.add(i);
        }
        
        int clear_index = -1;
        
        Arrays.sort(priorities);
        // System.out.println(Arrays.toString(priorities));
        int high_index = priorities.length - 1;
        int high = priorities[high_index];
        
        while (!(clear_index == location)) {
            int first_que = que.pollFirst();
            int first_index = index.pollFirst();
            
            if (first_que >= high) {
                clear_index = first_index;
                if(high_index > 0) high_index--;
                high = priorities[high_index];
                answer++;
            } else {
                que.add(first_que);
                index.add(first_index);
            }
        }
        
        return answer;
    }
}