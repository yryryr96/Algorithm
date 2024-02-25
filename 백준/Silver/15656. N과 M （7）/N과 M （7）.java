import java.util.*;
import java.io.*;

public class Main {

    static int n,m;
    static int[] numbers;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        numbers = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numbers);

        for (int i = 0; i < n; i++) {
            dfs(1,numbers[i] + " ");
        }

        System.out.println(sb.toString());
    }

    static void dfs(int depth, String s) {

        if (depth == m) {
            sb.append(s).append("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            dfs(depth+1, s + numbers[i] + " ");
        }
    }
}