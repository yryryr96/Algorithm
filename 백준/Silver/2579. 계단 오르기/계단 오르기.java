import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] stair = new int[n];
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            stair[i] = Integer.parseInt(br.readLine());
        }
        int ans = 0;
        if (n<=2) {
            for (int i = 0; i <n ; i++) {
                ans += stair[i];
            }
        } else {
            dp[0] = stair[0];
            dp[1] = stair[0] + stair[1];
            if (stair[0] + stair[2] >= stair[1]+stair[2]) { dp[2] = stair[0]+stair[2]; }
            else dp[2] = stair[1] + stair[2];
            for (int i = 3; i <n ; i++) {
                if (dp[i-3] + stair[i-1] +stair[i] >= dp[i-2] + stair[i]){
                    dp[i] = dp[i-3] + stair[i-1] +stair[i];
                } else { dp[i] = dp[i-2] + stair[i];}
            }
            ans = dp[n-1];
        }
        System.out.println(ans);

    }
}