import java.io.*;
import java.util.*;

public class Main {

    static int N, M, R;
    static int[][] board;
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        R = stoi(st.nextToken());
        board = new int[N][M];

        for (int row = 0; row < N; row++) {
            st = new StringTokenizer(br.readLine());
            for (int col = 0; col < M; col++) {
                board[row][col] = stoi(st.nextToken());
            }
        }

        int depthLimit = Math.min(N,M)/2 - 1;
        for (int depth = 0; depth <= depthLimit; depth++) {
            int cnt = R % (((N - depth*2) + (M - depth*2)) * 2 - 4);
            rotate(depth, cnt);
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

    static void rotate(int depth, int cnt) {
        for (int c = 0; c < cnt; c++) {
            rotateLayer(depth);
        }
    }

    static void rotateLayer(int depth) {

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
                board[cy][cx] = temp;
                break;
            }

            board[cy][cx] = board[ny][nx];
            cy = ny;
            cx = nx;
        }
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}