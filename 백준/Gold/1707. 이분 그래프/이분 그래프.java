import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static List<List<Integer>> graph;
    static int[] colors;
    static final int RED = 1;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = stoi(br.readLine());

        for (int tc = 0; tc < T; tc++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = stoi(st.nextToken());
            int E = stoi(st.nextToken());

            graph = new ArrayList<>();
            for (int v = 0; v <= V; v++) {
                graph.add(new ArrayList<>());
            }

            for (int e = 0; e < E; e++) {
                st = new StringTokenizer(br.readLine());
                int from = stoi(st.nextToken());
                int to = stoi(st.nextToken());
                graph.get(from).add(to);
                graph.get(to).add(from);
            }

            colors = new int[V+1];
            boolean isBipartite = true;
            for (int v = 1; v <= V; v++) {
                if (colors[v] != 0) continue;
                isBipartite = isBipartite(v, RED);
                if (!isBipartite) break;
            }

            if (isBipartite) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    static boolean isBipartite(int start, int color) {

        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        colors[start] = color;

        while(!q.isEmpty()) {
            int cur = q.poll();
            for(int next : graph.get(cur)) {
                if (colors[cur] == colors[next]) {
                    return false;
                }

                if (colors[next] == 0) {
                    colors[next] = colors[cur] * (-1);
                    q.add(next);
                }
            }
        }

        return true;
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
