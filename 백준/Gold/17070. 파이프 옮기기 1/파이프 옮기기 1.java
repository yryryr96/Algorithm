import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int[][] map;
    static int ROW = 1;
    static int COL = 2;
    static int CROSS = 3;
    static int[][] dir = {{0,1}, {1,0}, {1,1}};
    static int ans = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = sToi(br.readLine());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = sToi(st.nextToken());
            }
        }

        dfs(0,0,0,1,ROW);
        System.out.println(ans);
    }

    static int sToi(String s) {
        return Integer.parseInt(s);
    }

    static void dfs(int si, int sj, int ei, int ej, int type) {

//        System.out.println("si = " + si + " sj = " + sj + " ei = " + ei + " ej = " + ej + " type = " + type);
        if (ei == n-1 && ej == n-1) {
            ans++;
            return;
        }

        int temp = normalEmptyCheck(ei,ej,type);
//        System.out.println("temp = " + temp);
        if (temp == 0) {
            dfs(ei,ej, ei, ej + 1, ROW);
            dfs(ei, ej, ei+1, ej, COL);
        } else if (temp == ROW) {
            dfs(ei, ej, ei, ej+1, ROW);
        } else if (temp == COL) {
            dfs(ei, ej, ei+1, ej, COL);
        }

        if (crossEmptyCheck(ei,ej)) {
            dfs(ei,ej,ei+1,ej+1, CROSS);
        }
    }

    static int normalEmptyCheck(int i, int j, int type) {

        if (type == ROW) {
            if (j + 1 < n && map[i][j+1] == 0) return ROW;
        }

        if (type == COL) {
            if (i+1 < n && map[i+1][j] == 0) return COL;
        }

        if (type == CROSS) {
            if (i+1 < n && j+1 < n && map[i+1][j] == 0 && map[i][j+1] == 0) return 0;
            if (j+1 < n && map[i][j+1] == 0) return ROW;
            if (i+1 < n && map[i+1][j] == 0) return COL;
        }

        return -1;
    }

    static boolean crossEmptyCheck (int i, int j) {

        for (int k = 0; k < 3; k++) {
            int ni = i + dir[k][0];
            int nj = j + dir[k][1];
            if (ni >= n || nj >= n || map[ni][nj] == 1) return false;
        }

        return true;
    }
}