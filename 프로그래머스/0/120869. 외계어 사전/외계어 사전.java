class Solution {
    public int solution(String[] spell, String[] dic) {
        int answer = 2;
        
        for (String str:dic){
            if (str.length() == spell.length) {
                for (int i = 0 ; i < spell.length ; i++){
                    str = str.replace(spell[i],"");
                    if (str.length() == spell.length - 1 - i) {
                        if (str.length() == 0) {
                            return 1;
                        }
                        continue;
                    } else {
                        break;
                    }
                }
            }
        }
        
        return answer;
    }
}