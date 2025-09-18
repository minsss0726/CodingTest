class Solution {
    int count = 0;
    
    public int solution(int[] numbers, int target) {
        int answer = 0;
        
        dfs(numbers, 0 , 0 , target, "+");
        
        dfs(numbers, 0 , 0 , target, "-");
        // System.out.println("all count: " + count);
        answer = count;
        return answer;
    }
    
    public void dfs(int[] numbers, int now, int index, int target, String sign){
        if( index == numbers.length - 1){
            if ("+".equals(sign) && (target == now + numbers[index])){
                // System.out.println("\n dfs count: " + count);
                count++;
                return;
            }  else if ("-".equals(sign) && target == now - numbers[index]){
                count++;
                return;
            } else {
                // System.out.println("sign :" + sign);
            }
            return;
        }
        
        if ( "+".equals(sign)){
            dfs(numbers, now + numbers[index] , index + 1, target, "+");
            dfs(numbers, now + numbers[index] , index + 1, target, "-");
        } else {
            dfs(numbers, now - numbers[index] , index + 1, target, "+");
            dfs(numbers, now - numbers[index] , index + 1, target, "-");
        }
        
    }
}