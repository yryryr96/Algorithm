import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = stoi(st.nextToken());
        int W = stoi(st.nextToken());
        int[] trees = new int[T+1];

        for (int i = 1; i <= T; i++) {
            trees[i] = stoi(br.readLine());
        }

       int[][][] dp = new int[T+1][W+1][3]; // 시간, 이동 횟수, 위치,,, value = 최대 개수

        if (trees[1] == 1) {
            dp[1][0][1] = 1;
            dp[1][1][2] = 0;
        } else {
            dp[1][0][1] = 0;
            dp[1][1][2] = 1;
        }

        for (int t = 2; t <= T; t++) {
            int tree = trees[t];

            if (tree == 1) {
                dp[t][0][1] = dp[t-1][0][1] + 1;
                dp[t][0][2] = dp[t-1][0][2];

                for (int w = 1; w <= W; w++) {
                    dp[t][w][1] = Math.max(dp[t-1][w][1], dp[t-1][w-1][2]) + 1;
                    dp[t][w][2] = Math.max(dp[t-1][w-1][1], dp[t-1][w][2]);
                }
            }

            else {

                dp[t][0][1] = dp[t-1][0][1];
                dp[t][0][2] = dp[t-1][0][2] + 1;

                for (int w = 1; w <= W; w++) {
                    dp[t][w][1] = Math.max(dp[t-1][w][1], dp[t-1][w-1][2]);
                    dp[t][w][2] = Math.max(dp[t-1][w-1][1], dp[t-1][w][2]) + 1;
                }
            }
        }

        int answer = 0;
        for (int w = 0; w <= W; w++) {
            answer = Math.max(answer, Math.max(dp[T][w][1], dp[T][w][2]));
        }
        System.out.println(answer);
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
