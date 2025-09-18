class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int line = (brown - 4) / 2;
        for (int i = 1; i <= line; i++){
            if (i * (line-i) == yellow){
                answer[0] = Math.max(i,line-i) + 2;
                answer[1] = Math.min(i,line-i) + 2;
                break;
            }
        }
        return answer;
    }
}