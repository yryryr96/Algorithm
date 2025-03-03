import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long[][] dp = new long[1001][10];
        for (int i = 0; i < 10; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i <= 1000; i++) {
            for (int j = 0; j <= 9; j++) {
                for (int k = j; k <= 9; k++) {
                    dp[i][j] += dp[i-1][k];
                }
            }
        }

        int T = stoi(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= T; tc++) {
            int N = stoi(br.readLine());
            sb.append(dp[N][0]).append("\n");
        }
        System.out.println(sb.toString());
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
