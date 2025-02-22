import java.io.*;
import java.util.*;

public class Main {

    static int[][] board;
    static int N, M;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        board = new int[N+1][M+1];

        for (int row = 1; row <= N; row++) {
            String[] input = br.readLine().split("");
            for (int col = 1; col <= M; col++) {
                board[row][col] = stoi(input[col-1]);
            }
        }

        int[][] psum = new int[N+1][M+1];
        for (int row = 1; row <= N; row++) {
            for (int col = 1; col <= M; col++) {
                psum[row][col] = psum[row-1][col] + psum[row][col-1] - psum[row-1][col-1] + board[row][col];
            }
        }

        int answer = 0;
        for (int row = 1; row <= N; row++) {
            for (int col = 1; col <= M; col++) {
                if(board[row][col] == 0) continue;

                int size = 1;
                int len = 1;

                while(row + len <= N && col + len <= M) {

                    int squareSize = psum[row + len][col + len] - psum[row-1][col + len] - psum[row + len][col-1] + psum[row-1][col-1];

                    len++;

                    if (squareSize != len * len) {
                        break;
                    }

                    size = squareSize;
                }

                answer = Math.max(answer, size);
            }
        }

        System.out.println(answer);
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
