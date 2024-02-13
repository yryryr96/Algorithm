import java.util.*;
import java.io.*;

public class Main {

    static int[] di = {-2,-2,0,0,2,2};
    static int[] dj = {-1,1,-2,2,-1,1};
    static int n;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Queue<Pair> q = new LinkedList<>();
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int r1 = Integer.parseInt(st.nextToken());
        int c1 = Integer.parseInt(st.nextToken());
        int r2 = Integer.parseInt(st.nextToken());
        int c2 = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][n];
        map[r1][c1] = 1;
        q.add(new Pair(r1,c1));
        System.out.println(bfs(q, map, r2, c2));
    }

    public static int bfs(Queue<Pair> q, int[][] map, int r, int c) {

        while (!q.isEmpty()) {
            Pair p = q.poll();
            int i = p.y; int j = p.x;

            if (i == r && j == c) {
                return map[i][j]-1;
            }
            for (int k = 0; k < 6; k++) {
                int ni = i + di[k]; int nj = j + dj[k];
                if (0<=ni && ni < n && 0<=nj && nj < n && map[ni][nj] == 0) {
                    q.add(new Pair(ni,nj));
                    map[ni][nj] = map[i][j] + 1;
                }
            }
        }

        return -1;
    }

    public static class Pair {
        int x,y;
        public Pair(int y, int x) {
            this.x = x;
            this.y = y;
        }
    }
}
