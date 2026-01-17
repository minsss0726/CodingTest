import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int i:tangerine){
            if(map.containsKey(i)){
                map.replace(i,map.get(i) + 1);
            } else {
                map.put(i,1);
            }
        }
        
        // System.out.println(map);
        
        int[] count = new int[map.size()];
        
        int index = 0;
        for(int i:map.values()){
            count[index++] = i;
        }
        
        // System.out.println(Arrays.toString(count));
        
        Arrays.sort(count);
        
        int size = map.size()-1;
        int sum = 0;
        
        while (sum < k){
            sum += count[size--];
            answer++;
        }
        
        return answer;
    }
}