import java.util.*;
class Solution {
    
    static int[] dy = {0,1,0,-1};
    static int[] dx = {1,0,-1,0};
    static int[][] board;
    
    public int[] solution(int rows, int columns, int[][] queries) {
        
        int[] answer = new int[queries.length];
        board = new int[rows][columns];
        int num = 1;
        
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                board[i][j] = num;
                num++;
            }
        }
        
        for(int i = 0; i < queries.length; i++) {
            answer[i] = rotate(queries[i]);
        }
        
        return answer;
    }
    
    static int rotate(int[] query) {
        
        int sy = query[0] - 1;
        int sx = query[1] - 1;
        int ey = query[2] - 1;
        int ex = query[3] - 1;
        
        int y = sy;
        int x = sx;
        
        int k = 0;
        int tmp = board[sy+1][sx];
        int v = Integer.MAX_VALUE;
        
        while(true) {
            
            v = Math.min(v, board[y][x]);
            int ny = y + dy[k%4];
            int nx = x + dx[k%4];
            if(!inRange(ny, nx, sy, sx, ey, ex)) {
                k++;
                continue;
            }
            
            int nTmp = board[y][x];
            board[y][x] = tmp;
            tmp = nTmp;
            
            y = ny;
            x = nx;
            
            if(y == sy && x == sx) break;
        }
        
        return v;
    }
    
    static boolean inRange(int y, int x, int sy, int sx, int ey, int ex) {
        return sy <= y && y <= ey && sx <= x && x <= ex;
    }
}