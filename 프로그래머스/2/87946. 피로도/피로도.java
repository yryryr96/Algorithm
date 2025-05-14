import java.util.*;

class Solution {
    
    static boolean[] visited;
    static int n, answer;
    
    public int solution(int k, int[][] dungeons) {
        
        answer = 0;
        n = dungeons.length;
        visited = new boolean[n];
        getAnswer(0, k, dungeons);
        return answer;
    }
    
    static void getAnswer(int depth, int curHp, int[][] dungeons) {
        
        answer = Math.max(answer, depth);
        if (depth == n) {
            return;
        }
        
        for(int i = 0; i < n; i++) {
            if(visited[i]) continue;
            
            if (curHp >= dungeons[i][0]) {
                visited[i] = true;
                getAnswer(depth+1, curHp - dungeons[i][1], dungeons);
                visited[i] = false;
            }
            
        }
    }
}