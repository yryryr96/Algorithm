import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = stoi(br.readLine());
        int[] wine = new int[n];
        for (int i = 0; i < n; i++) {
            wine[i] = stoi(br.readLine());
        }

        int[] dp = new int[n];

        int answer = 0;

        if(n == 1) {
            answer = wine[0];
        }

        if (n == 2) {
            answer = wine[0] + wine[1];
        }

        if (n >= 3) {
            dp[0] = wine[0];
            dp[1] = wine[0] + wine[1];
            dp[2] = Math.max(dp[0] + wine[2], Math.max(dp[1], wine[1] + wine[2]));
            answer = Math.max(dp[0], Math.max(dp[1], dp[2]));
        }

        for(int i = 3; i < n; i++) {
            if (n < 3) break;
            dp[i] = Math.max(dp[i-1], Math.max(dp[i-2] + wine[i], dp[i-3] + wine[i] + wine[i-1]));
        }


        for (int i = 0; i < n; i++) {
            answer = Math.max(answer, dp[i]);
        }
        System.out.println(answer);
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
