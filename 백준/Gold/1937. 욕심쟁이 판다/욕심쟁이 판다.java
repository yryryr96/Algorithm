import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] board, dp;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = stoi(br.readLine());
        board = new int[N][N];
        dp = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = stoi(st.nextToken());
            }
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (dp[i][j] == 0) {
                    dp[i][j] = dfs(i, j);
                }
                answer = Math.max(answer, dp[i][j]);
            }
        }

        System.out.println(answer);
    }

    static int dfs(int row, int col) {

        if (dp[row][col] != 0) {
            return dp[row][col];
        }

        int count = 1;
        for (int d = 0; d < 4; d++) {
            int nr = row + dr[d];
            int nc = col + dc[d];

            if (!inRange(nr, nc)) continue;
            if (board[nr][nc] <= board[row][col]) continue;

            int v = dfs(nr,nc);
            count = Math.max(count, v + 1);
        }

        dp[row][col] = count;
        return dp[row][col];
    }

    static boolean inRange(int r, int c) {
        return 0 <= r && r < N && 0 <= c && c < N;
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}