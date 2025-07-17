package lv1;

import java.util.Arrays;

/**
 * @title 공원 산책
 * @author 김민중
 * @see https://school.programmers.co.kr/learn/courses/30/lessons/172928
 * @category 연습문제
 */
public class WalkInPark {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = {0,0};
        
        int[] now_pos = { -1 , -1 };
        
        boolean move = true;
        
        for ( int i = 0 ; i < park.length ; i++){
            if ( park[i].indexOf("S") >= 0) {
                now_pos[0] = i;
                now_pos[1] = park[i].indexOf("S");
                break;
            }
        }
        //System.out.println(Arrays.toString(now_pos));
        
        for (String route:routes){
            String[] route_split = route.split(" ");
            move = true;
            switch (route_split[0].charAt(0)) {
                case 'E':
                    System.out.println("E");
                    if ( (now_pos[1] + Integer.parseInt(route_split[1])) < park[0].length() ){
                        Run : for ( int i = 1 ; i <= Integer.parseInt(route_split[1]) ; i++) {
                            if ( park[now_pos[0]].charAt(now_pos[1] + i) == 'O'){
                                continue Run;
                            } else if ( park[now_pos[0]].charAt(now_pos[1] + i) == 'X'){
                                System.out.println("Not move");
                                move = false;
                                break Run;
                            }
                        }
                        if (move == true){
                            now_pos[1] += Integer.parseInt(route_split[1]);
                            System.out.println("Move" + Arrays.toString(route_split));
                        }
                    } else {
                        System.out.println("Not move");
                    }
                    break;
                case 'W':
                    System.out.println("W");
                    if ( (now_pos[1] - Integer.parseInt(route_split[1])) >= 0 ){
                        Run : for ( int i = 1 ; i <= Integer.parseInt(route_split[1]) ; i++) {
                            if ( park[now_pos[0]].charAt(now_pos[1] - i) == 'O') {
                                continue Run;
                            } else if ( park[now_pos[0]].charAt(now_pos[1] - i) == 'X'){
                                System.out.println("Not move");
                                move = false;
                                break Run;
                            }
                        }
                        if ( move == true) {
                            now_pos[1] -= Integer.parseInt(route_split[1]);
                            System.out.println("Move" + Arrays.toString(route_split));
                        }
                    } else {
                        System.out.println("Not move");
                    }
                    break;
                case 'N':
                    System.out.println("N");
                    if ( (now_pos[0] - Integer.parseInt(route_split[1])) >= 0 ){
                        Run : for ( int i = 1 ; i <= Integer.parseInt(route_split[1]) ; i++) {
                            if ( park[now_pos[0] - i].charAt(now_pos[1]) == 'O'){
                                continue Run;
                            } else if ( park[now_pos[0] - i].charAt(now_pos[1]) == 'X'){
                                System.out.println("Not move");
                                move = false;
                                break Run;
                            }
                        }
                        if ( move == true ) {
                            now_pos[0] -= Integer.parseInt(route_split[1]);
                            System.out.println("Move" + Arrays.toString(route_split));
                        }
                    } else {
                        System.out.println("Not move");
                    }
                    break;
                case 'S':
                    System.out.println("S");
                    if ( (now_pos[0] + Integer.parseInt(route_split[1])) < park.length ){
                        Run : for ( int i = 1 ; i <= Integer.parseInt(route_split[1]) ; i++) {
                            if ( park[now_pos[0]+i].charAt(now_pos[1]) == 'O'){
                                continue Run;
                            } else if ( park[now_pos[0]+i].charAt(now_pos[1]) == 'X'){
                                System.out.println("Not move");
                                move = false;
                                break Run;
                            }
                        }
                        if ( move == true) {
                            now_pos[0] += Integer.parseInt(route_split[1]);
                            System.out.println("Move" + Arrays.toString(route_split));
                        }
                    } else {
                        System.out.println("Not move");
                    }
                    break;
            }
            //System.out.println(Arrays.toString(now_pos));
        }
        
        System.out.println(Arrays.toString(now_pos));
        
        answer[0] = now_pos[0];
        answer[1] = now_pos[1];
        
        return answer;
    }
}
