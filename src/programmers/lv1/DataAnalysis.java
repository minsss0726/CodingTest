package lv1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @title 데이터 분석
 * @author 김민중
 * @see https://school.programmers.co.kr/learn/courses/30/lessons/250121
 * @category PCCE 기출문제
 */
public class DataAnalysis {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int[][] answer = {};
        
        boolean[] answer_index = new boolean[data.length];
        
        ArrayList<String> datas = new ArrayList<String>(List.of("code","date","maximum","remain"));   
        
        int ext_index = datas.indexOf(ext);
        int val_ext_index = datas.indexOf(val_ext);
        int sort_by_index = datas.indexOf(sort_by);
    
        int count = 0;
        
        for (int i = 0 ; i < data.length ; i++) {
            if ( data[i][ext_index] < val_ext ){
                answer_index[i] = true;
                count++;
            }
        }
        
        //System.out.println(Arrays.toString(answer_index));
        
        answer = new int[count][4];
        int k = 0;
        
        for (int i = 0 ; i < data.length ; i ++){
            if (answer_index[i] == true){
                answer[k] = data[i];
                //System.out.println(Arrays.toString(answer[k]));
                k++;
            }
        }
        
        Arrays.sort(answer , (a,b) -> Integer.compare(a[sort_by_index],b[sort_by_index]));
       
        
        return answer;
    }
}
