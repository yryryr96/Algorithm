import java.util.*;
class Solution {
    
    static int[][] visited;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int n;
    static int m;
    
    public int solution(int[][] maps) {
        int answer = 0;
        
        n = maps.length;
        m = maps[0].length;
        Queue<Pair> q = new LinkedList<>();
        visited = new int[n][m];

        answer = bfs(maps, q);
        
        return answer;
    }
    
    public static int bfs(int[][] map, Queue<Pair> q) {

        q.add(new Pair(0,0));
        visited[0][0] = 1;
        while (!q.isEmpty()) {

            Pair p = q.poll();
            int y = p.y;
            int x = p.x;
            if (y == n-1 && x == m-1) {
                return visited[y][x];
            }
            for (int i = 0; i < 4; i++) {
                int ny = p.y + dy[i];
                int nx = p.x + dx[i];

                if (0<=ny && ny<n && 0<= nx && nx < m && map[ny][nx] == 1 && visited[ny][nx] == 0) {
                    visited[ny][nx] = visited[p.y][p.x] + 1;
                    q.add(new Pair(ny,nx));
                }
            }
        }
        
        return -1;
    }
    
    public static class Pair {
        int y,x;

        public Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}