import java.util.*;
class Solution {
    static List<Integer> result = new ArrayList<>();
    static boolean[][] visited;
    static int n,m;
    static int[] dy = {0,1,0,-1};
    static int[] dx = {1,0,-1,0};
    static String[][] map;
    public int[] solution(String[] maps) {
        
        n = maps.length;
        m = maps[0].length();
        
        map = new String[n][m];
        visited = new boolean[n][m];
        
        for(int i = 0; i < n; i++) {
            map[i] = maps[i].split("");
        }
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if (!visited[i][j] && !map[i][j].equals("X")) bfs(i,j);
            }
        }
        
        if(result.size() == 0) {
            return new int[]{-1};
        }
        
        int[] answer = new int[result.size()];
        result.sort((a,b) -> a - b);
        
        for(int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        
        return answer;
    }
    
    static void bfs(int y, int x) {
        
        int score = 0;
        
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(y,x));
        visited[y][x] = true;
        
        while(!q.isEmpty()) {
            
            Pair cur = q.poll();
            score += Integer.parseInt(map[cur.y][cur.x]);
            for(int k = 0; k < 4; k++) {
                int ny = cur.y + dy[k];
                int nx = cur.x + dx[k];
                if (inRange(ny,nx) && !visited[ny][nx] && !map[ny][nx].equals("X")) {
                    
                    q.add(new Pair(ny,nx));
                    visited[ny][nx] = true;
                }
            }
        }
        
        if(score == 0) return;
        result.add(score);
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