package lv3;

import java.util.LinkedList;

/**
 * @title 이중 우선순위 큐
 * @author 김민중
 * @see https://school.programmers.co.kr/learn/courses/30/lessons/42628
 * @category Heap
 */
public class DualPriorityQueue {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        LinkedList<Integer> stack = new LinkedList<>();
        
        for (String operation:operations){
            String[] op_split = operation.split(" ");
            int num = Integer.parseInt(op_split[1]);
            if (op_split[0].equals("I")) {
                stack.add(num);
                max = stack.stream().mapToInt(Integer::intValue).max().orElse(0);
                min = stack.stream().mapToInt(Integer::intValue).min().orElse(0);
                // System.out.println(stack);
                // System.out.println(min+" "+max);
            } else if ( stack.size() > 0 ){
                if (num == 1){
                    stack.remove(stack.indexOf(max));
                } else {
                    stack.remove(stack.indexOf(min));
                }
                max = stack.stream().mapToInt(Integer::intValue).max().orElse(0);
                min = stack.stream().mapToInt(Integer::intValue).min().orElse(0);
            }
        }
        
        if (stack.size () > 0){
            answer[0] = max;
            answer[1] = min;
        }
        
        return answer;
    }
}
