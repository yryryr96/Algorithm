import java.io.*;
import java.util.*;

public class Main {

    static int[] dy = {0,0,-1,1};
    static int[] dx = {-1,1,0,0};
    static int N;
    static int[][] dp, forest;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = stoi(br.readLine());

        // n <= 500, forest[row][col] <= 1,000,000
        forest = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                forest[i][j] = stoi(st.nextToken());
            }
        }

        dp = new int[N][N];
        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (dp[i][j] == 0) {
                    dfs(i,j);
                }
                answer = Math.max(answer, dp[i][j]);
            }
        }

        System.out.println(answer);
    }

    static int dfs(int row, int col) {

        if (dp[row][col] != 0) return dp[row][col];

        int count = 1;
        for (int d = 0; d < 4; d++) {
            int nr = row + dy[d];
            int nc = col + dx[d];
            if (!inRange(nr, nc)) continue;
            if (forest[nr][nc] <= forest[row][col]) continue;

            int v = dfs(nr, nc);
            count = Math.max(count, v + 1);
        }

        dp[row][col] = count;
        return count;
    }

    static boolean inRange(int y, int x) {
        return 0 <= y && y < N && 0 <= x && x < N;
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
