package codetest.shinhan;

public class ShareAndRemainder {
    public static void main(String[] args) {
    
        int answer = 0;

        int n = 3;
        
        int i = 1;

        while(i / n < n){
            if ( i / n == i % n ){
                answer += i;
            }
            i++;
        }

        System.out.println(answer);

    }

}
