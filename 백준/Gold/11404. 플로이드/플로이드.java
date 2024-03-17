import java.io.*;
import java.util.*;

public class Main {

    static final int INF = (int) Math.pow(10, 7) + 1;
    static int n,m;
    static int[][] busPrice;
    static int[][] station;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        busPrice = new int[n+1][n+1];

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < n+1; j++) {
                if (i != j) busPrice[i][j] = INF;
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            busPrice[a][b] = Math.min(busPrice[a][b], c);
        }

        for (int k = 1; k < n+1; k++) {
            for (int i = 1; i < n+1; i++) {
                for (int j = 1; j < n+1; j++) {
                    if (busPrice[i][j] > busPrice[i][k] + busPrice[k][j]) {
                        busPrice[i][j] = busPrice[i][k] + busPrice[k][j];
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < n+1; j++) {
                if (busPrice[i][j] == INF) sb.append(0 + " ");
                else sb.append(busPrice[i][j] + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}