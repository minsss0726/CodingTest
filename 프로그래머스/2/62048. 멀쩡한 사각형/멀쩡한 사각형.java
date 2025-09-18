class Solution {
    public long solution(int w, int h) {
        long answer = (long)w * h;
        return answer - (w + h - gcd(w,h));
    }
    
    static long gcd(long x, long y) {
        if (y == 0) {
            return x;
        } else {
            return gcd(y, x % y);
        }
    }
}