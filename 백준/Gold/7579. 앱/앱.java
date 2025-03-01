import java.io.*;
import java.util.*;

public class Main {

    static class Memory {
        int m, e;
        Memory (int m, int e) {
            this.m = m;
            this.e = e;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = stoi(st.nextToken());
        int M = stoi(st.nextToken());

        int[] memory = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            memory[i] = stoi(st.nextToken());
        }

        Memory[] memories = new Memory[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int expense = stoi(st.nextToken());
            memories[i] = new Memory(memory[i] ,expense);
        }

        // 비활 -> 실행 -> 추가 비용 expense
        int LIMIT = 10001;
        int[][] dp = new int[LIMIT][N+1]; // 비용, 순서, dp[i][j] = 확보 가능 메모리
        int answer = LIMIT;
        for (int j = 1; j <= N; j++) {
            Memory mem = memories[j];
            for (int i = 0; i < LIMIT; i++) {
                if (mem.e > i) {
                    dp[i][j] = dp[i][j-1];
                    continue;
                }

                dp[i][j] = Math.max(dp[i][j-1], dp[i - mem.e][j-1] + mem.m);
                if (dp[i][j] >= M) {
                    answer = Math.min(answer, i);
                }
            }
        }

        System.out.println(answer);
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
