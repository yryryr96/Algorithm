import java.util.*;
class Solution {

    static int n,m;
    static int answer = -1;
    static int[][] visited;
    static int[] dy = {0,0,1,-1};
    static int[] dx = {1,-1,0,0};
    
    public int solution(int[][] maps) {
        
        n = maps.length;
        m = maps[0].length;
        visited = new int[n][m];    
          
        bfs(maps);
        return answer;
    }
    
    static void bfs(int[][] maps) {
        
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0,0));
        visited[0][0] = 1;
        
        while(!q.isEmpty()) {
            
            Pair cur = q.poll();
            if(cur.y == n-1 && cur.x == m-1) {
                answer = visited[cur.y][cur.x];
                return;
            }
            
            for(int k = 0; k < 4; k++) {
                int ny = cur.y + dy[k];
                int nx = cur.x + dx[k];
                if(isRange(ny,nx) && maps[ny][nx] == 1 && visited[ny][nx] == 0) {
                    q.add(new Pair(ny,nx));
                    visited[ny][nx] = visited[cur.y][cur.x] + 1;
                }
            }
        }
    }
    
    static boolean isRange(int y, int x) {
        return 0 <= y && y < n && 0 <= x && x < m;
    }
    
    static class Pair {
        
        int y, x;
        Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}