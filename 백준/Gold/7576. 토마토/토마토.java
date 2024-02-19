import java.util.*;
import java.io.*;

public class Main {

    static int[] di = {1,-1,0,0};
    static int[] dj = {0,0,1,-1};
    static StringTokenizer st;
    static int[][] visited;
    static String[][] map;
    static BufferedReader br;
    static Queue<Pair> q = new ArrayDeque<>();
    static int n;
    static int m;
    static int ans;

    public static void main(String[] args) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        init();
        bfs();
        System.out.println(valid());
    }

    public static int valid() {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j].equals("-1")) continue;
                if (visited[i][j] == -1) return -1;
                ans = Math.max(ans, visited[i][j]);
            }
        }

        return ans;
    }

    public static class Pair {
        int y,x;

        Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void init() throws IOException {

        map = new String[n][m];
        visited = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = st.nextToken();
                if (map[i][j].equals("1")) {
                    visited[i][j] = 0;
                    q.add(new Pair(i,j));
                } else {
                    visited[i][j] = -1;
                }
            }
        }
    }

    public static void bfs() {

        while (!q.isEmpty()) {

            Pair p = q.poll();
            int i = p.y;
            int j = p.x;

            for (int k = 0; k < 4; k++) {
                int ni = i + di[k]; int nj = j + dj[k];
                if (0 > ni || n <= ni || 0 > nj || m <= nj || visited[ni][nj] != -1) continue;
                if (map[ni][nj].equals("0")) {
                    visited[ni][nj] = visited[i][j] + 1;
                    q.add(new Pair(ni,nj));
                }
            }
        }
    }
}