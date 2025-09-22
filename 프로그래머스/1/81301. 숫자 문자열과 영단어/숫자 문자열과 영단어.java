class Solution {
    public int solution(String s) {
        int answer = 0;
        String[] strs = {"zero","one","two","three",
                        "four","five","six","seven",
                        "eight","nine"};
        
        for(int i = 0 ; i <= 9 ;i++){
            s = s.replaceAll(strs[i], String.valueOf(i));
        }
        
        // System.out.println(s);
        return Integer.parseInt(s);
    }
}