import java.io.*;
import java.util.*;

public class Main {

    static int N, M, answer;
    static int[][] board, dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        board = new int[N][M];

        for (int row = 0; row < N; row++) {
            st = new StringTokenizer(br.readLine());
            for (int col = 0; col < M; col++) {
                board[row][col] = stoi(st.nextToken());
            }
        }

        dp = new int[N][M];
        dp[0][0] = board[0][0];
        for (int col = 1; col < M; col++) {
            dp[0][col] = dp[0][col - 1] + board[0][col];
        }

        answer = 0;
        int[][] temp = new int[2][M];
        for (int row = 1; row < N; row++) {
            temp[0][0] = dp[row-1][0] + board[row][0];
            for (int col = 1; col < M; col++) {
                temp[0][col] = Math.max(temp[0][col-1], dp[row-1][col]) + board[row][col];
//                System.out.println("row=" + row + ", temp[0][col]="+temp[0][col]);
            }

            temp[1][M-1] = dp[row-1][M-1] +  board[row][M-1];
            for (int col = M-2; col >= 0 ; col--) {
                temp[1][col] = Math.max(temp[1][col+1], dp[row-1][col]) + board[row][col];
            }

            for (int col = 0; col < M; col++) {
                dp[row][col] = Math.max(temp[0][col],  temp[1][col]);
            }
        }

//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < M; j++) {
//                System.out.print(dp[i][j] + " ");
//            }
//            System.out.println();
//        }

        System.out.println(dp[N-1][M-1]);
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}