import java.util.*;
class Solution {
    
    static int n = 5;
    static int[] dy = {0,1,0,-1};
    static int[] dx = {1,0,-1,0};
    static boolean[][] visited;
    static boolean flag = true;
    
    public int[] solution(String[][] places) {
        
        int[] answer = new int[5];
        Arrays.fill(answer, 1);
        visited = new boolean[n][n];
        
        for(int i = 0; i < places.length; i++) {
            flag = true;
            simulate(places[i]);
            if(!flag) {
                answer[i] = 0;
            }
        }
        
        return answer;
    }
    
    static void simulate(String[] arr) {
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(arr[i].charAt(j) == 'P') {
                    visited[i][j] = true;
                    dfs(1, i, j, arr);
                    visited[i][j] = false;
                }
            }
        }
    }
    
    static void dfs(int depth, int y, int x, String[] arr) {
        
        if(!flag) return;
        if(depth == 3) return;
        
        for(int k = 0; k < 4; k++) {
            int ny = y + dy[k];
            int nx = x + dx[k];
            
            if(!inRange(ny,nx) || visited[ny][nx]) continue;
            if(arr[y].charAt(x) == 'P' && arr[ny].charAt(nx) == 'P') {
                // System.out.println("y : " + y + " x : " + x + " ny : " + ny + " nx : " + nx);
                flag = false;
                return;
            }
            
            if(arr[y].charAt(x) == 'O' && arr[ny].charAt(nx) == 'P') {
                flag = false;
                return;
            }
            
            visited[ny][nx] = true;
            dfs(depth + 1, ny, nx, arr);
            visited[ny][nx] = false;
        }
    }
    
    static boolean inRange(int y, int x) {
        return 0 <= y && y < n && 0 <= x && x < n;
    }
}