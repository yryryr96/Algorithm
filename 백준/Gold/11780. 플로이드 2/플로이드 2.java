
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[][] distances, paths;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = stoi(br.readLine());
        m = stoi(br.readLine());

        distances = new int[n+1][n+1];
        paths = new int[n+1][n+1];


        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i != j && distances[i][j] == 0) {
                    distances[i][j] = 100_001; // 무한대 처리
                }
            }
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = stoi(st.nextToken());
            int b = stoi(st.nextToken());
            int c = stoi(st.nextToken());

            if (distances[a][b] > c) {
                distances[a][b] = c;
                paths[a][b] = a;
            }
        }

        floyd();

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (distances[i][j] >= 100_001) {
                    sb.append("0 ");
                } else {
                    sb.append(distances[i][j]).append(" ");
                }
            }
            sb.append("\n");
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
//                if (i == j) continue;
                if (paths[i][j] == 0) {
                    sb.append("0\n");
                } else {
                    Stack<Integer> path = new Stack<>();

                    int pre = j;
                    path.add(pre);

                    while (i != paths[i][pre]) {
                        pre = paths[i][pre];
                        path.add(pre);
                    }

                    sb.append(path.size() + 1).append(" ");
                    sb.append(i).append(" ");
                    while(!path.isEmpty()) {
                        sb.append(path.pop()).append(" ");
                    }

                    sb.append("\n");
                }
            }
        }

        System.out.print(sb.toString());
    }

    static void floyd() {

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if(distances[i][j] > distances[i][k] + distances[k][j]) {
                        distances[i][j] = distances[i][k] + distances[k][j];
                        paths[i][j] = paths[k][j];
                    }
                }
            }
        }
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
