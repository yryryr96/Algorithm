import java.util.*;
import java.io.*;

public class Main {

    static int[] list;
    static boolean[] visited;
    static int n;
    static int m;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        list = new int[n];
        visited = new boolean[10001];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(list);
        dfs(0, 0, new int[m]);
    }

    static void dfs(int depth, int idx, int[] arr) {

        if (depth == m) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < m; i++) {
                sb.append(arr[i]).append(" ");
            }
            System.out.println(sb.toString());
            return;
        }

        for (int i = idx; i < n; i++) {
            if (!visited[i]) {
                arr[depth] = list[i];
                visited[i] = true;
//                System.out.println(Arrays.toString(arr));
//                System.out.println("idx = " + idx);
                dfs(depth+1, i+1, arr);
                arr[depth] = 0;
                visited[i] = false;
            }
        }
    }
}