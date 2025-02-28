import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = stoi(br.readLine());
        int[][] dp = new int[N+1][10];
        int D = 1_000_000_000;

        for (int i = 1; i < 10; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= N; i++) {

            for (int j = 0; j < 10; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i-1][1] % D;
                    continue;
                }

                else if (j == 9) {
                    dp[i][j] = dp[i-1][8] % D;
                    continue;
                }

                else {
                    dp[i][j] = dp[i-1][j-1] % D + dp[i-1][j+1] % D;
                }

            }
        }

        int answer = 0;
        for (int i = 0; i < 10; i++) {
            answer += dp[N][i] % D;
            answer %= D;
        }

        System.out.println(answer);
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
