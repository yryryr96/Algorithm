import java.util.*;
import java.io.*;

public class Main {

    static List<Integer>[] graph;
    static boolean[] visited;
    static int ans = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        int a; int b;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }
        for (int i = 0; i < n; i++) {
            visited[i] = true;
            dfs(n, i, 1);
            visited[i] = false;
        }

        System.out.println(ans);
    }

    private static void dfs(int n, int i, int cnt) {

        if (cnt >= 5 || ans == 1) {
            ans = 1;
            return;
        }

        for (int v : graph[i]) {
            if (!visited[v]) {
                visited[v] = true;
                dfs(n,v, cnt+1);
                visited[v] = false;
            }
        }
    }
}
