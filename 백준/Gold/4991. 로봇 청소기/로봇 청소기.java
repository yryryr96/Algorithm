import java.util.*;
import java.io.*;

public class Main {

    static int n,m;
    static StringTokenizer st;
    static char[][] map;
    static boolean[] permu_visited;
    static int[][][] visited;
    static int ans;
    static List<Pair> dirty;
    static int si,sj;
    static int[] di = {0,0,-1,1};
    static int[] dj = {1,-1,0,0};
    static int[][][][] dist;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while ((st = new StringTokenizer(br.readLine())) != null) {

            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());

            if (n == 0 && m == 0) break;

            dirty = new ArrayList<>();
            map = new char[n][m];
            ans = Integer.MAX_VALUE;;
            dist = new int[n][m][n][m];

            for (int i = 0; i < n; i++) {
                map[i] = br.readLine().toCharArray();
                for (int j = 0; j < m; j++) {
                    if (map[i][j] == '*') dirty.add(new Pair(i,j));
                    else if (map[i][j] == 'o') {
                        si = i;
                        sj = j;
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    bfs(i,j);
                }
            }

            permu_visited = new boolean[dirty.size()];
            List<Pair> stack = new ArrayList<>();
            permu(0, stack);

            ans = ans == Integer.MAX_VALUE ? -1 : ans;
            System.out.println(ans);
        }
    }

    static void bfs(int y, int x) {

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(y,x));

        while (!q.isEmpty()) {
            Pair p = q.poll();
            int i = p.y; int j = p.x;

            for (int k = 0; k < 4; k++) {
                int ni = i + di[k];
                int nj = j + dj[k];

                if (0 > ni || ni >= n || 0 > nj || nj >= m || dist[y][x][ni][nj] != 0) continue;
                if (map[ni][nj] == 'x') continue;

                dist[y][x][ni][nj] = dist[y][x][i][j] + 1;
                q.add(new Pair(ni,nj));
            }
        }
    }

    static void permu(int depth, List<Pair> stack) {

        if (depth == dirty.size()) {
            int distance = dist[si][sj][stack.get(0).y][stack.get(0).x];
            for (int i = 0; i < stack.size()-1; i++) {
                int dis = dist[stack.get(i).y][stack.get(i).x][stack.get(i+1).y][stack.get(i+1).x];
                if (dis == 0) return;
                distance += dis;
            }
            if (distance == 0) return;

            ans = Math.min(distance, ans);
            return;
        }

        for (int i = 0; i < dirty.size(); i++) {
            if (!permu_visited[i]) {
                permu_visited[i] = true;
                stack.add(dirty.get(i));
                permu(depth+1, stack);
                stack.remove(stack.size()-1);
                permu_visited[i] = false;
            }
        }
    }

    static class Pair {
        int y,x;

        Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}