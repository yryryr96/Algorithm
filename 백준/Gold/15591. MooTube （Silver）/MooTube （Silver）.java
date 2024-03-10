import java.io.*;
import java.util.*;

public class Main {

    static int N,Q;
    static List<List<int[]>> graph = new ArrayList<>();
    static long INF = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N+1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            graph.get(a).add(new int[]{b,dist});
            graph.get(b).add(new int[]{a,dist});

        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            sb.append(bfs(k,v)).append("\n");
        }

        System.out.println(sb.toString());
    }

    static int bfs(int k, int v) {

        boolean[] visited = new boolean[N+1];
        Queue<Integer> q = new LinkedList<>();

        q.add(v);
        int cnt = 0;

        while(!q.isEmpty()) {

            int node = q.poll();
            for (int[] info : graph.get(node)) {
                int next = info[0];
                int dist = info[1];

                if (next == v) continue;
                if (!visited[next] && k <= dist) {
                    visited[next] = true;
                    q.add(next);
                    cnt++;
                }
            }
        }

        return cnt;
    }
}