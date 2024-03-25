import java.io.*;
import java.util.*;

public class Main {

    static int k,v,e;
    static List<List<Integer>> graph;
    static int[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        k = Integer.parseInt(br.readLine());
        for (int t = 0; t < k; t++) {

            st = new StringTokenizer(br.readLine());
            v = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            graph = new ArrayList<>();
            visited = new int[v+1];

            for (int i = 0; i < v+1; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < e; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                graph.get(a).add(b);
                graph.get(b).add(a);
            }

            boolean temp = false;
            for (int i = 1; i < v+1; i++) {
                if (visited[i] == 0) {
                    if(!dfs(i,1)) {
                        System.out.println("NO");
                        temp = true;
                        break;
                    }
                }
            }

            if (!temp) {
                System.out.println("YES");
            }
        }
    }

    static boolean dfs(int i, int group) {

        visited[i] = group;
        for (int next : graph.get(i)) {
            if (visited[next] == 0) {
                boolean temp = dfs(next, -group);
                if (!temp) return false;
            } else {
                if (visited[next] != -group) return false;
            }
        }

        return true;
    }
}