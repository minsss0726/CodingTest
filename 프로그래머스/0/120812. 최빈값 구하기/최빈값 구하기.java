class Solution {
    public int solution(int[] array) {
        int answer = 0;
        
        int now_count = 0;
        int max_count = Integer.MIN_VALUE;
        int com_count = Integer.MIN_VALUE;
        
        int k = -1;
        int x = -1;
        
        for (int i = 0; i < 1000 ; i++) {
            for (int j = 0; j < array.length ; j++){
                if ( array[j] == i) {
                    now_count++;
                }
            }
            if ( now_count > max_count){
                max_count = now_count;
                k = i;
            }
            now_count = 0;
        }
        
        for (int i = 0; i < 1000 ; i++) {
            for (int j = 0; j < array.length ; j++){
                if ( (array[j] == i) && (i != k) ) {
                    now_count++;
                }
            }
            if ( now_count > com_count ){
                com_count = now_count;
                x = i;
            }
            now_count = 0;
        }
        
        System.out.println(max_count+" "+k);
        System.out.println(com_count+" "+x);
        
        if (max_count == com_count) return -1;
        
        
        return k;
    }
}