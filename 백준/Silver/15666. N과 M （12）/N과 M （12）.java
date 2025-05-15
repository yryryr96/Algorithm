import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = stoi(st.nextToken());
        }

        Arrays.sort(arr);

        dfs(0, 0, new int[M]);
        System.out.println(sb.toString());
    }

    static void dfs(int depth, int idx, int[] value) {

        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(value[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        int flag = 0;
        for (int i = idx; i < N; i++) {
            if (flag != arr[i]){
                value[depth] = arr[i];
                dfs(depth + 1, i, value);
                flag = arr[i];
            }
        }
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}