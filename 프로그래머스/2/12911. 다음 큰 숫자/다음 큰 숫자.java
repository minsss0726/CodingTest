class Solution {
    public int solution(int n) {
        int answer = 0;
        String nBinary = Integer.toBinaryString(n);
        int nCount1 = nBinary.length() - nBinary.replace("1","").length();
        answer = n + 1;
        while (true) {
            String answerBinary = Integer.toBinaryString(answer);
            int answerCount1 = answerBinary.length() - answerBinary.replace("1","").length();
            if (nCount1 == answerCount1){
                break;
            }
            answer++;
        }
        return answer;
    }
}