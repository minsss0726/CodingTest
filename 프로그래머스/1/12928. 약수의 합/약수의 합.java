/***
1. n 의 절반값 + 1(홀수 참고)까지 1부터 나누었을때 나머지가 0이 되는지 판단
2. 나머지 0이면 나눈 값과 나눈 몫을 sum에 더 해준다 
***/

/*** 1차 오류
1. 약수의 중복값 발생
2. n까지 반복하고 나눈 값만 더하여 중복 삭제
***/

class Solution {
    public int solution(int n) {
        int answer = 0;
        int sum = 0;
        
        for (int i =  1 ; i <= n ; i++){
            if (n % i == 0){
                sum += i;
                // sum += (n/i);
                // System.out.println(i);
                // System.out.println(n/i);
            }
        }
        answer = sum;
        return answer;
    }
}