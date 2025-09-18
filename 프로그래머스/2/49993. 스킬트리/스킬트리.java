class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        for (String tree : skill_trees){
            int len = tree.length();
            String learn = "";
            for ( int i = 0; i < len; i++){
                if (skill.indexOf(String.valueOf(tree.charAt(i))) > -1 ){
                    learn += String.valueOf(tree.charAt(i));
                }
            }
            // System.out.println(learn);
            if (skill.startsWith(learn)){
                // System.out.println("count:"+learn);
                answer++;
            }
            
        }
        
        
        return answer;
    }
}