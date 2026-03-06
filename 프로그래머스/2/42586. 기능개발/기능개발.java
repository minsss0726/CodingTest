import java.util.*;

class Solution {
    
    public int getWorkDay(int rest, int speed){
        int day = rest / speed;
        if (rest % speed > 0) day++;
        return day; 
    }
    
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        int[] days = new int[progresses.length];
        
        LinkedList<Integer> counts = new LinkedList<>();
        
        for (int i = 0; i < progresses.length; i++){
            int rest = 100 - progresses[i];
            days[i] = getWorkDay(rest,speeds[i]);
        }
        
        System.out.println(Arrays.toString(days));
        
        int index = 1;
        int count = 1;
        int now = 0;
        while (now < days.length){
            if (index < days.length  && days[now] >= days[index]){
                index++;
                count++;
            } else {
                counts.add(count);
                now = index;
                index++;
                count = 1;
            }
        }
        
        System.out.println(counts);
        
        answer = counts.stream().mapToInt(Integer::intValue).toArray();
        
        return answer;
    }
}