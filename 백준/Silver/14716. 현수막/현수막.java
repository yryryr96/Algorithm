import java.io.*;
import java.util.*;

public class Main {

    static int n,m;
    static int[][] map;
    static boolean[][] visited;
    static int[] di = {0,0,1,-1,1,1,-1,-1};
    static int[] dj = {1,-1,0,0,1,-1,1,-1};
    static class Pair {
        int y,x;
        Pair (int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    cnt++;
                    bfs(i,j);
                }
            }
        }

        System.out.println(cnt);
    }

    static void bfs(int r, int c) {

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(r,c));
        visited[r][c] = true;

        while (!q.isEmpty()) {

            Pair p = q.poll();
            int i = p.y; int j = p.x;

            for (int k = 0; k < 8; k++) {
                int ni = i + di[k];
                int nj = j + dj[k];
                if (0 > ni || 0 > nj || ni >= n || nj >= m || visited[ni][nj]) continue;
                if (map[ni][nj] == 1) {
                    visited[ni][nj] = true;
                    q.add(new Pair(ni,nj));
                }
            }
        }
    }
}