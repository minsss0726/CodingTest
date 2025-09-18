class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        
        int most_right = 0;
        int most_left = 0;
        int most_high = 0;
        int most_low = 0;
        
        Right : for (int i = 0; i < wallpaper[0].length(); i++){
            for(int j = 0; j < wallpaper.length ; j++ ){
                if ( String.valueOf(wallpaper[j].charAt(i)).equals("#") ) {
                    most_right = i;
                    break Right;
                } 
            }
        }
        
        Left : for (int i = wallpaper[0].length() - 1; i >= 0; i--){
            for(int j = 0; j < wallpaper.length ; j++ ){
                if ( String.valueOf(wallpaper[j].charAt(i)).equals("#") ) {
                    most_left = i+1;
                    break Left;
                } 
            }
        }
        
        High : for (int i = 0; i < wallpaper.length; i++){
            if (wallpaper[i].contains("#")){
                most_high = i;
                break High;
            }
        }
        
        Low : for (int i = wallpaper.length -1 ; i >=0 ; i--){
            if (wallpaper[i].contains("#")){
                most_low = i+1;
                break Low;
            }
        }
        
        answer[0] = most_high;
        answer[1] = most_right;
        answer[2] = most_low;
        answer[3] = most_left;
        
        return answer;
    }
}