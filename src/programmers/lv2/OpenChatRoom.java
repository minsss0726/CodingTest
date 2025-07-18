package lv2;

import java.util.HashMap;

/**
 * @title 오픈채팅방
 * @author 김민중
 * @see https://school.programmers.co.kr/learn/courses/30/lessons/42888
 * @category 2019 KAKAO BLIND RECRUITMENT, 구현, MAP
 */
public class OpenChatRoom {
    public String[] solution(String[] record) {
        String[] answer = {};
        HashMap<String,String> user = new HashMap<>();
        int count = 0;
        
        for (String rec:record){
            String[] s_rec = rec.split(" ");
            if(s_rec[0].equals("Enter")) {
                if (user.containsKey(s_rec[1])){
                    user.replace(s_rec[1],s_rec[2]);
                } else {
                    user.put(s_rec[1],s_rec[2]);
                }
                count++;
            } else if (s_rec[0].equals("Leave")){
                count++;
            } else {
                user.replace(s_rec[1],s_rec[2]);
            }
        }
        
       // System.out.println(user);
        
        answer = new String[count];
        
        int index = 0;
        for(String rec:record){
            String[] s_rec = rec.split(" ");
            if (s_rec[0].equals("Enter")){
                answer[index] = user.get(s_rec[1])+"님이 들어왔습니다.";
                index++;
            } else if (s_rec[0].equals("Leave")){
                answer[index] = user.get(s_rec[1])+"님이 나갔습니다.";
                index++;
            }
        }
        
        return answer;
    }
}
