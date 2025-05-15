import java.io.*;
import java.util.*;

public class Main {

    static int n, ans;
    static int[][] cost, dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = stoi(br.readLine());
        cost = new int[n][3];
        dp = new int[n][3];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                cost[i][j] = stoi(st.nextToken());
            }
        }

        simulate();
    }

    static void simulate() {

        ans = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            dp[0][i] = cost[0][i];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                int v = cost[i][j];
                if (j == 0) {
                    dp[i][j] = Math.min(dp[i-1][1] + v, dp[i-1][2] + v);
                } else if(j == 1) {
                    dp[i][j] = Math.min(dp[i-1][0] + v, dp[i-1][2] + v);
                } else {
                    dp[i][j] = Math.min(dp[i-1][0] + v, dp[i-1][1] + v);
                }
            }
        }

        ans = Math.min(dp[n-1][0], Math.min(dp[n-1][1], dp[n-1][2]));
        System.out.println(ans);
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}