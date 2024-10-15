import java.util.*;

class Solution {
    
    static int n,m;
    static int[] dy = {0,1,0,-1};
    static int[] dx = {1,0,-1,0};
    static int[][] visited;
    
    static class Pair {
        int y, x;
        Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    
    public int solution(String[] board) {
        int answer = 0;
        
        n = board.length;
        m = board[0].length();
        
        String[][] map = new String[n][m];
        for(int i = 0; i < n; i++) {
            map[i] = board[i].split("");
        }
        
        visited = new int[n][m];
        
        answer = getAnswer(map);
        
        return answer;
    }
    
    static int getAnswer(String[][] board) {
        
        int sy = 0, sx = 0;
        int ey = 0, ex = 0;
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(board[i][j].equals("R")) {
                    sy = i; sx = j;
                } else if(board[i][j].equals("G")) {
                    ey = i; ex = j;
                }
            }
        }
        
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(sy,sx));
        visited[sy][sx] = 1;
        
        while(!q.isEmpty()) {
            
            Pair cur = q.poll();
            // System.out.println("y = " + cur.y + " x = " + cur.x);
            if(cur.y == ey && cur.x == ex) {
                return visited[cur.y][cur.x] - 1;
            }
            
            for(int k = 0; k < 4; k++) {
                
                int ny = cur.y + dy[k];
                int nx = cur.x + dx[k];
                
                while(inRange(ny,nx) && !board[ny][nx].equals("D")) {
                    ny += dy[k];
                    nx += dx[k];
                }
                
                if(inRange(ny,nx) && visited[ny][nx] != 0) continue;
                
                ny -= dy[k];
                nx -= dx[k];
                
                if(visited[ny][nx] == 0) {
                    q.add(new Pair(ny,nx));
                    visited[ny][nx] = visited[cur.y][cur.x] + 1;
                }
            }
        }
        
        return -1;
    }
    
    static boolean inRange(int y, int x) {
        return 0 <= y && y < n && 0 <= x && x < m;
    }
}