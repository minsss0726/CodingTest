import java.util.*;

class Solution {
    public int[] solution(String msg) {

        Map<String, Integer> dict = new HashMap<>();
        for (int i = 1; i <= 26; i++) {
            char ch = (char) (i + 64);  
            dict.put(String.valueOf(ch), i);
        }

        List<Integer> list = new ArrayList<>();
        int dictSize = 27;  
        int index = 0;

        while (index < msg.length()) {
            String w = String.valueOf(msg.charAt(index));
            int nextIndex = index + 1;

            while (nextIndex <= msg.length()) {
                String next = msg.substring(index, nextIndex);
                if (dict.containsKey(next)) {
                    w = next;
                    nextIndex++;
                } else {
                    break;
                }
            }

            list.add(dict.get(w));

            if (nextIndex <= msg.length()) {
                String wc = msg.substring(index, nextIndex);
                dict.put(wc, dictSize++);
            }

            index += w.length();
        }

        return list.stream().mapToInt(i -> i).toArray();
    }
}