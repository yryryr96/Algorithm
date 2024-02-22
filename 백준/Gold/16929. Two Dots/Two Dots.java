import java.util.*;
import java.io.*;

public class Main {

    static int n,m;
    static String[][] map;
    static int[] di = {0,1,0,-1};
    static int[] dj = {1,0,-1,0};
    static boolean[][] visited;
    static String ans = "No";

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new String[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().split("");
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (ans.equals("Yes")) break;
                visited[i][j] = true;
                simul(i, j, i, j, 1);
                visited[i][j] = false;
            }
            if (ans.equals("Yes")) break;
        }

        System.out.println(ans);
    }

    static void simul(int si, int sj, int i, int j, int depth) {

        if (ans.equals("Yes")) return;
        for (int k = 0; k < 4; k++) {

            int ni = i + di[k]; int nj = j + dj[k];
            if (0 > ni || n <= ni || 0 > nj || m <= nj || !map[ni][nj].equals(map[i][j])) continue;
            if (depth >= 4 && ni == si && nj == sj) {
                ans = "Yes";
                return;
            }

            if (!visited[ni][nj]) {
                visited[ni][nj] = true;
                simul(si, sj, ni, nj, depth+1);
                visited[ni][nj] = false;
            }
        }

    }
}