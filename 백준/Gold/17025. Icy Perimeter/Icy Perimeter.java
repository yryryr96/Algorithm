
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int N, maxWidth, minBorder;
    static String DOT = ".";
    static boolean[][] visited;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static String[][] map;
    static class Pair {
        int y, x;
        Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = stoi(br.readLine());
        maxWidth = 0;
        minBorder = Integer.MAX_VALUE;
        map = new String[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                map[i][j] = input[j];
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && map[i][j].equals("#")) {
                    bfs(i, j);
                }
            }
        }

        System.out.println(maxWidth + " " + minBorder);
    }

    static void bfs(int y, int x) {

        Queue<Pair> q = new LinkedList<>();
        visited[y][x] = true;
        q.add(new Pair(y, x));

        int width = 0;
        int border = 0;

        while(!q.isEmpty()) {

            Pair cur = q.poll();

            width++;
            border += getBorder(cur.y, cur.x);

            for (int d = 0; d < 4; d++) {
                int ny = cur.y + dy[d];
                int nx = cur.x + dx[d];

                if(!isInRange(ny, nx)) continue;
                if(visited[ny][nx]) continue;
                if(map[ny][nx].equals(DOT)) continue;

                visited[ny][nx] = true;
                q.add(new Pair(ny, nx));
            }
        }

        if (width > maxWidth) {
            maxWidth = width;
            minBorder = border;
        } else if (width == maxWidth) {
            minBorder = Math.min(minBorder, border);
        }
    }

    static int getBorder(int y, int x) {

        int border = 0;
        for (int d = 0; d < 4; d++) {
            int ny = y + dy[d];
            int nx = x + dx[d];
            if(!isInRange(ny, nx) || map[ny][nx].equals(DOT)) {
                border++;
            }
        }

        return border;
    }

    static boolean isInRange(int y , int x) {
        return 0 <= y && y < N && 0 <= x && x < N;
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
