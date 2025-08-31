package codetest.shinhan.test250829;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Question3 {
    public int[] solution(String message, int n) {
        int[] answer = new int[2];
        answer[0] = message.length();

        List<String> list = new ArrayList<>();

        Set<Character> used = new HashSet<>();

        while(message.length() > 0){
            if(message.length() > n){
                list.add(message.substring(0,n));
                message = message.substring(n,message.length());
            } else {
                list.add(message);
                message = "";
            }
        }

        for (int i = 1; i < list.size(); i++){
            String str1 = list.get(i-1);
            String str2 = list.get(i);

            for(int j = 0; j < str2.length(); j++){
                if(str1.charAt(j) == str2.charAt(j)){
                    answer[0]--;
                    used.add(str2.charAt(j));
                }
            }
        }

        answer[1] = used.size();

        // System.out.println(list);

        return answer;
    }
}
