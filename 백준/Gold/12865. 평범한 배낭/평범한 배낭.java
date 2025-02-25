import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static class Product {
        int v, w;
        public Product(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N, K;
        N = stoi(st.nextToken());
        K = stoi(st.nextToken());

        Product[] products = new Product[N+1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int w = stoi(st.nextToken());
            int v = stoi(st.nextToken());
            products[i] = new Product(v, w);
        }

        int[][] dp = new int[K+1][N+1];
        for (int j = 1; j <= N; j++) {
            Product product = products[j];
            for (int i = 1; i <= K; i++) {
                if (product.w > i) {
                    dp[i][j] = dp[i][j-1];
                }

                else {
                    dp[i][j] = Math.max(dp[i][j-1], product.v + dp[i-product.w][j-1]);
                }
            }
        }

        System.out.println(dp[K][N]);

    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
