
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    static int N = 5;
    static String[][] board = new String[N][N];
    static HashSet<Integer> answerSet = new HashSet<>();
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int row = 0; row < N; row++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int col = 0; col < N; col++) {
                board[row][col] = st.nextToken();
            }
        }

        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                dfs(row, col, 0, board[row][col]);
            }
        }

        int answer = answerSet.size();
        System.out.println(answer);
    }

    static void dfs(int row, int col, int depth, String number) {

        if (depth == 5) {
            answerSet.add(Integer.parseInt(number));
            return;
        }

        for (int d = 0; d < 4; d++) {
            int nRow = row + dy[d];
            int nCol = col + dx[d];

            if (!isInRange(nRow, nCol)) {
                continue;
            }

            dfs(nRow, nCol, depth + 1, number + board[nRow][nCol]);
        }
    }

    static boolean isInRange(int row, int col) {
        return 0 <= row && row < N && 0 <= col && col < N;
    }
}
