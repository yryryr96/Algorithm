import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, answer;
    static int[][] schedule;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = stoi(br.readLine());
        schedule = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            schedule[i][0] = stoi(st.nextToken());
            schedule[i][1] = stoi(st.nextToken());
        }

        answer = 0;
        for (int i = 0; i < N; i++) {
            if (i + schedule[i][0] <= N) {
                dfs(i, schedule[i][1]);
            }
        }
        System.out.println(answer);
    }

    static void dfs(int idx, int score) {

        answer = Math.max(answer, score);
        for (int i = idx + schedule[idx][0]; i < N; i++) {
            if (i + schedule[i][0] <= N) {
                dfs(i, score + schedule[i][1]);
            }
        }
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}