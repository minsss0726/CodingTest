class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        int remove0_count = 0;
        int count = 0;
        while(!"1".equals(s)) {
            String remove0_s = s.replaceAll("0","");
            remove0_count += s.length() - remove0_s.length();
            s = Integer.toBinaryString(remove0_s.length());
            count++;
        }
        answer[0] = count;
        answer[1] = remove0_count;
        return answer;
    }
}