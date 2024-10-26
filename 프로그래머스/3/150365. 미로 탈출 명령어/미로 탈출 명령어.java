import java.util.*;

class Solution {
    
    static class Pair {
        int y, x, dist;
        String str;
        Pair(int y, int x, int dist, String str) {
            this.y = y;
            this.x = x;
            this.dist = dist;
            this.str = str;
        }
    }
    
    static int N,M;
    static int[] dy = {1,0,0,-1};
    static int[] dx = {0,-1,1,0};
    static String[] wx = {"d", "l", "r", "u"};
    static int sy,sx,ey,ex;
    static boolean temp = false;
    static String answer = "impossible";
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        
        N = n; M = m;
        sy = x - 1;
        sx = y - 1;
        ey = r - 1;
        ex = c - 1;
        
        dfs(sy,sx,k,"");
                
        return answer;
    }
    
    static void dfs(int y, int x, int cnt, String str) {
            
        if(temp || cnt < 0) return;
        // System.out.println("y = " + y + " x = " + x + " str = " + str);
        if(y == ey && x == ex && cnt == 0) {
            answer = str;
            temp = true;
            return;
        }
        
        for(int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            String s = wx[i];
            
            if(!inRange(ny,nx)) continue;
            if(!canArrive(ny,nx,cnt-1)) continue;
            
            dfs(ny, nx, cnt-1, str + s);
        }
    }
    
    static boolean canArrive(int y, int x, int cnt) {
        int d = getD(y, x, ey, ex);
        if(d > cnt || (cnt - d) % 2 == 1) return false;
        return true;
    }
    
    static int getD(int y, int x, int ty, int tx) {
        return Math.abs(y-ty) + Math.abs(x-tx);
    }
    
    static boolean inRange(int y, int x) {
        return 0 <= y && y < N && 0 <= x && x < M;
    }
}