import java.io.*;
import java.util.*;

public class Main {

    static class Subject {
        int time;
        int score;

        Subject(int time, int score) {
            this.time = time;
            this.score = score;
        }
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = stoi(st.nextToken());
        int T = stoi(st.nextToken());

        Subject[] subjects = new Subject[N+1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int K = stoi(st.nextToken()); // 단원 별 공부 시간
            int S = stoi(st.nextToken()); // 배점
            subjects[i] = new Subject(K, S);
        }

        int[][] dp = new int[T+1][N+1];
        for (int j = 1; j <= N; j++) {
            Subject subject = subjects[j];
            for (int i = 1; i <= T; i++) {
                if (subject.time > i) {
                    dp[i][j] = dp[i][j-1];
                    continue;
                }

                dp[i][j] = Math.max(dp[i][j-1], dp[i-subject.time][j-1] + subject.score);
            }
        }

        System.out.println(dp[T][N]);
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
