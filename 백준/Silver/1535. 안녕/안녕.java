import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = stoi(br.readLine());
        int[] L = new int[N+1]; // 잃는 체력
        int[] J = new int[N+1]; // 얻는 기쁨

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            L[i] = stoi(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            J[i] = stoi(st.nextToken());
        }

        int HP = 100;
        int[][] dp = new int[HP+1][N+1];
        for (int j = 1; j <= N; j++) {
            for (int i = 1; i <= HP; i++) {
                if (L[j] >= i) {
                    dp[i][j] = dp[i][j-1];
                    continue;
                }

                dp[i][j] = Math.max(dp[i][j-1], dp[i-L[j]][j-1] + J[j]);
            }
        }

        System.out.println(dp[HP][N]);
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
