import java.util.*;
import java.util.stream.Collectors;

class Solution {
    List<List<Integer>> input_dir = Arrays.asList(Arrays.asList(1, 0),Arrays.asList(-1, 0),Arrays.asList(0, -1),Arrays.asList(0, 1));
    List<List<Integer>> s_dir = Arrays.asList(Arrays.asList(1, 0),Arrays.asList(-1, 0),Arrays.asList(0, -1),Arrays.asList(0, 1));
    List<List<Integer>> l_dir = Arrays.asList(Arrays.asList(0, 1),Arrays.asList(0, -1),Arrays.asList(1, 0),Arrays.asList(-1, 0));
    List<List<Integer>> r_dir = Arrays.asList(Arrays.asList(0, -1),Arrays.asList(0, 1),Arrays.asList(-1, 0),Arrays.asList(1, 0));
    
    public int[] solution(String[] grid) {
        int[] answer = {};
        int[] first_dir = {0,0};
        int[] move_dir = {1,0};
        int[] pos = {0,0};
        int[] start_pos = {0,0};
        int length = 0;
        int dx = 0;
        int dy = 0;
        boolean[][][] pos_cycle = new boolean[grid.length][grid[0].length()][4];
        
        ArrayList<Integer> list = new ArrayList<>();
        
    
        for ( int j = 0; j < grid.length ; j++){
            for (int k = 0 ; k < grid[0].length() ; k++){
                pos[0] = j;
                pos[1] = k;
                start_pos[0] = j;
                start_pos[1] = k;
                //System.out.println(Arrays.toString(start_pos));
                
                for ( int x = 0; x < 4 ; x++ ){
                    if (!(pos_cycle[pos[0]][pos[1]][x])){
                        move_dir = input_dir.get(x).stream().mapToInt(Integer::intValue).toArray();
                        length = 0;
                        pos[0] = j;
                        pos[1] = k;
                        while (!(Arrays.equals(pos,start_pos) && Arrays.equals(first_dir,move_dir))) {
                            pos_cycle[pos[0]][pos[1]][input_dir.indexOf(Arrays.stream(move_dir).boxed().collect(Collectors.toList()))] = true;
                            first_dir = input_dir.get(x).stream().mapToInt(Integer::intValue).toArray();
                            //System.out.println(Arrays.toString(move_dir) + "  " + Arrays.toString(pos) + grid[pos[0]].charAt(pos[1]) + "  " +Arrays.toString(pos_cycle[pos[0]][pos[1]]));
                            dx = move_dir[0];
                            dy = move_dir[1];
                            if ( (pos[0] + dx < grid.length) && (pos[0] + dx >= 0) ) {
                                pos[0] = pos[0] + dx;
                            } else {
                                pos[0] = (pos[0] + dx < 0) ? (grid.length - 1) : 0;
                            }
                            if ( (pos[1] + dy < grid[0].length() ) && ( pos[1] + dy >= 0) ) {
                                pos[1] = pos[1] + dy;
                            } else {
                                pos[1] = (pos[1] + dy < 0) ? (grid[0].length() - 1) : 0;
                            }
                            
                            if ( grid[pos[0]].charAt(pos[1]) == 'S') {
                                move_dir = s_dir.get(input_dir.indexOf(Arrays.stream(move_dir).boxed().collect(Collectors.toList()))).stream().mapToInt(Integer::intValue).toArray();
                            }
                            if ( grid[pos[0]].charAt(pos[1]) == 'L') {
                                move_dir = l_dir.get(input_dir.indexOf(Arrays.stream(move_dir).boxed().collect(Collectors.toList()))).stream().mapToInt(Integer::intValue).toArray();
                            }
                            if ( grid[pos[0]].charAt(pos[1]) == 'R') {
                                move_dir = r_dir.get(input_dir.indexOf(Arrays.stream(move_dir).boxed().collect(Collectors.toList()))).stream().mapToInt(Integer::intValue).toArray();
                            }
                            length++;
                        }
                        if (length > 0) list.add(length);
                        //System.out.println("Cycle end");
                    }
                }
            }
        }
        answer = list.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(answer);
        return answer;
    }
}