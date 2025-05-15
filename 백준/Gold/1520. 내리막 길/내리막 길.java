import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, M, H;
    static int[][] board, dp;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        board = new int[N][M];
        dp = new int[N][M];

        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], -1);
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = stoi(st.nextToken());
            }
        }

        System.out.println(dfs(0, 0));

    }

    static int dfs(int row, int col) {

        if (row == N-1 && col == M-1) {
            return 1;
        }

        if (dp[row][col] != -1) {
            return dp[row][col];
        }

        int path = 0;
        for (int d = 0; d < 4; d++) {
            int nr = row + dr[d];
            int nc = col + dc[d];

            if (inRange(nr, nc) && board[nr][nc] < board[row][col]) {
                path += dfs(nr, nc);
            }
        }

        dp[row][col] = path;
        return dp[row][col];
    }

    static boolean inRange(int r, int c) {
        return 0 <= r && r < N && 0 <= c && c < M;
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}