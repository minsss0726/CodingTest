import java.util.Arrays;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = {};
        int[] answer_check = new int[privacies.length];
        int answer_count = 0;
        
        today = String.valueOf(today.replace(".",""));
        //System.out.println(today);
        
        String[][] terms_div = new String[terms.length][2];
        
        String[][] privacies_div = new String[privacies.length][2];
        
        for (int i = 0; i < terms.length ; i++){
            terms[i] = terms[i].replace(".","");
        }
        for (int i = 0; i < privacies.length ; i++){
            privacies[i] = privacies[i].replace(".","");
        }
        
        
        for (int i = 0; i < terms_div.length ; i++){
            terms_div[i] = terms[i].split(" ");
        }
        for (int i = 0; i < privacies_div.length ; i++){
            privacies_div[i] = privacies[i].split(" ");
        }
        
        //System.out.println(Arrays.toString(terms_div[0]));
        //System.out.println(Arrays.toString(privacies_div[0]));
        
        for (int i = 0 ; i < terms_div.length ; i++){
            for (int j = 0 ; j < privacies_div.length; j++){
                String[] date_div_p = new String[3];
                date_div_p[0] = privacies_div[j][0].substring(0,4);
                date_div_p[1] = privacies_div[j][0].substring(4,6);
                date_div_p[2] = privacies_div[j][0].substring(6);
                if ( terms_div[i][0].equals(privacies_div[j][1]) ) {
                    //System.out.print(date_div_p[0]);
                    //System.out.print(date_div_p[1]);
                    //System.out.println(date_div_p[2]);
                    if ( (Integer.parseInt(date_div_p[1]) + Integer.parseInt(terms_div[i][1])) > 12 ) {
                        date_div_p[0] = String.valueOf( Integer.parseInt(date_div_p[0]) + (  ( Integer.parseInt(date_div_p[1]) + Integer.parseInt(terms_div[i][1]) ) / 12 ) );
                        if ( (Integer.parseInt(terms_div[i][1]) + Integer.parseInt(date_div_p[1]) ) % 12 == 0){
                            date_div_p[0] = String.valueOf(Integer.parseInt(date_div_p[0]) - 1);
                        }
                        date_div_p[1] = String.valueOf( Integer.parseInt(date_div_p[1]) + Integer.parseInt(terms_div[i][1]) );
                        
                        while(Integer.parseInt(date_div_p[1]) > 12){
                            date_div_p[1] = String.valueOf( Integer.parseInt(date_div_p[1]) -12 );
                        }
                        
                        if (date_div_p[1].length() < 2) {
                            date_div_p[1] = "0"+ date_div_p[1];
                        }
                    } else {
                        
                        date_div_p[1] = String.valueOf( Integer.parseInt(date_div_p[1]) + Integer.parseInt(terms_div[i][1]) );
                       
                        if (date_div_p[1].length() < 2) {
                            date_div_p[1] = "0" + date_div_p[1];
                        }
                    }
                    //System.out.print(date_div_p[0]);
                    //System.out.print(date_div_p[1]);
                    //System.out.println(date_div_p[2]);
                    privacies_div[j][0] = date_div_p[0] + date_div_p[1] + date_div_p[2];
                    System.out.println(privacies_div[j][0]);
                    if ( Integer.parseInt(String.valueOf(today)) >= Integer.parseInt(String.valueOf(privacies_div[j][0])) ) {
                        answer_check[j] = j+1;
                        answer_count++;
                    }
                }
            }
        }
        //System.out.println(Arrays.toString(answer_check));
        //System.out.println(answer_count);
        answer = new int[answer_count];
        answer_count = 0;
        for (int answer_number:answer_check){
            if ( answer_number != 0){
                answer[answer_count] = answer_number;
                answer_count++;
            }
        }
        //System.out.println(Arrays.toString(answer));
        int min = Integer.MAX_VALUE;
        int[] answer2 = new int[answer.length];
        int check_point = 0;
        
        for (int j = 0 ; j < answer2.length; j++){
            for( int i = 0 ; i < answer.length ; i++){
                if ( answer[i] < min){
                    min = answer[i];
                    check_point = i;
                }
            }
            answer2[j] = min;
            answer[check_point] = Integer.MAX_VALUE;
            min = Integer.MAX_VALUE;
            System.out.println(Arrays.toString(answer));
            System.out.println(Arrays.toString(answer2));
        }
        //System.out.println(Arrays.toString(answer2));
        //System.out.println(answer_count);
        return answer2;
        
    }
}