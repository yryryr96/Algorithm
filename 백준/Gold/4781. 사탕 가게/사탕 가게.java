import java.io.*;
import java.util.*;

public class Main {

    static class Candy {
        int c;
        int p;
        Candy(int c, int p) {
            this.c = c;
            this.p = p;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            // n: 사탕 종류의 수, m: 상근이가 가지고 있는 돈의 양
            int n = Integer.parseInt(st.nextToken());
            double m = Double.parseDouble(st.nextToken());

            int M = (int) (m*100 + 0.5);
            if (n == 0 && M ==0) {
                break;
            }

            Candy[] candies = new Candy[n+1];
            candies[0] = new Candy(0, 0);
            for (int i = 1; i <= n; i++) {
                // c: 각 사탕 칼로리, p: 가격
                st = new StringTokenizer(br.readLine());
                int c = Integer.parseInt(st.nextToken());
                double p = Double.parseDouble(st.nextToken());
                candies[i] = new Candy(c, (int) (p*100 + 0.5));
            }

            int[] dp = new int[M+1];
            for (Candy candy : candies) {
                for (int i = candy.p; i <= M; i++) {
                    dp[i] = Math.max(dp[i], dp[i-candy.p] + candy.c);
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
