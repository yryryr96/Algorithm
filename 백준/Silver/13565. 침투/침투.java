import java.io.*;
import java.util.*;

public class Main {

    static int n,m;
    static char[][] map;
    static boolean[][] visited;
    static int[] dy = {0,0,1,-1};
    static int[] dx = {1,-1,0,0};
    static class Pair {
        int y,x;
        Pair (int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    static String ans = "NO";

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < m; i++) {
            if (!visited[0][i] && map[0][i] == '0') {
                bfs(i);
            }
        }

        System.out.println(ans);
    }

    static void bfs(int start) {

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, start));
        visited[0][start] = true;

        while (!q.isEmpty()) {
            Pair now = q.poll();

            if (now.y == n-1) {
                ans = "YES";
                return;
            }

            for (int k = 0; k < 4; k++) {
                int ny = now.y + dy[k];
                int nx = now.x + dx[k];
                if (0 > ny || 0 > nx || ny >= n || nx >= m || visited[ny][nx]) continue;
                if (map[ny][nx] == '0') {
                    q.add(new Pair(ny,nx));
                    visited[ny][nx] = true;
                }
            }
        }
    }
}