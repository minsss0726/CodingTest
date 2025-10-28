import java.util.*;

class Solution {
    
    ArrayList<LinkedList<Integer>> tree = new ArrayList<LinkedList<Integer>>();
    int[] nodeCount;
    LinkedList<Integer> seq = new LinkedList<>();
    LinkedList<int[]> sumSet = new LinkedList<int[]>();
    
    public int[] solution(int[][] edges, int[] target) {
        int[] answer = new int[1];
        nodeCount = new int[target.length];
        
        for(int i = 0; i<= target.length; i++){
            tree.add(new LinkedList<Integer>());
        }
        for(int[] edge:edges){
            tree.get(edge[0]).add(edge[1]);
        }
        for(LinkedList<Integer> tr:tree){
            Collections.sort(tr);
            // System.out.println(tr);
        }
        // for(int i = 0; i <= target.length;i++){
        //     sumSet.add(new int[1]);
        // }
        sumSet.add(new int[1]);
        
        
        Main: while(true){
            dfs(tree.get(1),1);
            if(correct(target)){
                answer = new int[seq.size()];
                for(int i = 1; i<=target.length; i++){
                    sumSet.add(smallestSequence(target[i-1], nodeCount[i-1]));
                    int[] sets = smallestSequence(target[i-1], nodeCount[i-1]);
                    // System.out.println(Arrays.toString(sets) + " " + i);
                    if(nodeCount[i-1] > 0){
                        int index = 0;
                        for(int j = 0; j < seq.size(); j++){
                            if(seq.get(j) == i){
                                answer[j] = sets[index];
                                // System.out.println(Arrays.toString(answer));
                                index++;
                            }
                        }
                    }
                    
                    // System.out.println(Arrays.toString(sumSet.get(i)));
                }
                
                
                
                break Main;
            } else if(over(target)){
                
                answer[0] = -1;
                break Main;
            }
        }
        
        return answer;
    }
    
    public void dfs(LinkedList<Integer> tr, int nowNode){
        if(tr.size() == 0){
            nodeCount[nowNode-1]++;
            // System.out.println(Arrays.toString(nodeCount));
            seq.add(nowNode);
            return;
        }
        
        int nextNode = tr.get(0);
        tr.add(tr.pollFirst());
        dfs(tree.get(nextNode), nextNode);
    }
    
    public boolean correct(int[] target){
        int count = 0;
        for(int i = 0; i < target.length; i++){
            if(nodeCount[i] <= target[i] && nodeCount[i]*3 >= target[i]){
                count++;
            }
        }
        if(count == target.length) return true;
        return false;
    }
    
    public boolean over(int[] target){
        for(int i = 0; i < target.length; i++){
            if(nodeCount[i] > target[i]){
                return true;
            }
        }
        return false;
    }
    
    public static int[] smallestSequence(int n, int m) {
        int[] a = new int[m];
        Arrays.fill(a, 1);             
        int extra = n - m;              

        for (int i = m - 1; i >= 0 && extra > 0; i--) {
            int add = Math.min(2, extra); 
            a[i] += add;
            extra -= add;
        }
        return a; 
    }
}