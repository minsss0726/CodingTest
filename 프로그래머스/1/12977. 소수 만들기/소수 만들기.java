class Solution {
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