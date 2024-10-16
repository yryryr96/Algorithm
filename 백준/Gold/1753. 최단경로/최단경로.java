import java.util.*;
import java.io.*;

public class Main {

    static int v, e, k;
    static PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
    static List<int[]>[] graph;
    static int INF = 5_000_000;
    static int[] distance;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        v = stoi(st.nextToken());
        e = stoi(st.nextToken());
        k = stoi(br.readLine());

        graph = new ArrayList[v+1];
        distance = new int[v+1];

        for(int i = 0; i < v+1; i++) {
            graph[i] = (new ArrayList<int[]>());
        }

        for(int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int u = stoi(st.nextToken());
            int v = stoi(st.nextToken());
            int w = stoi(st.nextToken());

            graph[u].add(new int[]{v,w});
        }

        for(int i = 1; i < v+1; i++) {
            distance[i] = INF;
        }

        distance[k] = 0;
        pq.add(new int[]{0,k});

        while(!pq.isEmpty()) {

            int[] cur = pq.poll();

            if(distance[cur[1]] < cur[0]) continue;

            for(int[] next : graph[cur[1]]) {
                int cost = cur[0] + next[1];
                if (cost < distance[next[0]]) {
                    distance[next[0]] = cost;
                    pq.add(new int[]{cost, next[0]});
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < v+1; i++) {
            if(distance[i] >= INF) {
                sb.append("INF").append("\n");
            } else {
                sb.append(distance[i]).append("\n");
            }
        }

        System.out.println(sb.toString());
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}