import java.util.*;

class Solution {
    
    static int answer = 0, temp = -1;
    static String[] chars = new String[]{"A", "E", "I", "O", "U"};
    public int solution(String word) {
        dfs(0, "", word);
        return answer;
    }
    
    static void dfs(int depth, String str, String target) {
        temp++;
        if (answer != 0) {
            return;
        }
        
        if (str.equals(target)) {
            answer = temp;
            return;
        }
        
        if (depth >= 5) {
            return;
        }
        
        for(int i = 0; i < 5; i++) {
            dfs(depth+1, str + chars[i], target);
        }
    }
}