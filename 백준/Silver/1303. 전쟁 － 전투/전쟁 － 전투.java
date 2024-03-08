import java.io.*;
import java.util.*;

public class Main {

    static int n,m;
    static char[][] map;
    static int me, enemy;
    static boolean[][] visited;
    static int[] di = {0,0,1,-1};
    static int[] dj = {1,-1,0,0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j]) continue;
                bfs(i,j);
            }
        }

        System.out.println(me + " " + enemy);
    }

    static void bfs(int y, int x) {

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(y,x));
        visited[y][x] = true;

        int score = 0;
        char target = map[y][x];

        while(!q.isEmpty()) {

            Pair p = q.poll();
            int i = p.y; int j = p.x;

            score++;

            for (int k = 0; k < 4; k++) {
                int ni = i + di[k];
                int nj = j + dj[k];

                if (0 > ni || 0 > nj || ni >= n || nj >= m || visited[ni][nj]) continue;
                if (map[ni][nj] == target) {
                    visited[ni][nj] = true;
                    q.add(new Pair(ni,nj));
                }
            }
        }

        if (target == 'W') me += Math.pow(score,2);
        else enemy += Math.pow(score,2);
    }

    static class Pair {

        int y,x;

        Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}