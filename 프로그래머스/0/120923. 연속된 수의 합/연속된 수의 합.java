class Solution {
    public int[] solution(int num, int total) {
        int[] answer = new int[num];
        if (num ==  1 ) {
            answer[0] = total;
            return answer;
        }
        
        
        
        int test = total+num;
        Run : while(true){
            int check = 0;
            for (int i = test ; i > test-num; i--){
                check += i;
            }
            if ( check == total) {
                int count = 0;
                for (int i = test-num +1 ; i <= test; i++){
                    answer[count] = i;
                    count++;
                }
                break Run;
            }
            test--;
        }
        
        
        
        return answer;
    }
}