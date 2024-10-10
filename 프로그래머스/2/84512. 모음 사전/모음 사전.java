import java.util.*;
class Solution {
    
    static List<String> dictionary = new ArrayList<>();
    static String[] strs = {"A", "E", "I", "O", "U"};
    static int n = 5;
    static boolean[] visited = new boolean[n];
    
    public int solution(String word) {
        
        dfs("");
        int answer = dictionary.indexOf(word) + 1;
        return answer;
    }
    
    static void dfs(String word) {
        
        if (word.length() >= n) return;
        
        for(int i = 0; i < n; i++) {
            dictionary.add(word + strs[i]);
            dfs(word + strs[i]);
        }
    }

}