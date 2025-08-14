
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = stoi(br.readLine());
        for (int tc = 0; tc < T; tc++) {

            int K = stoi(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] costs = new int[K+1];
            for (int i = 1; i < K+1; i++) {
                int cost = stoi(st.nextToken());
                costs[i] = cost + costs[i-1];
            }

            int[][] dp = new int[K+1][K+1];

            for (int gap = 1; gap < K; gap++) {
                for (int start = 1; start + gap <= K; start++) {

                    int end = start + gap;
                    dp[start][end] = Integer.MAX_VALUE;

                    for (int mid = start; mid < end; mid++) {
                        dp[start][end] = Math.min(
                                dp[start][end],
                                dp[start][mid] + dp[mid + 1][end] + (costs[end] - costs[start - 1])
                        );
                    }
                }
            }

            System.out.println(dp[1][K]);
        }
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
