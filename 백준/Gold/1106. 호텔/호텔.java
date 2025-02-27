import java.io.*;
import java.util.*;

public class Main {

    static class City {
        int expense;
        int customer;
        City (int expense, int customer) {
            this.expense = expense;
            this.customer = customer;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int C = stoi(st.nextToken());
        int N = stoi(st.nextToken());

        City[] cities = new City[N+1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int expense = stoi(st.nextToken());
            int customer = stoi(st.nextToken());
            cities[i] = new City(expense, customer);
        }

        int[] dp = new int[C+101];
        Arrays.fill(dp, 100_000);
        for (int i = 1; i <= N; i++) {
            City city = cities[i];
            dp[city.customer] = Math.min(dp[city.customer], city.expense);

            for (int j = 1; j <= C+100; j++) {
                if (city.customer > j) {
                    continue;
                }

                dp[j] = Math.min(dp[j], dp[j - city.customer] + city.expense);
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int i = C; i < C+100; i++) {
            answer = Math.min(answer, dp[i]);
        }

        System.out.println(answer);
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
