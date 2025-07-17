package lv2;

/**
 * @title 2 x n 타일링
 * @author 김민중
 * @see https://school.programmers.co.kr/learn/courses/30/lessons/12900
 * @category 연습문제, 수학
 */
public class Tiling2xN {
    public int solution(int n) {
        int answer = 1;
        int count = 0;
        int length1 = n;
        int length2 = 0;
        
        if ( n > 1 ){
            while ( length1 >= 0){
                count += factorial(n) / (factorial(length1) * factorial(length2));
                length1 -= 2;
                length2 += 1;
                n--;
            }
        } else {
            return 1;
        }
        
        answer = count;
        
        return answer;
    }
    
    public static long factorial(int n) {
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
            result %= 1000000007;
        }
        return result;
    }
}