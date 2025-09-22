class Solution {
    public int solution(int n) {
        int answer = 0;
        StringBuffer str1 = new StringBuffer();
        int count = 0;
        while ( n >= square3(count+1)){
            count++;
        }
        
        // System.out.println(count);
        

        while(count >= 0 && n > 0){
            // System.out.println(n);
            int threeCount = 0;
            // System.out.println("init"+threeCount);
            while( n - ( square3(count) * threeCount ) > 0 && threeCount < 3){
                threeCount++;
                // System.out.println(n - ( square3(count) * threeCount ));
            }
            if (n != (square3(count) * threeCount)) {
                threeCount--;
                // System.out.println("-1햇음");
            }
            // System.out.println(threeCount);
            if( threeCount > 0 ){
            n = n - (square3(count) * threeCount);
            str1.append(String.valueOf(threeCount));
            } else {
               str1.append(String.valueOf("0")); 
            }
            count--;
        }

        
        // System.out.println(str1);
        
        // for(int i = 0; i < str1.length(); i++){
        //     answer += square3(i) * Integer.parseInt(String.valueOf(str1.charAt(i)));
        //     // System.out.println(answer);
        // }
        
        
        return Integer.parseInt(str1.reverse().toString(),3);
    }
    
    public int square3(int count){
        int num = 1;
        if (count > 0){
            for ( int i = 1; i <=count; i++){
                num *= 3;
            }
        }
        
        return num;
    }
}