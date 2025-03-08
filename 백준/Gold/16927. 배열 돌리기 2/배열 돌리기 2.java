import java.io.*;
import java.util.*;

public class Main {

    static int N, M, R;
    static int[][] board;
    static int[][][] dp;
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        R = stoi(st.nextToken());
        board = new int[N][M];
        dp = new int[(N+M)*2 - 3][N][M];

        for (int row = 0; row < N; row++) {
            st = new StringTokenizer(br.readLine());
            for (int col = 0; col < M; col++) {
                board[row][col] = stoi(st.nextToken());
            }
        }

        for (int i = 1; i <= R; i++) {
            if((N+M)*2 - 3 < i) break;
            rotate(i);
        }

        int depthLimit = Math.min(N,M)/2 - 1;
        for (int depth = 0; depth <= depthLimit; depth++) {
            int p = ((N - depth*2) + (M - depth*2)) * 2 - 4;
            refreshBoard(depth, R%p);
        }

        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < M; col++) {
                sb.append(board[row][col]).append(" ");
            }
            sb.append('\n');
        }

        System.out.println(sb.toString());
    }

    static void rotate(int r) {
        int depthLimit = Math.min(N,M)/2 - 1;
        for (int depth = 0; depth <= depthLimit; depth++) {
            int p = ((N - depth*2) + (M - depth*2)) * 2 - 4;
//            System.out.println("r%p = " + r%p);
//            System.out.println("r = " + r);
//            System.out.println("p = " + p);
            if (dp[r%p][depth][depth] == 0) {
                // dp 값 활용
                initDp(depth, r%p);
                refreshBoard(depth, r%p);
            } 
        }
    }

    static void refreshBoard(int depth, int v) {
        board[depth][depth] = dp[v][depth][depth];
        int cy = depth;
        int cx = depth;

        int d = 0;
        while (true) {

            int ny = cy + dy[d];
            int nx = cx + dx[d];
            if (ny < depth || nx < depth || ny >= N-depth || nx >= M-depth) {
                d++;
                ny = cy + dy[d];
                nx = cx + dx[d];
            }

            if (ny == depth && nx == depth) {
                break;
            }

            board[ny][nx] = dp[v][ny][nx];
//            System.out.println("v = " + v);
//            System.out.println("dp[v][ny][nx] = " + dp[v][ny][nx]);
            cy = ny;
            cx = nx;
        }
    }

    static void initDp(int depth, int v) {

        int temp = board[depth][depth];
        int cy = depth;
        int cx = depth;
        int d = 0;
        while (true) {

            int ny = cy + dy[d];
            int nx = cx + dx[d];
            if (ny < depth || nx < depth || ny >= N-depth || nx >= M-depth) {
                d++;
                ny = cy + dy[d];
                nx = cx + dx[d];
            }

            if (ny == depth && nx == depth) {
                dp[v][cy][cx] = temp;
                break;
            }

            dp[v][cy][cx] = board[ny][nx];
            cy = ny;
            cx = nx;
        }
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}