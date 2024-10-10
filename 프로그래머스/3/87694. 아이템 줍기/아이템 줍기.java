import java.util.*;
class Solution {
    
    static int[][] visited;
    static int n = 102;
    static int[][] map = new int[n][n];
    static int[] dy = {0,0,1,-1,1,-1,1,-1};
    static int[] dx = {1,-1,0,0,-1,-1,1,1};
    static class Pair {
        int y,x;
        Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {

        initMap(rectangle);
        int answer = bfs(characterX, characterY, itemX, itemY);
        return answer;
    }
    
    static int bfs(int characterX, int characterY, int itemX, int itemY) {
        
        visited = new int[n][n];
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(characterY*2, characterX*2));
        visited[characterY*2][characterX*2] = 1;
        
        while(!q.isEmpty()) {
            
            Pair cur = q.poll();
            // System.out.println("y = " + cur.y + " x = " + cur.x + " l = " + visited[cur.y][cur.x]);
            if (cur.y == itemY*2 && cur.x == itemX*2) {
                return (visited[cur.y][cur.x] - 1)/2;
            }
            
            for(int k = 0; k < 4; k++) {
                int ny = cur.y + dy[k];
                int nx = cur.x + dx[k];
                
                if(!isRange(ny,nx) || !isRoad(ny,nx)) continue;
                if(visited[ny][nx] != 0) continue;
                
                visited[ny][nx] = visited[cur.y][cur.x] + 1;
                q.add(new Pair(ny,nx));
            }
        }
        
        return -1;
    }
    
    static boolean isRoad(int y, int x) {
        
        if(map[y][x] == 0) return false;
        
        int cnt = 0;
        for(int k = 0; k < 8; k++) {
            
            int ny = y + dy[k];
            int nx = x + dx[k];
            
            if(!isRange(ny,nx)) continue;
            if(map[ny][nx] == 0) cnt++;
        }
        
        return cnt > 0 ? true : false;
    }
    
    static boolean isRange(int y, int x) {
        return 0 <= y && y < n && 0 <= x && x < n;
    }
    
    static void initMap(int[][] rectangle) {
                
        for(int[] r : rectangle) {
            
            int x1 = r[0]*2;
            int y1 = r[1]*2;
            int x2 = r[2]*2;
            int y2 = r[3]*2;
            
            for(int i = y1; i <= y2; i++) {
                for(int j = x1; j <= x2; j++) {
                    map[i][j] = 1;
                }
            }
        }
    }
}