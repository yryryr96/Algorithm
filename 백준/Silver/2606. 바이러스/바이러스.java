import java.io.*;
import java.util.*;

public class Main {
    static int[][] graph;
    static boolean[] visited;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        graph = new int[n+1][n+1];
        visited = new boolean[n+1];

        for (int i = 0; i <m ; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = graph[b][a] = 1;
        }

        dfs(graph,1);

        int ans = 0;
        for (int i = 0; i <n+1 ; i++) {
            if (visited[i]) ans += 1;
        }
        System.out.println(ans-1);

    }

    public static void dfs(int[][] arr, int n){
        visited[n] = true;

        for (int i = 0; i < arr.length ; i++) {
            if (arr[n][i] == 1 && !visited[i]){
                dfs(arr,i);
            }
        }
    }
}