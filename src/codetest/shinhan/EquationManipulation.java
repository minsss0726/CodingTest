package codetest.shinhan;

import java.util.*;

public class EquationManipulation {
    public static void main(String[] args) {
        String s = "2-1x5-4x3+2";

        int answer = 0;

        List<Character> list = new LinkedList<>();
        List<Integer> result = new LinkedList<>();

        for (int i = 0; i < s.length(); i++){
            list.add(s.charAt(i));
        }

        // System.out.println(list);

        int i = 3;
        
        while(i <= s.length() / 2 + 1){
            List<Character> temp = new LinkedList<>(list);
            List<Character> temp2 = new LinkedList<>();

            for(int j = 0; j < temp.size() - 3; j++){
                
            }

        }

        


    }

}
