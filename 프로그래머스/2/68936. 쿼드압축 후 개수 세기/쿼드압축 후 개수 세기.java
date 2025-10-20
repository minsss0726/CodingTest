import java.util.*;

class Solution {
    
    int[][] arr1;
    ArrayList<Integer> nums = new ArrayList<>();
    
    int index0 = 2;
    int index1 = 3;
    
    public int[] solution(int[][] arr) {
        int[] answer = new int[2];
        int checkRange = arr.length;
        arr1 = Arrays.copyOf(arr, arr.length);
        
        Main: while(true){
            if(checkRange == 1){
                for(int i = 0; i< arr1.length; i++){
                    for (int j = 0; j<arr1.length; j++){
                        if(arr1[i][j] == 0) answer[0]++;
                        if(arr1[i][j] == 1) answer[1]++;
                    }
                }
                for(Integer num:nums){
                    if(num % 2 == 0) {
                        answer[0]++;
                    } else {
                        answer[1]++;
                    }
                }
                break Main; 
            }
            
            for(int i = 0; i < arr1.length; i += checkRange){
                for (int j = 0; j < arr1.length; j += checkRange){
                   if ( checkQuad(i,j,checkRange, arr1) == 1){
                       changeArr(i,j,checkRange,index1);
                       index1 += 2;
                   } else if ( checkQuad(i,j,checkRange, arr1) == 0){
                       changeArr(i,j,checkRange,index0);
                       index0 += 2;
                   }
                }
            }
            checkRange /= 2;
        }
        
        // System.out.println(nums);
        // for(int[] ar:arr1){
        //     System.out.println(Arrays.toString(ar));
        // }
        return answer;
    }
    
    public int checkQuad(int xStart, int yStart, int range, int[][] arr){
        if(arr[xStart][yStart] != 0 && arr[xStart][yStart] != 1) return -1;
        
        int checkNum = -1;
        for(int i = xStart; i < xStart + range; i++){
            for (int j = yStart; j < yStart + range; j++){
                if(checkNum == -1) {
                    checkNum = arr[i][j];
                    continue;
                }
                if(arr[i][j] != checkNum) return -1;
            }
        }
        return checkNum;
    }
    
    public void changeArr(int xStart, int yStart, int range, int changeNum){
        for(int i = xStart; i < xStart+range; i++){
            for(int j = yStart; j < yStart+range; j++){
                arr1[i][j] = changeNum;
            }
        }
        nums.add(changeNum);
    }
}