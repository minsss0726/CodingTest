class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        while (n >= a){
            int give = a * (n / a);
            n -= give;
            n += b*(give/a);
            answer += b*(give/a);
        }
        return answer;
    }
}