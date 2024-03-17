import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int[][] relation;
    static int candidateScore = Integer.MAX_VALUE;
    static int candidateCount = 0;
    static List<Integer> candidate = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        relation = new int[n+1][n+1];

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
                    int cnt = 0;
                    if (i == j) continue;
                    if (relation[i][k] != 0 && relation[k][j] != 0) {
                        int dist = relation[i][k] + relation[k][j];

                        if (relation[i][j] == 0) relation[i][j] = dist;
                        else relation[i][j] = Math.min(dist, relation[i][j]);
                    }
                }
            }
        }

        for (int i = 1; i < n+1; i++) {
            int sum = 0;
            for (int j = 1; j < n+1; j++) {
                if (i == j) continue;
                sum = Math.max(sum, relation[i][j]);
            }

            if (candidateScore > sum) {
                candidateScore = sum;
                candidate.clear();
                candidate.add(i);
            }
            else if (candidateScore == sum) {
                candidate.add(i);
            }
        }

        candidateCount = candidate.size();

        StringBuilder sb = new StringBuilder();
        sb.append(candidateScore).append(" ").append(candidateCount).append("\n");
        for (int i = 0; i < candidate.size(); i++) {
            sb.append(candidate.get(i)).append(" ");
        }

        System.out.println(sb.toString());
    }
}