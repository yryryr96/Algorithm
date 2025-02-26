import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = stoi(st.nextToken());
        int k = stoi(st.nextToken());
        int[] coins = new int[n+1];

        for (int i = 1; i <= n; i++) {
            coins[i] = stoi(br.readLine());
        }

        int[][] dp = new int[k+1][n+1];
        Arrays.fill(dp[0], 1);
        for (int j = 1; j <= n; j++) {
            int coin = coins[j];
            for (int i = 1; i <= k; i++) {
                if (i < coin) {
                    dp[i][j] = dp[i][j-1];
                    continue;
                }

                dp[i][j] = dp[i][j-1] + dp[i-coin][j];
            }
        }

        System.out.println(dp[k][n]);
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
