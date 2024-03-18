import java.io.*;
import java.util.*;

public class Main {

    static int n,m;
    static int si,sj;
    static char[][] campus;
    static int[] di = {0,0,1,-1};
    static int[] dj = {1,-1,0,0};
    static class Pair {
        int y,x;
        Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        campus = new char[n][m];

        for (int i = 0; i < n; i++) {
            campus[i] = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                if (campus[i][j] == 'I') {
                    si = i; sj = j;
                }
            }
        }

        System.out.println(bfs());
    }

    static String bfs() {

        Queue<Pair> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];

        q.add(new Pair(si,sj));
        visited[si][sj] = true;

        int cnt = 0;
        while(!q.isEmpty()) {

            Pair p = q.poll();
            int i = p.y; int j = p.x;

            if (campus[i][j] == 'P') cnt++;
            for (int k = 0; k < 4; k++) {
                int ni = i + di[k];
                int nj = j + dj[k];
                if (0 > ni || 0 > nj || ni >= n || nj >= m) continue;
                if (!visited[ni][nj] && campus[ni][nj] != 'X') {
                    q.add(new Pair(ni,nj));
                    visited[ni][nj] = true;
                }
            }
        }

        return cnt == 0 ? "TT" : String.valueOf(cnt);
    }
}