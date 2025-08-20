package lv1;

/**
 * @title 콜라츠 추측
 * @author 김민중
 * @see https://school.programmers.co.kr/learn/courses/30/lessons/12943
 * @category 연습문제
 */
public class ColatzGuess {
    public int solution(int num) {
        int answer = 0;
        int count = 0;
        
        while(num != 1 && count <= 500){
            if (num % 2 == 0){
                num /= 2;
            } else {
                num *= 3;
                num += 1;
            }
            System.out.println(num);
            count++;
        }
        
        return (count <= 500 ? count : -1);
    }
}
