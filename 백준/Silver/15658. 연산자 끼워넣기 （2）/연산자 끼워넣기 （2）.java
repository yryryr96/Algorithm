import java.util.*;
import java.io.*;

public class Main {

    static int n;
    static int[] calc = new int[4];
    static int[] numbers;
    static int MAX = Integer.MIN_VALUE;
    static int MIN = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            calc[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, numbers[0]);
        System.out.println(MAX);
        System.out.println(MIN);
    }

    static void dfs(int depth, int v) {

        if (depth == n-1) {
            MAX = Math.max(MAX, v);
            MIN = Math.min(MIN, v);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (calc[i] != 0) {
                calc[i] -= 1;
                if (i == 0) {
                    dfs(depth+1, v+numbers[depth+1]);
                } else if (i == 1) {
                    dfs(depth+1, v-numbers[depth+1]);
                } else if (i==2) {
                    dfs(depth+1, v*numbers[depth+1]);
                } else {
                    dfs(depth+1, v/numbers[depth+1]);
                }
                calc[i] += 1;
            }
        }
    }
}