import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        int[] answer = {};
        SortedMap<String, int[]> map = new TreeMap<>();
        ArrayList<String> cars = new ArrayList<>();
        for (String record:records){
            String[] splitRecord = record.split(" ");
            if(splitRecord[2].equals("IN")){
                if(!map.containsKey(splitRecord[1])){
                    map.put(splitRecord[1], new int[]{formatTime(splitRecord[0]), 0, 1});
                    cars.add(splitRecord[1]);
                } else {
                    map.replace(splitRecord[1], 
                               new int[]{formatTime(splitRecord[0]), map.get(splitRecord[1])[1], 1});
                }
            } else {
                int startTime = map.get(splitRecord[1])[0];
                int endTime = formatTime(splitRecord[0]);
                int charge = getCharge(startTime, endTime);
                map.replace(splitRecord[1], new int[]{-1, map.get(splitRecord[1])[1] + charge, 0});
            }
            // map.entrySet().stream().forEach(e->System.out.print(e.getKey() + " " + Arrays.toString(e.getValue())));
            // System.out.println();
        }
        
        cars.sort((a,b) -> {return a.compareTo(b);});
        answer = new int[cars.size()];
        int index = 0;
        for(String car:cars){
            if(map.get(car)[2] == 1){
                answer[index] = calcCharge(map.get(car)[1] + getCharge(map.get(car)[0], formatTime("23:59")), fees);
            } else {
                answer[index] = calcCharge(map.get(car)[1],fees);
            }
            index++;
        }
        
        // System.out.println(Arrays.toString(answer));
        
        
        
        return answer;
    }
    
    public int formatTime(String time){
        String[] splitTime = time.split(":");
        int result = (Integer.parseInt(splitTime[0])*60) + Integer.parseInt(splitTime[1]);
        return result;
    }
    
    public int getCharge(int start, int end){
        int time = end - start;
        return time;
    }
    
    public int calcCharge(int time, int[] fees){
        if(time < fees[0]) return fees[1];
        
        int count = (time - fees[0]) / fees[2];
        if( ((time - fees[0]) % fees[2]) > 0 ) count++;
        
        return count * fees[3] + fees[1];
    }
}