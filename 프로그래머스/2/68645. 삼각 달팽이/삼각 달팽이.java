import java.util.*;

class Solution {
    public int[] solution(int n) {
        int[] answer = {};
        int len = 0;
        ArrayList<int[]> lists = new ArrayList<>();
        for (int i = 1; i <= n; i++){
            len += i;
            lists.add(new int[i]);
        }
        answer = new int[len];
        
        String dirc = "d"; //"u","r"
        int index = 0;
        int minI = 0;
        int maxI = n - 1;
        int minH = 0;
        int maxH = n - 1;
        
        int i = 1;
        while(true){
            if("d".equals(dirc)){
                for(int j = minH; j <= maxH; j++){
                    lists.get(j)[minI] = i;
                    i++;
                }
                minI++;
                minH++;
                dirc = "r";
            } else if("u".equals(dirc)){
                index = maxI;
                for(int j = maxH; j >= minH; j--){
                    lists.get(j)[index] = i;
                    index--;
                    i++;
                }
                maxI--;
                minH++;
                dirc = "d";
            } else if("r".equals(dirc)){
                for(int j = minI; j <= maxI; j++){
                    lists.get(maxH)[j] = i;
                    i++;
                }
                maxH--;
                maxI--;
                dirc = "u";
            }
            if( i > len) break;
        }
        
        // lists.stream().forEach(e->System.out.println(Arrays.toString(e)));
        
        int i1 = 0;
        for(int[] list:lists){
            for(int num:list){
                answer[i1] = num;
                i1++;
            }
        }
        return answer;
    }
}