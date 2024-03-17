import java.io.*;
import java.util.*;

public class Main {

    static int INF = 987654321;
    static int n;
    static int[][] relation;
    static int candidateScore = INF;
    static int candidateCount = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        relation = new int[n+1][n+1];

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < n+1; j++) {
                if (i != j) relation[i][j] = INF;
            }
        }

        while (true) {

            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (a == -1 && b == -1) break;

            relation[a][b] = 1;
            relation[b][a] = 1;
        }

        for (int k = 1; k < n+1; k++) {
            for (int i = 1; i < n+1; i++) {
                for (int j = 1; j < n+1; j++) {
                    if (relation[i][j] > relation[i][k] + relation[k][j]) {
                        relation[i][j] = relation[i][k] + relation[k][j];
                    }
                }
            }
        }

        int[] scoreArr = new int[n+1];

        for (int i = 1; i < n+1; i++) {

            int sum = 0;
            for (int j = 1; j < n+1; j++) {
                if (relation[i][j] != INF) {
                    sum = Math.max(sum, relation[i][j]);
                }
            }

            scoreArr[i] = sum;
            candidateScore = Math.min(candidateScore, sum);
        }

        StringBuilder title = new StringBuilder();
        StringBuilder body = new StringBuilder();

        for (int i = 1; i < n+1; i++) {
            if (candidateScore == scoreArr[i]) {
                candidateCount++;
                body.append(i + " ");
            }
        }

        title.append(candidateScore + " " + candidateCount);

        System.out.println(title.toString());
        System.out.println(body.toString());
    }
}