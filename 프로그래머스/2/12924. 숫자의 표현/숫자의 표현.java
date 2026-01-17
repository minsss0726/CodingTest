class Solution {
    public int solution(int n) {
        int answer = 1;
        int min = 1;
        int add = 1;
        int sum = 0;
        
        while (min < n){
            if(sum < n) {
                sum += add++;
                // System.out.println(sum);
            } else if(sum > n) {
                sum -= min++;
                // System.out.println(sum);
            } else if (sum == n){
                answer++;
                // System.out.println("add : " + sum);
                sum += add++;
            }
        }
        
        return answer;
    }
}