class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for ( int  y = 0 ; y < commands.length ; y++ ){
            
            int[] cut_array = new int[commands[y][1] - commands[y][0] + 1];
            int[] line_array = new int[commands[y][1] - commands[y][0] + 1];
            
            for (int i = 0 ; i < cut_array.length ; i++) {
                cut_array[i] = array[i + commands[y][0] - 1];
            }
            
            for (int g:cut_array){
                System.out.print(g);
            }
            System.out.println();
            
            int min = Integer.MAX_VALUE;
            int for_i = 0;
                        
            for (int j = 0 ; j < line_array.length ; j++ ){
                for (int i = 0 ; i < cut_array.length ; i++){
                    if ( cut_array[i] < min){
                        min = cut_array[i];
                        for_i = i;
                    }
                }
                cut_array[for_i] = 200;
                line_array[j] = min;
                min = Integer.MAX_VALUE;       
            }
            answer[y] = line_array[commands[y][2] - 1];
        }
        
        return answer;
    }
}