package lv2;

/**
 * @title 타겟넘버
 * @author 김민중
 * @see https://school.programmers.co.kr/learn/courses/30/lessons/43165
 * @category dfs
 */
public class TargetNumber {
    int count = 0;
    
    public int solution(int[] numbers, int target) {
        count = 0; // count 초기화 추가
        
        // DFS를 한 번만 호출하여 모든 경우의 수 탐색
        dfs(numbers, 0, 0, target);
        
        return count;
    }
    
    public void dfs(int[] numbers, int currentSum, int index, int target) {
        // 모든 숫자를 사용했을 때
        if (index == numbers.length) {
            if (currentSum == target) {
                count++;
            }
            return;
        }
        
        // 현재 숫자를 더하는 경우
        dfs(numbers, currentSum + numbers[index], index + 1, target);
        
        // 현재 숫자를 빼는 경우  
        dfs(numbers, currentSum - numbers[index], index + 1, target);
    }
}
