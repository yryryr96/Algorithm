import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N,M;
    static int[][] dp;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,1,-1};
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = stoi(st.nextToken());
        M = stoi(st.nextToken());

        dp = new int[N][M];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], -1);
        }

        int[][] board = new int[N][M];
        for (int row = 0; row < N; row++) {
            st = new StringTokenizer(br.readLine());
            for (int col = 0; col < M; col++) {
                board[row][col] = stoi(st.nextToken());
            }
        }

        int answer = dfs(board, 0, 0);
        System.out.println(answer);
    }

    static int dfs(int[][] board, int row, int col) {
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
            if(!inRange(nr, nc)) {
                continue;
            }
            if (board[nr][nc] >= board[row][col]) {
                continue;
            }

            path += dfs(board, nr, nc);
        }

        dp[row][col] = path;
        return path;
    }

    static boolean inRange(int y, int x) {
        return 0 <= y && y < N && 0 <= x && x < M;
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
