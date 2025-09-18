import java.util.Arrays;
class Solution {
    public int solution(int[] mats, String[][] park) {
        int answer = 0;
        Arrays.sort(mats);
        
        
        
        
        int able_area = 0;
        
        for (int mat:mats){
            
            for (int i = 0 ; i < park.length - mat + 1; i++ ){
                for (int j = 0 ; j < park[0].length - mat + 1; j++ ){
                    
                    for (int x = i ; x < i + mat ; x++){
                        for (int y = j ; y < j + mat ; y++){
                            if (park[x][y].equals("-1")){
                                
                                able_area++;
                            }
                        }
                    }
                    
                    if (able_area == mat * mat){
                        
                        answer = mat;
                    }
                    able_area = 0;
                   
                }
            }
            
            
            
        }
        
        if ( answer == 0) return -1;
        
        
        return answer;
    }
}