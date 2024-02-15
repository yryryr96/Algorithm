import java.util.*;
import java.io.*;

public class Main {

    static int maxIdx = 100000*20 + 1;
    static boolean[] visited = new boolean[maxIdx];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n+1];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(n, arr, 0, 0);
        for (int i = 1; i < maxIdx; i++) {
            if (!visited[i]) {
                System.out.println(i);
                break;
            }
        }
    }

    static void dfs(int n, int[] arr, int idx, int value) {

        for (int i = idx; i < n; i++) {

            int v = arr[i];
            visited[v+value] = true;
            dfs(n, arr, i+1, value + v);
        }
    }
}