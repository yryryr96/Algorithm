import java.util.*;
import java.io.*;

class Solution {
    
    static int N, M, answer;
    static int[] dy = {0, 0, 1, -1};
    static int[] dx = {1, -1, 0, 0};
    static class Pair {
        int y, x;
        Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    
    public int solution(int[][] maps) {
        
        N = maps.length;
        M = maps[0].length;
        answer = bfs(maps);
    
        return answer;
    }
    
    static int bfs(int[][] maps) {
        
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0,0));
        
        int[][] visited = new int[N][M];
        visited[0][0] = 1;
        
        while(!q.isEmpty()) {
            
            Pair cur = q.poll();
            if (cur.y == N-1 && cur.x == M-1) {
                return visited[cur.y][cur.x];
            }
            
            for(int d = 0; d < 4; d++) {
                int ny = cur.y + dy[d];
                int nx = cur.x + dx[d];
                
                if(!isInRange(ny, nx)) continue;
                if(visited[ny][nx] != 0) continue;
                if(maps[ny][nx] == 0) continue;
                
                visited[ny][nx] = visited[cur.y][cur.x] + 1;
                q.add(new Pair(ny,nx));
            }
        }
        
        return -1;
    }
    
    static boolean isInRange(int y, int x) {
        return 0 <= y && y < N && 0 <= x && x < M;
    }
}