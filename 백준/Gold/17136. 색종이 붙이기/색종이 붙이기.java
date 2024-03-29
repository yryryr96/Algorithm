import java.io.*;
import java.util.*;

public class Main {

    static int n = 10;
    static int[][] map = new int[n][n];
    static int[] paperCnt = new int[6];
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Arrays.fill(paperCnt,5);
        dfs(0,0,0);
        ans = ans == Integer.MAX_VALUE ? -1 : ans;
        System.out.println(ans);
    }

    static void dfs(int y, int x, int cnt) {

        if (y == 9 && x == 10) {
            ans = Math.min(ans, cnt);
            return;
        }

        if (ans <= cnt) {
            return;
        }

        if (x == 10) {
            dfs(y+1, 0, cnt);
            return;
        }

        if (map[y][x] == 1) {
            for (int i = 5; i >= 1 ; i--) {
                if (paperCnt[i] > 0 && isAttach(y,x,i)) {
                    attach(y,x,i,0);
                    paperCnt[i]--;
                    dfs(y, x+1, cnt+1);
                    paperCnt[i]++;
                    attach(y,x,i,1);
                }
            }
        } else {
            dfs(y, x+1, cnt);
        }
    }

    static void attach(int y, int x, int size, int state) {
        for (int i = y; i < y+size; i++) {
            for (int j = x; j < x+size; j++) {
                map[i][j] = state;
            }
        }
    }

    static boolean isAttach(int y, int x, int size) {

        for (int i = y; i < y+size; i++) {
            for (int j = x; j < x+size; j++) {

                if (i >= n || j >= n) return false;
                if (map[i][j] == 0) return false;
            }
        }

        return true;
    }
}