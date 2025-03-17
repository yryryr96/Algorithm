import java.io.*;
import java.util.*;

public class Main {

    static int N,M;
    static int[][] board;
    static boolean[][] visited;
    static int[] dr = {1, 0};
    static int[] dc = {0, 1};
    static boolean canArrive = false;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = stoi(st.nextToken());
        N = stoi(st.nextToken());
        board = new int[N][M];
        visited = new boolean[N][M];

        for (int row = 0; row < N; row++) {
            st = new StringTokenizer(br.readLine());
            for (int col = 0; col < M; col++) {
                board[row][col] = stoi(st.nextToken());
            }
        }

        visited[0][0] = true;
        dfs(0,0);
        String answer = canArrive ? "Yes" : "No";
        System.out.println(answer);
    }

    static void dfs(int row, int col) {

        if (canArrive) {
            return;
        }

        if (row == N-1 &&  col == M-1) {
            canArrive = true;
            return;
        }

        for (int d = 0; d < 2; d++) {
            int nr = row + dr[d];
            int nc = col + dc[d];
            if (!inRange(nr, nc)) continue;
            if (visited[nr][nc]) continue;
            if (board[nr][nc] == 0) continue;

            visited[nr][nc] = true;
            dfs(nr, nc);
        }
    }

    static boolean inRange(int row, int col) {
        return 0 <= row && row < N && 0 <= col && col < M;
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}