import java.util.*;
class Solution {
    
    static boolean[] visited;
    static int n, answer;
    
    public int solution(int k, int[][] dungeons) {
    
        n = dungeons.length;
        visited = new boolean[n];
        answer = 0;
        
        dfs(0, k, dungeons);
        
        return answer;
    }
    
    static void dfs(int cnt, int curHp, int[][] dungeons) {
        
        if (cnt <= n) {
            answer = Math.max(cnt, answer);
        }
        
        for(int i = 0; i < n; i++) {         
            if(!visited[i]) {
                int[] dungeon = dungeons[i];
                if(curHp >= dungeon[0]) {
                    visited[i] = true;
                    dfs(cnt+1, curHp - dungeon[1], dungeons);
                    visited[i] = false;
                }
            }
        }
    }
}