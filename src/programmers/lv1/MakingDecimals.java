package lv1;

/**
 * @title 소수 만들기
 * @author 김민중
 * @see https://school.programmers.co.kr/learn/courses/30/lessons/12977
 * @category Summer/Winter Coding(~2018), 완전탐색
 */
public class MakingDecimals {
    public int solution(int[] nums) {
        int answer = 0;
        int cnt = nums.length;

        for (int i=0; i<cnt; ++i) {
            for (int k=i+1; k<cnt; ++k) {
                Run: for (int j=k+1; j<cnt; ++j) {
                    System.out.println(nums[i] + " " + nums[k] + " " + nums[j]);
                    int sum = nums[i] + nums[k] + nums[j];
                    for (int x = 2; x < sum; x++){
                        if (sum % x == 0){
                            continue Run;
                        }
                    }
                    answer++;
                }
            }
        }

        return answer;
    }
}
