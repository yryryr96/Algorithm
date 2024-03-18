import java.io.*;
import java.util.*;

public class Main {

    // 7개의 연속된 블럭 중에 S가 최소 4개이상인 경우의 수
    // 25개 중 7개 조합 구하기 dfs -> 7개 좌표가 이어지는지 bfs
    static int n = 5;
    static int m = 5;
    static int[] di = {0,1,0,-1};
    static int[] dj = {1,0,-1,0};
    static char[][] map = new char[n][m];
    static int MAX_DEPTH = 7;
    static int[] crew = new int[25];
    static class Pair {
        int y,x;
        Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    static int ans = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        dfs(0,0,0);
        System.out.println(ans);
    }

    static void dfs(int depth, int start, int yCnt) {

        if (yCnt > 3) return;
        if (depth == MAX_DEPTH) {
            bfs();
            return;
        }

        for (int i = start; i < 25; i++) {
            crew[depth] = i;
            dfs(depth+1, i+1, map[i/5][i%5] == 'Y' ? yCnt + 1 : yCnt);
        }
    }

    static void bfs() {

        Queue<Pair> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];

        int a = crew[0] / 5; int b = crew[0] % 5;

        visited[a][b] = true;
        q.add(new Pair(a,b));

        int cnt = 1;
        while(!q.isEmpty()) {

            Pair p = q.poll();
            int i = p.y; int j = p.x;

            for (int k = 0; k < 4; k++) {
                int ni = i + di[k];
                int nj = j + dj[k];

                if (0 > ni || 0 > nj || ni >= n || nj >= m || visited[ni][nj]) continue;
                for (int l = 0; l < MAX_DEPTH; l++) {
                    if (ni == crew[l] / 5 && nj == crew[l] % 5) {
                        q.add(new Pair(ni,nj));
                        visited[ni][nj] = true;
                        cnt++;
                    }
                }
            }
        }

        if (cnt == MAX_DEPTH) ans++;
    }
}