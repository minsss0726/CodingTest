import java.util.*;

class Solution {
    
    ArrayList<ArrayList<Integer>> combs;
    
    public int solution(int n, int[][] q, int[] ans) {
        int answer = 0;
        combs = generateCombinations(n, 5);
        
        Main: for (List<Integer> combination : combs) {
            for (int i = 0; i < q.length; i++){
                int countContains = 0;
                for (int j = 0; j <q[i].length; j++){
                    if(combination.contains(q[i][j])){
                        countContains++;
                    }
                }
                if(countContains != ans[i]){
                    continue Main;
                }
            }
            answer++;
        }
        
        return answer;
    }
    
    public ArrayList<ArrayList<Integer>> generateCombinations(int n, int r) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<>();
        backtrack(1, n, r, new ArrayList<>(), results);
        return results;
    }
    
    private void backtrack(int start, int n, int r, List<Integer> current, ArrayList<ArrayList<Integer>> results) {
        if (current.size() == r) {
            results.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i <= n; i++) {
            current.add(i);
            backtrack(i + 1, n, r, current, results); 
            current.remove(current.size() - 1);       
        }
    }
}