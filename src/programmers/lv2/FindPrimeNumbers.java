package lv2;

import java.util.HashSet;
import java.util.Set;

/**
 * @title 소수 찾기
 * @author 김민중
 * @see https://school.programmers.co.kr/learn/courses/30/lessons/42839
 * @category 완전탐색
 */
public class FindPrimeNumbers {
    Set<Integer> sets = new HashSet<>();
    
    public int solution(String numbers) {
        int answer = 0;
        String[] strs = new String[numbers.length()];
        for (int i = 0 ; i < numbers.length(); i ++){
            strs[i] = String.valueOf(numbers.charAt(i));
        }
        
        // Arrays.sort(strs);
        
        // int cnt = numbers.length();
        
        get7(strs);
        
        System.out.println(sets);
    
        answer = sets.size();

        
        return answer;
    }
    
    public void get7(String[] strs){
        int cnt = strs.length;
        Main1: for (int i=0; i<cnt; ++i) {
            if (isPrime(Integer.valueOf(strs[i]))){
                sets.add(Integer.valueOf(strs[i]));    
            }
            if (cnt == 1){
                continue Main1;
            }
            Main2: for (int k=0; k<cnt; ++k) {
                if (i==k) {
                    continue;
                }
                if (isPrime(Integer.valueOf(strs[i] + strs[k]))){
                    sets.add(Integer.valueOf(strs[i] + strs[k]));
                }
                if (cnt == 2){
                    continue Main2;
                }
                Main3: for (int j=0; j<cnt; ++j) {
                    if (k==j || i==j) {
                        continue;
                    }
                    if (isPrime(Integer.valueOf(strs[i] +  strs[k] +  strs[j]))){
                        sets.add(Integer.valueOf(strs[i] +  strs[k] +  strs[j]));
                    }
                    if (cnt == 3){
                        continue Main3;
                    }
                    Main4: for(int x=0; x<cnt; x++){
                        if(k==x || i==x || j==x){
                            continue;
                        }
                        if (isPrime(Integer.valueOf(strs[i] +  strs[k] +  strs[j] + strs[x]))){
                            sets.add(Integer.valueOf(strs[i] +  strs[k] +  strs[j] + strs[x]));
                        }
                        if (cnt == 4){
                            continue Main4;
                        }
                        Main5: for (int y=0; y<cnt; y++){
                            if(y==k || y==x || y==j || y==i){
                                continue;
                            }
                            if (isPrime(Integer.valueOf(strs[i] +  strs[k] +  strs[j] +  strs[x] +  strs[y]))){
                                sets.add(Integer.valueOf(strs[i] +  strs[k] +  strs[j] +  strs[x] +  strs[y]));
                            }
                            if (cnt == 5){
                                continue Main5;
                            }
                            Main6: for(int z=0; z<cnt; z++){
                                if(z==x || z==k || z==j || z==i || z==y){
                                    continue;
                                }
                                if (isPrime(Integer.valueOf(strs[i] +  strs[k] +  strs[j] +  strs[x] +  strs[y] +  strs[z]))){
                                    sets.add(Integer.valueOf(strs[i] +  strs[k] +  strs[j] +  strs[x] +  strs[y] +  strs[z]));
                                }
                                if (cnt == 6){
                                    continue Main6;
                                }
                                Main7: for (int a=0 ; a<cnt; a++){
                                    if (a==x || a==k || a==j || a==i || a==y || a==z){
                                        continue;
                                    }
                                    if (isPrime(Integer.valueOf(strs[i] +  strs[k] +  strs[j] +  strs[x] + strs[y] + strs[z] + strs[a]))){
                                        sets.add(Integer.valueOf(strs[i] +  strs[k] +  strs[j] +  strs[x] + strs[y] + strs[z] + strs[a]));
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    
    public boolean isPrime(Integer n){
        if (n < 2) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        for (int i = 3; i <= Math.sqrt(n) + 1; i += 1) {
            if (n % i == 0) return false;
        }
        return true;
    }
}