package lv1;

/**
 * @title 다트 게임
 * @author 김민중
 * @see https://school.programmers.co.kr/learn/courses/30/lessons/17682
 * @category 2018 KAKAO BLIND RECRUITMENT, 구현
 */
public class DartGame {
    public int solution(String dartResult) {
        int answer = 0;
        dartResult += " ";
        
        String[][] each_dart = new String[3][3];
        
        for (int j = 0 ; j < 3; j++){
            for (int x = 0; x < 3; x++){
                each_dart[j][x] = "";
            }
        }
        
        int k = 0;
        
        for ( int i = 0; i < dartResult.length(); i++){
            if (( dartResult.charAt(i) >= 48 ) && ( dartResult.charAt(i)<= 57)){
                each_dart[k][0] = String.valueOf(dartResult.charAt(i));
                if (( dartResult.charAt(i+1) >= 48 ) && ( dartResult.charAt(i+1)<= 57)){
                    each_dart[k][0] += String.valueOf(dartResult.charAt(i+1));
                    if ( i < dartResult.length()  ) i++;
                }
            } else if (( dartResult.charAt(i) == 'S' ) || ( dartResult.charAt(i) == 'D') || ( dartResult.charAt(i) == 'T')){
                each_dart[k][1] = String.valueOf(dartResult.charAt(i));
                if (( dartResult.charAt(i+1) == '*' ) || ( dartResult.charAt(i+1)== '#')){
                    each_dart[k][2] = String.valueOf(dartResult.charAt(i+1));
                    if ( i < dartResult.length()  )i++;
                }
                if ( k < 2) k++;
            } 
            
        }
        
        for (int j = 0 ; j < 3; j++){
            for (int x = 0; x < 3; x++){
                System.out.print(each_dart[j][x]+ " ");
            }
            System.out.println();
        }
        
        int[] point = new int[3];
        String last_bonus = "";
        
        for (int i = 0 ; i < 3; i++){
            point[i] = Integer.parseInt(each_dart[i][0]);
            
            if (each_dart[i][1].equals("S")){
                point[i] = point[i];
            } else if (each_dart[i][1].equals("D")){
                point[i] = point[i]*point[i];
            } else if (each_dart[i][1].equals("T")){
                point[i] = point[i]*point[i]*point[i];
            }
            
            
            
            if ((each_dart[i][2].equals("*"))){
                point[i] *= 2;
                if (i >= 1) point[i-1] *=2;
                last_bonus = "*";
            } else if (each_dart[i][2].equals("#")){
                point[i] *= -1;
                last_bonus = "#";
            } else {
                last_bonus = "";
            }
            
            
        }
        
        for (int p:point){
            answer += p;
        }
        
        
        return answer;
    }
}
