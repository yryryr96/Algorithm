import java.util.*;
class Solution {
    
    static boolean[] visited;
    static int answer;
    
    public int solution(int n, int[][] computers) {
        
        visited = new boolean[n];
        
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                answer++;
                visited[i] = true;
                dfs(i, n, computers);
            }
        }
        
        return answer;
    }
    
    static void dfs(int num, int n, int[][] computers) {
        
        for(int i = 0; i < n; i++) {
            if(!visited[i] && computers[num][i] == 1) {
                visited[i] = true;
                dfs(i, n, computers);
            }
        }
    }
}