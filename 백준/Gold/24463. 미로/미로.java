import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M;
    static String[][] map;
    static class Pair {
        int y, x;
        Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }

        boolean equals(Pair other) {
            return this.y == other.y && this.x == other.x;
        }
    }

    static List<Pair> targets = new ArrayList<>();
    static Pair start, end;
    static Pair[][] paths;
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        map = new String[N][M];
        paths = new Pair[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                map[i][j] = input[j];
                if (i == 0 || i == N - 1 || j == 0 || j == M - 1) {
                    if (map[i][j].equals(".")) {
                        targets.add(new Pair(i, j));
                    }
                }
            }
        }

        start = targets.get(0);
        end = targets.get(1);

        bfs();
        findPath();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j].equals(".") && !visited[i][j]) {
                    sb.append("@");
                } else {
                    sb.append(map[i][j]);
                }
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    static void initVisited() {

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = false;
            }
        }
    }

    static void findPath() {

        initVisited();

        Stack<Pair> st = new Stack<>();
        st.push(end);
        visited[end.y][end.x] = true;

        Pair pre = end;
        while (pre != start) {

            pre = paths[pre.y][pre.x];
            visited[pre.y][pre.x] = true;
            st.push(pre);
        }
    }

    static void bfs() {

        Queue<Pair> q = new LinkedList<>();
        q.add(start);
        visited[start.y][start.x] = true;

        while(!q.isEmpty()) {

            Pair cur = q.poll();

            if (end.equals(cur)) {
                // 도착 지점에 도달
                return;
            }

            for (int d = 0; d < 4; d++) {
                int ny = cur.y + dy[d];
                int nx = cur.x + dx[d];

                if (!isInRange(ny, nx)) continue;
                if (visited[ny][nx] || map[ny][nx].equals("+")) continue;

                q.add(new Pair(ny, nx));
                visited[ny][nx] = true;
                paths[ny][nx] = cur;
            }
        }


    }

    static boolean isInRange(int y, int x) {
        return 0 <= y && y < N && 0 <= x && x < M;
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
