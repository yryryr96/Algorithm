import java.io.*;
import java.util.*;

public class Main {

    static int n,m;
    static int[][] map;
    static int pictureCnt = 0;
    static int maxPictureWidth = 0;
    static int[] di = {0,0,1,-1};
    static int[] dj = {1,-1,0,0};
    static class Pair {
        int i,j;
        Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }


    static boolean[][] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visited = new boolean[n][m];
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    bfs(i,j);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(pictureCnt + "\n" + maxPictureWidth);
        System.out.println(sb.toString());
    }

    static void bfs(int si, int sj) {

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(si,sj));
        visited[si][sj] = true;

        int cnt = 1;
        while(!q.isEmpty()) {

            Pair p = q.poll();
            int i = p.i; int j = p.j;

            for (int k = 0; k < 4; k++) {
                int ni = i + di[k];
                int nj = j + dj[k];

                if (0 > ni || 0 > nj || ni >= n || nj >= m || visited[ni][nj] || map[ni][nj] == 0) continue;
                visited[ni][nj] = true;
                q.add(new Pair(ni,nj));
                cnt++;
            }
        }

        pictureCnt++;
        maxPictureWidth = Math.max(maxPictureWidth, cnt);
    }
}