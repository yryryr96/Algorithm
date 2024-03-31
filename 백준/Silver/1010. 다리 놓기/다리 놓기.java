import java.io.*;
import java.util.*;

public class Main {

    static int[][] dp = new int[31][31];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        init();

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            sb.append(dp[m][n] + "\n");
        }

        System.out.println(sb.toString());
    }

    static void init() {
        
        for (int i = 1; i < 31; i++) {
            for (int j = 0; j <= i; j++) {

                if (j == 0 || j == i) {
                    dp[i][j] = 1;
                    continue;
                }

                dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
            }
        }
    }
}