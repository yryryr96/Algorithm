import java.io.*;
import java.util.*;

public class Main {

    static class Coin {
        int value;
        Coin(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = stoi(st.nextToken());
        int k = stoi(st.nextToken());
        Coin[] coins = new Coin[n+1];

        for (int i = 1; i <= n; i++) {
            int value = stoi(br.readLine());
            coins[i] = new Coin(value);
        }

        int[][] C = new int[k+1][n+1]; // 개수
        int LIMIT = Integer.MAX_VALUE - 1;
        for (int i = 0; i <= k; i++) {
            Arrays.fill(C[i], LIMIT);
        }

        for (int j = 1; j <= n; j++) {
            Coin coin = coins[j];
            for (int i = 0; i <= Math.min(coin.value, k); i++) {
                C[i][j] = C[i][j-1];
            }

            if (coin.value > k) continue;

            C[coin.value][j] = 1;
            for (int i = coin.value + 1; i <= k; i++) {
                C[i][j] = Math.min(C[i][j-1], C[i-coin.value][j] + 1);
            }
        }

        int answer = LIMIT;
        for (int i = 0; i <= n; i++) {
            answer = Math.min(answer, C[k][i]);
        }

        answer = answer >= LIMIT ? -1 : answer;
        System.out.println(answer);
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
