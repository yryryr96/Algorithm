import java.io.*;
import java.util.*;

public class Main {

    static int[][] board;
    static int N,M;
    static boolean[][] directions;
    static int answer = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        board = new int[N][M];
        directions = new boolean[N][M]; // true: 세로, false: 가로

        for (int row = 0; row < N; row++) {
            String[] input = br.readLine().split("");
            for (int col = 0; col < M; col++) {
                board[row][col] = stoi(input[col]);
            }
        }

        dfs(0,0);
        System.out.println(answer);
    }

    static void dfs(int row, int col) {
        if (row == N) {
            // answer 초기화 logic
            int sum = getSum();
            answer = Math.max(answer, sum);
            return;
        }

        if (col == M) {
            dfs(row + 1, 0);
            return;
        }

        // 세로 방향 진행
        directions[row][col] = true;
        dfs(row, col + 1);

        // 가로
        directions[row][col] = false;
        dfs(row, col + 1);
    }

    static int getSum() {

        int sum = 0;
        // 세로 합 구하기
        for (int col = 0; col < M; col++) {
            int rowSum = 0;
            for (int row = 0; row < N; row++) {
                if (!directions[row][col]) {
                    sum += rowSum;
                    rowSum = 0;
                    continue;
                }
                rowSum *= 10;
                rowSum += board[row][col];
            }

            sum += rowSum;
        }

        // 가로 합 구하기
        for (int row = 0; row < N; row++) {
            int colSum = 0;
            for (int col = 0; col < M; col++) {
                if (directions[row][col]) {
                    sum += colSum;
                    colSum = 0;
                    continue;
                }

                colSum *= 10;
                colSum += board[row][col];
            }

            sum += colSum;
        }

        return sum;
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}

