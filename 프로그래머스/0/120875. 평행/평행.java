class Solution {
    public int solution(int[][] dots) {
        int answer = 0;
    
        double[] incl1 = {0.0,0.0}; // dot1-dot2/dot3-dot4
        double[] incl2 = {0.0,0.0}; // dot1-dot3/dot2-dot4
        double[] incl3 = {0.0,0.0}; // dot1-dot4/dot2-dot3
    
            
       if ((dots[0][0]-dots[1][0] == 0) || (dots[0][1]-dots[1][1] == 0) ||
           (dots[2][0]-dots[3][0] == 0) || (dots[2][1]-dots[3][1] == 0))
       {
           
       } else {
           incl1[0] = (double)(dots[0][1]-dots[1][1]) / (double)(dots[0][0]-dots[1][0]);
           incl1[1] = (double)(dots[2][1]-dots[3][1]) / (double)(dots[2][0]-dots[3][0]);
           if ((incl1[0] == incl1[1]) && (incl1[0] != 0.0)) return 1;
       }
       
        
        
        if ((dots[0][0]-dots[2][0] == 0) || (dots[0][1]-dots[2][1] == 0) ||
           (dots[1][0]-dots[3][0] == 0) || (dots[1][1]-dots[3][1] == 0))
       {
           
       } else {
           incl2[0] = (double)(dots[0][1]-dots[2][1]) / (double)(dots[0][0]-dots[2][0]);
           incl2[1] = (double)(dots[1][1]-dots[3][1]) / (double)(dots[1][0]-dots[3][0]);
           if ((incl2[0] == incl2[1]) && (incl2[0] != 0.0)) return 1;
       }
        
        
        
        if ((dots[0][0]-dots[3][0] == 0) || (dots[0][1]-dots[3][1] == 0) ||
           (dots[1][0]-dots[2][0] == 0) || (dots[1][1]-dots[2][1] == 0))
       {
           
       } else {
           incl1[0] = (double)(dots[0][1]-dots[3][1]) / (double)(dots[0][0]-dots[3][0]);
           incl1[1] = (double)(dots[1][1]-dots[2][1]) / (double)(dots[1][0]-dots[2][0]);
           if ((incl3[0] == incl3[1]) && (incl3[0] != 0.0)) return 1;
       }
        
        
    return 0;
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        /*double[] inclination = new double[6];
        
        int k = 0;
        
        double in_x = 0.0;
        double in_y = 0.0;
        
        while (k < 6){
            for (int j = 0; j < 3; j++){  
                for ( int i = j ; i < 3; i ++){
                    if  ( (dots[j][1] - dots[i+1][1] == 0) || (dots[j][0] - dots[i+1][0] == 0) ) {
                        inclination[k] = 0.0;
                    } else { inclination[k] = (double)(dots[j][1] - dots[i+1][1]) / (double)(dots[j][0] - dots[i+1][0]); }
                    
                    System.out.println(inclination[k]);
                    k++;
                }
            }
        }
        
        for (int i = 0; i < 5; i++){
            for (int j =i+1; j<6; j++){
                if ((inclination[i] == inclination[j]) && (inclination[i] != 0.0)) {
                    System.out.println(inclination[i]); return 1;}
            }
        }*/
        
        
        
    }
}