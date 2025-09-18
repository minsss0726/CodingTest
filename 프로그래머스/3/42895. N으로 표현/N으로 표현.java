import java.util.*;

class Solution {
    public int solution(int N, int number) {
        int answer = -1;
        
        List<Set<Integer>> list = new ArrayList<Set<Integer>>();
        
        for (int i = 0 ; i <= 8; i++) {
            list.add(new HashSet<>());
        }
        
        for (int i = 1; i <= 8; i++){
            list.get(i).add(Integer.parseInt(String.valueOf(N).repeat(i)));
            
            for(int j = 1; j <= 8; j++){
                for ( int num1 : list.get(j)) {
                    for (int num2 : list.get(i-j)){
                        list.get(i).add(num1+num2);
                        list.get(i).add(num1-num2);
                        list.get(i).add(num1*num2);
                        
                        if(num1 != 0) list.get(i).add(num2/num1);
                        if(num2 != 0) list.get(i).add(num1/num2);
                    }
                }
            }
            System.out.println(list.get(i));
            if(list.get(i).contains(number)) return i;
        }
        
        return answer;
    }
}