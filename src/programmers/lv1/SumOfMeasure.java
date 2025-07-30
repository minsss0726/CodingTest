package lv1;

/**
 * @title 약수의 합
 * @author 김민중
 * @see https://school.programmers.co.kr/learn/courses/30/lessons/12928
 * @category 연습문제
 */
public class SumOfMeasure {
    public int solution(int n) {
        int answer = 0;
        int sum = 0;
        
        for (int i =  1 ; i <= n ; i++){
            if (n % i == 0){
                sum += i;
            }
        }
        answer = sum;
        return answer;
    }
}
