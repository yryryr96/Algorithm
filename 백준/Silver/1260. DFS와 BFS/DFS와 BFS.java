import java.io.*;
import java.util.*;

public class Main{
    static StringBuilder sb;
    static boolean[] visited;
    static int n,m,v;
    static List[] graph;
    static Deque<Integer> q = new ArrayDeque<>();
    public static void dfs(int v){
        sb.append(v).append(" ");

        visited[v] = true;
        List<Integer> childs = graph[v];
        for (Integer child : childs){
            if (!visited[child]){
                dfs(child);
            }
        }
    }

    public static void bfs(int v){
        visited[v] = true;
        while(!q.isEmpty()){
            int now = q.remove();
            sb.append(now).append(" ");
            List<Integer> childs = graph[now];
            for (Integer child : childs) {
                if (!visited[child]){
                    visited[child] = true;
                    q.add(child);
                }
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());
        graph = new List[n+1];
        visited = new boolean[n+1];
        sb = new StringBuilder();

        for (int i = 1; i < n+1 ; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i <m ; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        for (int i = 1; i < n+1 ; i++) {
            Collections.sort(graph[i]);
        }

        dfs(v);
        sb.append("\n");
        visited = new boolean[n+1];
        q.add(v);
        bfs(v);
        System.out.println(sb);
    }
}