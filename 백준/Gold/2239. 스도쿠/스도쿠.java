import java.io.*;
import java.util.*;

public class Main {

    static int n = 9;
    static int[][] map = new int[n][n];
    static int zeroCnt = 0;
    static boolean temp = false;
    static int[][] centerInfo = {{1,1}, {1,4}, {1,7}, {4,1}, {4,4}, {4,7}, {7,1}, {7,4}, {7,7}};
    static int[] di = {0,0,1,-1,1,1,-1,-1};
    static int[] dj = {1,-1,0,0,1,-1,1,-1};
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int si = -1;
        int sj = -1;
        
        for (int i = 0; i < n; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(split[j]);
                if (map[i][j] == 0) {
                    if (si == -1 && sj == -1) {
                        si = i; sj = j;
                    }
                    zeroCnt++;
                }
            }
        }
//        System.out.println(isPossible(1,4,3));
        dfs(0, si, sj);
    }

    static void dfs(int depth, int r, int c) {

        if (temp) return;
        if (depth == zeroCnt) {

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    sb.append(map[i][j]);
                }
                sb.append("\n");
            }

            System.out.println(sb.toString());
            System.exit(0);
            return;
        }

        for (int i = r; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 0) {
                    for (int k = 1; k <= 9; k++) {
                        //가로, 세로, 블럭 체크
                        if (isPossible(i,j,k)){
                            map[i][j] = k;
                            dfs(depth+1, i, j);
                            map[i][j] = 0;
                        }
                    }
                    return;
                }
            }
        }
    }

    static boolean isPossible(int r, int c, int num) {
        // 열 체크, 행 체크
        for (int j = 0; j < n; j++) {
            if (map[r][j] == num || map[j][c] == num) return false;
        }


        // 블럭 체크
        int ci = 0;
        int cj = 0;
        int dist = Integer.MAX_VALUE;
        for (int[] center : centerInfo) {
            int sum = Math.abs(r-center[0]) + Math.abs(c-center[1]);
            if (dist > sum) {
                dist = sum;
                ci = center[0];
                cj = center[1];
            }
        }

        if (map[ci][cj] == num) return false;

        for (int i = 0; i < 8; i++) {
            int ni = ci + di[i];
            int nj = cj + dj[i];
            if (map[ni][nj] == num) return false;
        }
        return true;
    }
}