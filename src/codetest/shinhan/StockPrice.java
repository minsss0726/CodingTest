package codetest.shinhan;

import java.util.*;

public class StockPrice {

    List<Integer> result1 = new ArrayList<>();
    public int solution(int[] prices) {
        int answer = 0;

        List<int[]> list = new ArrayList<>();
        List<int[]> list2 = new ArrayList<>();
        // List<Integer> result1 = new ArrayList<>();

        for (int i = 0; i < prices.length; i++){
            for (int j = i + 1; j < prices.length; j++){
                for (int k = j + 1; k < prices.length; k++){
                    for (int l = k + 1; l < prices.length; l++){
                        int[] arr = {prices[i], prices[j], prices[k], prices[l]};
                        System.out.println(Arrays.toString(arr));
                        list.add(arr);
                    }
                }
            }
        }

        for (int[] arr: list){
            // System.out.println(Arrays.toString(arr));
            result1.add((-arr[0] + arr[3]) + (-arr[1] + arr[2]));
            result1.add((-arr[0] + arr[1]) + (-arr[2] + arr[3]));
            result1.add((-arr[0] + arr[2]) + (-arr[1] + arr[3]));
        }

        for (int i = 0; i < prices.length; i++){
            for (int j = i + 1; j < prices.length; j++){
                int[] arr = {prices[i], prices[j]};
                list2.add(arr);
            }
        }

        for (int[] arr: list2){
            // System.out.println(Arrays.toString(arr));
            result1.add((-arr[0] + arr[1]));
        }

        answer = result1.stream().mapToInt(Integer::intValue).max().getAsInt();

        if(answer < 0){
            answer = 0;
        }

        // System.out.println(result1);
        return answer;
    }  

}
