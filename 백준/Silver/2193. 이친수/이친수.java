import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = stoi(br.readLine());

        long[] dp = new long[91];
        dp[1] = dp[2] = 1;
        for (int i = 3; i <= 90; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        System.out.println(dp[N]);
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
