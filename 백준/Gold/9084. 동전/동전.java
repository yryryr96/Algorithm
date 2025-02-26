import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = stoi(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= T; tc++) {
            int N = stoi(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] coins = new int[N];
            for (int i = 0; i < N; i++) {
                coins[i] = stoi(st.nextToken()); // 1 ~ 10000 원
            }
            // logic ...
            // 동전으로 만들 수 있는 모든 경우의 수 bottom up
            int M = stoi(br.readLine());
            int[] dp = new int[M+1];
            dp[0] = 1;

            for (int coin : coins) {
                for (int i = coin; i <= M; i++) {
                    dp[i] = dp[i] + dp[i - coin];
                }
            }

            sb.append(dp[M] + "\n");
        }

        System.out.println(sb.toString());
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
