import java.util.*;
import java.io.*;

public class Main {

    static int w,h;
    static String[][] map;
    static int[] di = {0,1,0,-1};
    static int[] dj = {1,0,-1,0};
    static int[][][] visited;
    static int ans = 10000;
    static List<Node> targets = new ArrayList<>();
    static int si,sj,ei,ej;
    static PriorityQueue<Node> q = new PriorityQueue<>((a,b) -> a.mirror - b.mirror);

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        map = new String[h][w];
        visited = new int[h][w][4];

        int cnt = 0;
        for (int i = 0; i < h; i++) {
            map[i] = br.readLine().split("");
            for (int j = 0; j < w; j++) {
                for (int k = 0; k < 4; k++) {
                    visited[i][j][k] = 10000;
                }
                if (map[i][j].equals("C")) {
                    cnt++;
                    if (cnt == 1) {
                        si = i; sj = j;
                    } else {
                        ei = i; ej = j;
                    }
                }
            }
        }

        for (int i = 0; i < 4; i++) {
            q.add(new Node(0, si, sj, i));
            visited[si][sj][i] = 0;
        }

        bfs();
        System.out.println(ans);

    }

    static void bfs() {

        while(!q.isEmpty()) {

            Node node = q.poll();
            int m = node.mirror; int i = node.y; int j = node.x; int dir = node.d;

            if (i == ei && j == ej) {
                ans = Math.min(ans, visited[i][j][dir]);

                continue;
            }

            for (int k = 0; k < 4; k++) {
                int ni = i + di[k]; int nj = j + dj[k];
                if (0 > ni || ni >= h || 0 > nj || nj >= w || map[ni][nj].equals("*")) continue;

                if (dir == k && visited[ni][nj][k] > m) {
                    visited[ni][nj][k] = m;
                    q.add(new Node(m, ni, nj, k));
                } else if (dir != k && visited[ni][nj][k] > m+1) {
                    visited[ni][nj][k] = m+1;
                    q.add(new Node(m+1, ni, nj, k));
                }
            }
        }
    }

    static class Node {
        int mirror, y, x, d;

        Node (int mirror, int y, int x, int d) {
            this.mirror = mirror;
            this.y = y;
            this.x = x;
            this.d = d;
        }
    }
}