class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        
        int heal_time = 0;
        
        int[][] time_line = new int[attacks[attacks.length-1][0]+1][3];
        
        time_line[0][0] = health;
        
        for (int i = 1; i < time_line.length ; i++){
            for ( int j = 0 ; j < attacks.length ; j++ ) {
                if ( i == attacks[j][0] ) {
                    time_line[i][1] = attacks[j][0];
                    time_line[i][2] = attacks[j][1];
                }
            }
        }
        
        for ( int i = 1 ; i < time_line.length ; i++ ){
            time_line[i][0] = time_line[i-1][0];
            if ( time_line[i][1] != 0 ){
                time_line[i][0] -= time_line[i][2];
                heal_time = 0;
                if (time_line[i][0] <= 0) return -1;
            } else {
                time_line[i][0] += bandage[1];
                heal_time++;
                if (heal_time >= bandage[0]){
                    time_line[i][0] += bandage[2];
                    heal_time = 0;
                }
                if (time_line[i][0] > health) time_line[i][0] = health;
            }
            System.out.println(time_line[i][0]);
        }
        
        answer = time_line[time_line.length-1][0];
        
        return answer;
    }
}