import java.util.*;
class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        int[] arr = new int[number];
        arr[0] = 1;
        
        for (int i = 1 ; i < number ; i++){
            arr[i] = countMeasure(i+1);
        }
        // System.out.println(Arrays.toString(arr));
        for (int measure:arr){
            if (measure > limit){
                answer += power;
            } else {
                answer += measure;
            }
        }
        
        return answer;
    }
    
    public int countMeasure(int number){
        Set<Integer> list = new HashSet<>();
        for (int i = 1; i <= number / 2; i++){
            if (number % i == 0){
                list.add(i);
                list.add(number/i);
            }
        }
        return list.size();
        
        
        // int count = 0;
        // for (int i = 1; i <= number ;i++){
        //     if( i > (number / 2)) break;
        //     if ( number % i == 0) {
        //         count++;
        //         if ( i != (number / i)) {
        //             count++;
        //         }
        //         System.out.print(i+" "+(number/i)+" ");
        //     }
        //     if((number/i) <= (number/2)) break;
        // }
        // System.out.println("");
        // return count;
    }
}