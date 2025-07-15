package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @title 방금그곡
 * @author 김민중
 * @see https://school.programmers.co.kr/learn/courses/30/lessons/17683
 * @category 2018 KAKAO BLIND RECRUITMENT, 구현, 문자열 처리
 */
public class ThatSongJustNow {
    //C, C#, D, D#, E, F, F#, G, G#, A, A#, B , B# , E#
    // A# = H , B# = I , C# = J , D# = K , E# = L , F# = N , G# = M
    public String solution(String m, String[] musicinfos) {
        String answer = "";
        m = convert(m);
        List<String[]> list = new ArrayList<>();
        
        for(String musicinfo:musicinfos){
            String[] s_musicinfo = musicinfo.split(",");
            s_musicinfo[3] = convert(s_musicinfo[3]);
            String[] start = s_musicinfo[0].split(":");
            String[] end = s_musicinfo[1].split(":");
            int music_length = getLength(start,end);
            
            if (s_musicinfo[3].length() < music_length){
                String add = s_musicinfo[3];
                while(s_musicinfo[3].length() < music_length){
                    s_musicinfo[3] += add;
                }
                if ( s_musicinfo[3].length() > music_length){
                    s_musicinfo[3] = s_musicinfo[3].substring(0,music_length);
                }
            } else if (s_musicinfo[3].length() > music_length) {
                s_musicinfo[3] = s_musicinfo[3].substring(0,music_length);
            }
            
            if ( m.length() <= s_musicinfo[3].length() && s_musicinfo[3].contains(m)){
                list.add(s_musicinfo);
            } 
        }
        
        //list.stream().forEach(e->System.out.println(Arrays.toString(e)));
        
        if( list.size() == 1){
            return list.get(0)[2];
        } else if (list.size() > 1){
            List<int[]> lengths = new ArrayList<>();
            for ( int i = 0 ; i < list.size() ; i++ ){
                String[] music = list.get(i);
                lengths.add(new int[]{getLength(music[0].split(":"),music[1].split(":")), getTime(music[1])});
            }
            // lengths.stream().forEach(e->System.out.println(Arrays.toString(e)));
            
            List<int[]> lengths_org = new ArrayList<>(lengths);
            
            lengths.sort((a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0]; // 첫 번째 요소 내림차순
                return b[1] - a[1]; // 두 번째 요소 내림차순
            });
            // lengths.stream().forEach(e->System.out.println(Arrays.toString(e)));
            
            int[] answer_array = lengths.get(lengths.size()-1);
            // System.out.println(Arrays.toString(answer_array));
            
            int index = -1;
            for (int i = 0; i < lengths_org.size(); i++) {
                if (Arrays.equals(lengths_org.get(i), answer_array)) {
                    index = i;
                    // System.out.println(index);
                    break;
                }
            }
            return list.get(index)[2];
        }
        
        return "(None)";
    }
    
    public int getLength(String[] start, String[] end){
        int[] start_time = { Integer.parseInt(start[0]), Integer.parseInt(start[1]) };
        int[] end_time = { Integer.parseInt(end[0]), Integer.parseInt(end[1]) };
        
        return (end_time[0]*60 + end_time[1]) - (start_time[0]*60 + start_time[1]);
    }
    
    public int getTime(String start){
        String[] s_start = start.split(":");
        int[] start_time = { Integer.parseInt(s_start[0]), Integer.parseInt(s_start[1]) };
        
        return (start_time[0]*60 + start_time[1]);
    }
    
    //C, C#, D, D#, E, F, F#, G, G#, A, A#, B , B# , E#
    // A# = H , B# = I , C# = J , D# = K , E# = L , F# = N , G# = M
    public String convert(String str){
        str = str.replace("A#","H");
        str = str.replace("B#","I");
        str = str.replace("C#","J");
        str = str.replace("D#","K");
        str = str.replace("E#","L");
        str = str.replace("F#","M");
        str = str.replace("G#","N");
        return str;
    }
}
