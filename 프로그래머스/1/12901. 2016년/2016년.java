import java.time.LocalDate;
import java.time.DayOfWeek;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

class Solution {
    public String solution(int a, int b) {
        String answer = "";
        
        String input = "2016";
        if( a < 10) {
            input += ("0"+String.valueOf(a));
        } else {
            input += String.valueOf(a);
        }
        if( b < 10) {
            input += ("0"+String.valueOf(b));
        } else {
            input += String.valueOf(b);
        }
        
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyyMMdd");  // 패턴 지정
        LocalDate date = LocalDate.parse(input, fmt);     // 문자열 → LocalDate
        DayOfWeek dow = date.getDayOfWeek();              // 요일 얻기
        String dayName = dow.getDisplayName(java.time.format.TextStyle.FULL, Locale.KOREAN);
        
        if("월요일".equals(dayName)){
            return "MON";
        } else if("화요일".equals(dayName)){
            return "TUE";
        } else if("수요일".equals(dayName)){
            return "WED";
        } else if("목요일".equals(dayName)){
            return "THU";
        } else if("금요일".equals(dayName)){
            return "FRI";
        } else if("토요일".equals(dayName)){
            return "SAT";
        } else if("일요일".equals(dayName)){
            return "SUN";
        }
        
        return answer;
    }
}