class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = { 0 , sequence.length - 1};
        int start = 0;
        int end = 0;
        int sum = 0;
        int length = sequence.length;
        sum += sequence[0];
        while(true){
        
            if(sum < k){
                end++;
                if(end >= length) break;
                sum += sequence[end];
            } else if ( sum > k){
                sum -= sequence[start];
                start++;
            } else if(sum == k){
                if ( answer[1] - answer[0] > end - start 
                    || (answer[1] - answer[0] == end - start 
                    && start < answer[0] )) {
                    answer[0] = start;
                    answer[1] = end;
                }
                sum -= sequence[start];
                start++;
            }
        }
        return answer;
    }
}