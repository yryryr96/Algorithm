
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N,M,D;
    static int answer = 1;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        D = Math.min(N, M);

        int[][] board = new int[N][M];

        for (int row = 0; row < N; row++) {
            String[] input = br.readLine().split("");
            for (int col = 0; col < M; col++) {
                board[row][col] = stoi(input[col]);
            }
        }

        for (int d = 1; d < D; d++) {
            for (int y = 0; y < N; y++) {
                for (int x = 0; x < M; x++) {

                    int[][] points = {
                        {y, x},
                        {y + d, x},
                        {y, x + d},
                        {y + d, x + d}
                    };

                    if(isValidPoints(points, board)) {
                        answer = Math.max(answer, (d+1) * (d+1));
                    };

                }
            }
        }

        System.out.println(answer);
    }

    static boolean isValidPoints(int[][] points, int[][] board) {

        if (points.length < 1) {
            return false;
        }

        int value = board[points[0][0]][points[0][1]];
        for (int[] point : points) {

            int y = point[0];
            int x = point[1];
            if (!isInRange(y, x)) {
                return false;
            }

            if (value != board[y][x]) {
                return false;
            }
        }
        return true;
    }

    static boolean isInRange(int y, int x) {
        return 0 <= y && y < N && 0 <= x && x < M;
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
