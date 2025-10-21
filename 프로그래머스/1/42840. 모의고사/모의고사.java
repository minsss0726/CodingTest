import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer = new int[3];
        int[] student1 = {1, 2, 3, 4, 5};
        int[] student2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] student3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        ArrayList<Integer> list = new ArrayList<>();
        
        int max = 0;
        
        for(int i = 0; i < answers.length; i++){
            if(answers[i] == student1[i%5]){
                answer[0]++;
                if (answer[0] > max) max = answer[0];
            }
            if(answers[i] == student2[i%8]){
                answer[1]++;
                if (answer[1] > max) max = answer[1];
            }
            if(answers[i] == student3[i%10]){
                answer[2]++;
                if (answer[2] > max) max = answer[2];
            }
        }
        
        for(int i = 0; i < 3; i++){
            if (answer[i]==max) list.add(i+1);
        }
        
        answer = list.stream().mapToInt(Integer::intValue).toArray();
        
        return answer;
    }
}