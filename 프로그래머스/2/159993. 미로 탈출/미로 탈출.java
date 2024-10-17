import java.util.*;
class Solution {
    
    static String[][] map;
    static int n,m;
    static int[][] visited;
    static int answer = 0;
    static int[] dy = {0,1,0,-1};
    static int[] dx = {1,0,-1,0};
    public int solution(String[] maps) {
        
        
        n = maps.length;
        m = maps[0].length();
        visited = new int[n][m];
        map = new String[n][m];
        
        for(int i = 0; i < n; i++) {
            map[i] = maps[i].split("");
        }
        
        answer = bfs();
        
        return answer;
    }
    
    static int bfs() {
        
        int sy = 0, sx = 0;
        int ey = 0, ex = 0;
        int ly = 0, lx = 0;
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if (map[i][j].equals("S")) {
                    sy = i; sx = j;
                } else if (map[i][j].equals("E")) {
                    ey = i; ex = j;
                } else if (map[i][j].equals("L")) {
                    ly = i; lx = j;
                }
            }
        }
        
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(sy, sx));
        visited[sy][sx] = 1;
        boolean canLever = false;
        int ans = 0;
        while(!q.isEmpty()) {
            
            Pair cur = q.poll();
            
            if (cur.y == ly && cur.x == lx) {
                canLever = true;
                break;
            }
            
            for(int k = 0; k < 4; k++) {
                int ny = cur.y + dy[k];
                int nx = cur.x + dx[k];
                if (inRange(ny, nx) && visited[ny][nx] == 0 && !map[ny][nx].equals("X")) {
                    q.add(new Pair(ny,nx));
                    visited[ny][nx] = visited[cur.y][cur.x] + 1;
                }
            }
        }
        
        if (!canLever) return -1;
        
        ans += (visited[ly][lx] - 1);
        // System.out.println("ans = " + ans);
        initVisited();
        q = new LinkedList<>();
        q.add(new Pair(ly, lx));
        visited[ly][lx] = 1;
        while(!q.isEmpty()) {
            
            Pair cur = q.poll();
            
            if (cur.y == ey && cur.x == ex) {
                ans += (visited[cur.y][cur.x] - 1);
                // System.out.println("ans = " + ans);
                return ans;
            }
            
            for(int k = 0; k < 4; k++) {
                int ny = cur.y + dy[k];
                int nx = cur.x + dx[k];
                if (inRange(ny, nx) && visited[ny][nx] == 0 && !map[ny][nx].equals("X")) {
                    q.add(new Pair(ny,nx));
                    visited[ny][nx] = visited[cur.y][cur.x] + 1;
                }
            }
        }
        
        return -1;
    }
    
    static void initVisited() {
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                visited[i][j] = 0;
            }
        }
    }
    
    static boolean inRange(int y, int x) {
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