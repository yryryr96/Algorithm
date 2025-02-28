import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = stoi(br.readLine());
        int[][] board = new int[N][3];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
             st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                board[i][j] = stoi(st.nextToken());
            }
        }

        int[][] MIN = new int[N][3];
        int[][] MAX = new int[N][3];
        for (int i = 0; i < 3; i++) {
            MIN[0][i] = MAX[0][i] = board[0][i];
        }

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 0) {
                    MIN[i][j] = Math.min(MIN[i-1][j] + board[i][j], MIN[i-1][j+1] + board[i][j]);
                    MAX[i][j] = Math.max(MAX[i-1][j] + board[i][j], MAX[i-1][j+1] + board[i][j]);
                }

                else if (j == 1) {
                    MIN[i][j] = Math.min(MIN[i-1][j] + board[i][j], Math.min(MIN[i-1][j+1] + board[i][j], MIN[i-1][j-1] + board[i][j]));
                    MAX[i][j] = Math.max(MAX[i-1][j] + board[i][j], Math.max(MAX[i-1][j+1] + board[i][j], MAX[i-1][j-1] + board[i][j]));
                }

                else {
                    MIN[i][j] = Math.min(MIN[i-1][j] + board[i][j], MIN[i-1][j-1] + board[i][j]);
                    MAX[i][j] = Math.max(MAX[i-1][j] + board[i][j], MAX[i-1][j-1] + board[i][j]);
                }
            }
        }

        int max = Math.max(MAX[N-1][0], Math.max(MAX[N-1][1], MAX[N-1][2]));
        int min = Math.min(MIN[N-1][0], Math.min(MIN[N-1][1], MIN[N-1][2]));
        System.out.println(max + " " + min);
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
