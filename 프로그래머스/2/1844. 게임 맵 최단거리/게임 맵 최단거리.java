import java.util.*;

class Solution {
    
    static int n,m;
    static int[][] visited;
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};
    
    public int solution(int[][] maps) {
        int answer = 0;
        
        n = maps.length;
        m = maps[0].length;
        visited = new int[n][m];
        
        answer = bfs(maps);
        return answer;
    }
    
    static int bfs(int[][] maps) {
        
        Queue<int[]> q = new LinkedList<>();
        visited[0][0] = 1;
        q.add(new int[]{0,0});
        
        while(!q.isEmpty()) {
            
            int[] cur = q.poll();
            int y = cur[0];
            int x = cur[1];
            
            if (y == n-1 && x == m-1) {
                return visited[y][x];
            }
            
            for(int d = 0; d < 4; d++) {
                int ny = y + dy[d];
                int nx = x + dx[d];
                
                if(!inRange(ny, nx)) continue;
                if(visited[ny][nx] != 0) continue;
                if(maps[ny][nx] == 0) continue;
                
                visited[ny][nx] = visited[y][x] + 1;
                q.add(new int[]{ny, nx});
            }
        }
        
        return -1;
    }
    
    static boolean inRange(int y, int x) {
        return 0 <= y && y < n && 0 <= x && x < m;
    }
}