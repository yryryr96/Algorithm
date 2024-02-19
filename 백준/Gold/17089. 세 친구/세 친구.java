import java.util.*;
import java.io.*;

public class Main {

    static int[] visited_cnt;
    static boolean[][] visited;
    static int n;
    static int m;
    static StringTokenizer st;
    static BufferedReader br;
    static int MIN = 15000;

    public static void main(String[] args) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        init();
        valid();
        if (MIN == 15000) System.out.println(-1);
        else System.out.println(MIN);
    }

    static void init() throws IOException {

        visited_cnt = new int[n+1];
        visited = new boolean[n+1][n+1];

        for (int i = 0; i < m; i++) {

            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            visited[a][b] = true;
            visited[b][a] = true;
            visited_cnt[a] += 1;
            visited_cnt[b] += 1;
        }
    }

    static void valid() {

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < n+1; j++) {
                if (!visited[i][j]) continue;
                for (int k = 1; k < n+1; k++) {
                    if (visited[i][k] && visited[k][j]) {
                        MIN = Math.min(visited_cnt[i] + visited_cnt[j] + visited_cnt[k] - 6, MIN);
                    }
                }
            }
        }
    }
}