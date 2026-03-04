import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        int[] elements_x2 = new int[elements.length * 2];
        
        HashSet<Integer> sums = new HashSet<>();
        
        for(int i = 0; i < elements_x2.length; i++){
            if(i > (elements.length - 1) ){
                elements_x2[i] = elements[i - elements.length];
            } else {
                elements_x2[i] = elements[i];
            }
        }
        
        // System.out.println(Arrays.toString(elements_x2));
        
        for (int i = 1; i <= elements.length; i++){
            for(int j = 0; j < elements.length; j++){
                int sum = 0;
                for(int k = j; k < j + i; k++){
                    sum += elements_x2[k];
                }
                sums.add(sum);
            }
        }
        
        answer = sums.size();
        
        return answer;
    }
}