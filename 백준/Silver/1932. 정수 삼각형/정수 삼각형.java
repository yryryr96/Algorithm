import java.io.*;
import java.util.*;

public class Main {

    static int n, ans;
    static int[][] triangle, dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = stoi(br.readLine());
        triangle = new int[n][n];
        dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(triangle[i], -1);
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int j = 0;
            while (st.hasMoreTokens()) {
                triangle[i][j] = stoi(st.nextToken());
                j++;
            }
        }

        simulate();
        System.out.println(ans);
    }

    static void simulate() {

        ans = triangle[0][0];
        dp[0][0] = triangle[0][0];
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n; j++) {
                if (triangle[i][j] == -1) break;
                dp[i+1][j] = Math.max(dp[i][j] + triangle[i+1][j], dp[i+1][j]);
                dp[i+1][j+1] = Math.max(dp[i][j] + triangle[i+1][j+1], dp[i+1][j+1]);
                ans = Math.max(ans, Math.max(dp[i+1][j], dp[i+1][j+1]));
            }
        }
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}