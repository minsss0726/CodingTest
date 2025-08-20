package baekjoon.gold;

import java.util.Scanner;

/**
 * @title A와 B
 * @author 김민중
 * @see https://www.acmicpc.net/problem/12904
 * @category 문자열, 구현
 */
public class AandB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        sc.close();

        StringBuffer sb1 = new StringBuffer();
        sb1.append(s1);
        StringBuffer sb2 = new StringBuffer();
        sb2.append(s2);
        
        while (sb1.length() < sb2.length()) {
            if(sb2.charAt(sb2.length()-1) == 'A'){
                sb2.deleteCharAt(sb2.length()-1);
            }else{
                sb2.deleteCharAt(sb2.length()-1);
                sb2.reverse();
            }
        }

        if(sb1.toString().equals(sb2.toString())){
            System.out.println("1");
        }else{
            System.out.println("0");
        }
}
}
