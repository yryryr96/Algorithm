import java.util.*;
import java.io.*;

public class Main {

    static int n,k;
    static char[][] map;
    static boolean[][] visited;
    static int ans = 0;
    static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new char[2][n];
        visited = new boolean[2][n];

        for (int i = 0; i < 2; i++) {
            map[i] = br.readLine().toCharArray();
        }

        bfs();
        System.out.println(ans);
    }

    static void bfs() {

        q.add(new int[]{-1,0,0});
        visited[0][0] = true;

        while (!q.isEmpty()) {

            int[] p = q.poll();
            int depth = p[0]; int i = p[1]; int j = p[2];
//            System.out.println("depth = " + depth + " i = " + i + " j = " + j);

            if (j - 1 > depth + 1 && map[i][j-1] == '1' && !visited[i][j-1]) {
                visited[i][j-1] = true;
                q.add(new int[]{depth+1, i, j-1});
            }

            if (j + 1 > depth + 1) {

                if (j+1 >= n) {
                    ans = 1;
                    return;
                }

                if (map[i][j+1] == '1' && !visited[i][j+1]) {
                    visited[i][j+1] = true;
                    q.add(new int[]{depth+1, i, j+1});
                }
            }

            i = i == 1 ? 0 : 1;
            if (j+k > depth + 1) {

                if (j+k >= n) {
                    ans = 1;
                    return;
                }

                if (map[i][j+k] == '1' && !visited[i][j+k]) {
                    visited[i][j+k] = true;
                    q.add(new int[]{depth+1, i, j+k});
                }
            }
        }
    }
}