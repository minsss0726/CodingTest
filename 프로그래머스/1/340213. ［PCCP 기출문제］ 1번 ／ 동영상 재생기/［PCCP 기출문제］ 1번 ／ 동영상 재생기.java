class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        
        String[] video_len_ms = video_len.split(":");
        String[] pos_ms = pos.split(":");
        String[] op_start_ms = op_start.split(":");
        String[] op_end_ms = op_end.split(":");
        
        int video_s = Integer.parseInt(video_len_ms[0]) * 60 + Integer.parseInt(video_len_ms[1]);
        int pos_s = Integer.parseInt(pos_ms[0]) * 60 + Integer.parseInt(pos_ms[1]);
        int ops_s = Integer.parseInt(op_start_ms[0]) * 60 + Integer.parseInt(op_start_ms[1]);
        int ope_s = Integer.parseInt(op_end_ms[0]) * 60 + Integer.parseInt(op_end_ms[1]);
        
        for (String command:commands){
            if ( command.equals("next")){
                
                if ((pos_s >= ops_s) && (pos_s <= ope_s)){
                    pos_s = ope_s;
                }
                
                pos_s += 10;
                
                if ((pos_s >= ops_s) && (pos_s <= ope_s)){
                    pos_s = ope_s;
                }
                
                if (pos_s > video_s) pos_s = video_s;
                
            } else if ( command.equals("prev")){
                if ((pos_s >= ops_s) && (pos_s <= ope_s)){
                    pos_s = ope_s;
                }
                pos_s -= 10;
                if ((pos_s >= ops_s) && (pos_s <= ope_s)){
                    pos_s = ope_s;
                }
                if ( pos_s < 0 ) pos_s = 0;
            }
        }
        System.out.println(pos_s);
        
        String answer_m = String.valueOf(pos_s / 60);
        String answer_s = String.valueOf(pos_s % 60);
        
        if (answer_m.length() < 2 ) answer_m = "0" + answer_m;
        if (answer_s.length() < 2 ) answer_s = "0" + answer_s;
        
        return answer_m+":"+answer_s;
    }
}