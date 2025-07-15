package programmers;

/**
 * @title 도넛과 막대 그래프
 * @author 김민중
 * @see https://school.programmers.co.kr/learn/courses/30/lessons/258711
 * @category 2024 KAKAO WINTER INTERNSHIP, 그래프 탐색
 */
public class DonutAndStickGraph {
    int[] answer = new int[4];
    static int mainDot = 0;
    static int maxDot = 0;
    static int[] toGoing;
    static int[] inComing;
 
    
    public void initGraph(int[][] edges){
        
        for (int[] edge: edges){
            maxDot = Math.max(maxDot,Math.max(edge[0],edge[1]));
        }
        
        inComing = new int[maxDot+1];
        toGoing = new int[maxDot+1];
        
        for (int i = 0 ; i < edges.length ; i++) {
            toGoing[edges[i][0]]++;
            inComing[edges[i][1]]++;
        }
        
        for (int i = 1 ; i <= maxDot ; i++){
            if (inComing[i] == 0 && toGoing[i] >= 2) {
                mainDot = i;
                answer[0] = i;
                break;
            }
        }
        
    }
    
    public void findGraph(int[][] edges){
        for (int i = 1; i <= maxDot ; i++ ){
            if ( i != mainDot && toGoing[i] == 0 && inComing[i] >= 1){
                answer[2] ++;
            }
        }
        
        for (int i = 1; i <= maxDot ; i++ ){
            if ( i != mainDot && toGoing[i] >= 2 && inComing[i] >= 2)
                answer[3]++;
        }
        
        if ( toGoing[mainDot] > answer[2] + answer[3] ){
            answer[1] = toGoing[mainDot] - answer[2] - answer[3];
        }
        
    }
    
    
    public int[] solution(int[][] edges) {
        
        initGraph(edges);
        findGraph(edges);
        
        return answer;
    }
}
