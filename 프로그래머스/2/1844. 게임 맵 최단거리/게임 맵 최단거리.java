import java.util.*;

class Solution {
    
    static int n,m;
    static int[][] MAP;
    static class Pair {
        int y,x;
        Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    static int[][] visited;
    static int dy[] = {0,1,0,-1};
    static int dx[] = {1,0,-1,0};
    
    public int solution(int[][] maps) {
        
        MAP = maps;
        n = MAP.length;
        m = MAP[0].length;
        visited = new int[n][m];
        
        int answer = bfs();
        return answer;
    }
    
    static int bfs() {
        
        Queue<Pair> q = new LinkedList<>();
        int sy = 0, sx = 0;
        q.add(new Pair(sy, sx));
        visited[sy][sx] = 1;
        
        int ey = n-1, ex = m-1;
        while(!q.isEmpty()) {
            
            Pair cur = q.poll();
            
            if (cur.y == ey && cur.x == ex) {
                return visited[ey][ex];
            }
            
            for (int d = 0; d < 4; d++) {
                int ny = cur.y + dy[d];
                int nx = cur.x + dx[d];
                
                if (!isInRange(ny,nx)) continue;
                if (visited[ny][nx] != 0) continue;
                if (MAP[ny][nx] == 0) continue;
                
                q.add(new Pair(ny,nx));
                visited[ny][nx] = visited[cur.y][cur.x] + 1;
            }
        }
        
        return -1;
    }
    
    static boolean isInRange(int y, int x) {
        return 0 <= y && y < n && 0 <= x && x < m;
    }
}