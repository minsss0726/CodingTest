import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        
        /*Map<String, Integer> list1 = new HashMap<>();
        Map<String, Integer> list2 = new HashMap<>();
        
        for(String str : participant) {
            list1.put(str, (list1.getOrDefault(str, 0)+1) ); 
        }
        for(String str : completion) {
            list2.put(str, (list2.getOrDefault(str, 0)+1) ); 
        }
        
        
        for (String str : participant ){
            if ( list1.get(str) != list2.getOrDefault(str, 0) ) {
                answer = str;
            }
        }*/
        
        Arrays.sort(participant);
        Arrays.sort(completion);
        
        LinkedList<String> list1 = new LinkedList<>();
        LinkedList<String> list2 = new LinkedList<>();
                
        for(String str : participant) {
            list1.add(str ); 
        }
        for(String str : completion) {
            list2.add(str ); 
        }
        
        // System.out.println(list1);
        // System.out.println(list2);
        
        while (list2.size() > 0){
            answer = list1.poll();
            String com_string = list2.poll();
            if (!(answer.equals(com_string))) {
                break;
            } else if (list1.size() == 1){
                answer = list1.poll();
                break;
            }
        }
        if (answer.equals("")) {
            answer = list1.poll();
        }
        
        return answer;
    }
}