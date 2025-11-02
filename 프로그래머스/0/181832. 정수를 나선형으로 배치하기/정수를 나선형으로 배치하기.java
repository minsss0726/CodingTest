import java.util.*;

class Solution {
    int[][] answer;
    int minRow;
    int maxRow;
    int minCol;
    int maxCol;
    int num = 1;
    public int[][] solution(int n) {
        answer = new int[n][n];
        
        minRow = 0;
        maxRow = n-1;
        minCol = 0;
        maxCol = n-1;
        
        while(true){
            rigth();
            if(num > n * n ) break;
            down();
            if(num > n * n ) break;
            left();
            if(num > n * n ) break;
            up();
            if(num > n * n ) break;
        }
        
        return answer;
    }
    
    public void rigth(){
        for(int i = minRow; i <= maxRow; i++){
            answer[minCol][i] = num;
            num++;
        }
        minCol++;
        // printArray(answer);
    }
    public void down(){
        for(int i = minCol; i <= maxCol; i++){
            answer[i][maxRow] = num;
            num++;
        }
        maxRow--;
        // printArray(answer);
    }
    public void left(){
        for(int i = maxRow; i >= minRow; i--){
            answer[maxCol][i] = num;
            num++;
        }
        maxCol--;
        // printArray(answer);
    }
    public void up(){
        for(int i = maxCol; i >= minCol; i--){
            answer[i][minRow] = num;
            num++;
        }
        minRow++;
        // printArray(answer);
    }
    public void printArray(int[][] arr){
        for(int[] ar:arr){
            System.out.println(Arrays.toString(ar));
        }
        System.out.println("====");
    }
}