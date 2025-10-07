import java.util.*;

class Solution {
    
    int[][] rooms;
    
    public int solution(String[][] book_time) {
        int answer = 0;
        rooms = new int[book_time.length][2360];
        int[][] books = new int[book_time.length][2];
        
        for (int i = 0 ; i < book_time.length; i++){
            int start = Integer.parseInt(book_time[i][0].replace(":",""));
            int end = Integer.parseInt(book_time[i][1].replace(":","")) + 10;
            if (end % 100 >= 60){
                end += 100;
                end -= 60;
                if (end > 2359) end = 2359;
            }
            books[i][0] = start;
            books[i][1] = end;
        }
        
        Arrays.sort(books,(a,b) -> {
            return a[1] - b[1];
        });
        Arrays.sort(books,(a,b) -> {
            return a[0] - b[0];
        });
        
        // Arrays.stream(books).forEach(e->System.out.println(Arrays.toString(e)));
        
        for(int[] book:books){
            int index = 0;
            
            while(!checkRoomEmpty(index, book[0], book[1])){
                index++;
            }
            
            // System.out.println(index);
            
            if(index > answer) answer = index;
            
            for(int i = book[0]; i < book[1] ; i++){
                rooms[index][i] = 1;
            }
        }
        
        return answer + 1;
    }
    
    public boolean checkRoomEmpty(int index, int start, int end){
        for (int i = start; i < end; i++){
            if(rooms[index][i] != 0){
                return false;
            }
        }    
        return true;
    }
}