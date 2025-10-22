import java.util.*;

class Solution {
    
    // ArrayList<Integer> list = new ArrayList<>();
    int a = Integer.MAX_VALUE;
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        boolean[] visited = new boolean[words.length];
        dfs(begin,target,words,0,visited);
        // System.out.println(list);
        // answer = list.stream().mapToInt(Integer::intValue).min().orElse(0);
        answer = a;
        if( a > words.length) return 0;
        return answer;
    }
    
    public void dfs(String str,String target, String[] words, int depth, boolean[] visited){
        if(depth > words.length) return;
        if(target.equals(str)) {
            if(depth < a) a = depth;
            return;
        }
        
        for(int i = 0; i < words.length; i++){
            if(!visited[i] && changeWord(str,words[i])){
                visited[i] = true;
                dfs(words[i],target,words,depth+1,visited);
                visited[i] = false;
            }
        }
    }
    
    public boolean changeWord(String ori, String tar){
        int cor = 0;
        for(int i = 0; i < ori.length(); i++){
            if(ori.charAt(i) == tar.charAt(i)) cor++;
        }
        if(cor == ori.length() - 1){
            return true;
        }
        return false;
    }
}