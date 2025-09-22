class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int convert = 0;
        
        for (int i = 1 ; i <= n ; i++ ){
            convert++;
            
            while ( isGetThree(convert) || isMultiThree(convert) )  {
                convert++;
            } 
            // System.out.println(i+"  "+convert);
        }

        answer = convert;
        
        return answer;
    }
    
    public boolean isGetThree(int convert) {
        
        while (convert > 0){
            if ( convert % 10 == 3){
                return true;
            }
            convert /= 10;
        }
        
        return false;
    }
    
    public boolean isMultiThree(int convert) {
        if (convert % 3 == 0){
            return true;
        }
       
        return false;
    }
}

