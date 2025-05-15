import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N,M,K;
    static int[][] board;
    static boolean[][] visited;
    static int answer = 0;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        K = stoi(st.nextToken());
        board = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = stoi(st.nextToken()) - 1;
            int c = stoi(st.nextToken()) - 1;
            board[r][c] = 1;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 1 && !visited[i][j]) {
                    visited[i][j] = true;
                    answer = Math.max(answer, dfs(i, j));
                }
            }
        }

        System.out.println(answer);
    }

    static int dfs(int row, int col) {

        int count = 1;
        for (int d = 0; d < 4; d++) {
            int nr = row + dr[d];
            int nc = col + dc[d];

            if(!inRange(nr, nc)) continue;
            if(board[nr][nc] != 1) continue;
            if(visited[nr][nc]) continue;

            visited[nr][nc] = true;
            count += dfs(nr, nc);
        }

        return count;
    }

    static boolean inRange(int r, int c) {
        return 0 <= r && r < N && 0 <= c && c < M;
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}