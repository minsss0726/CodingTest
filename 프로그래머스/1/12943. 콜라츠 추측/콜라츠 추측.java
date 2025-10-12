class Solution {
    public int solution(int num) {
        int answer = 0;
        int count = 0;
        long num1 = (long) num;
        
        while(num1 != 1 && count <= 500){
            if (num1 % 2 == 0){
                num1 /= 2;
            } else {
                num1 *= 3;
                num1 += 1;
            }
            // System.out.println(num + " " + count);
            count++;
        }
        
        return (count <= 500 ? count : -1);
    }
}