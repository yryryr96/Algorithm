import java.io.*;
import java.util.*;

public class Main {

    static int n,m;
    static class Node {
        int d, number;
        Node(int d, int number) {
            this.d = d;
            this.number = number;
        }
    }

    static List<List<Node>> graph = new ArrayList<>();
    static int[][] result;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        result = new int[n+1][n+1];

        for (int i = 0; i < n+1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(c,b));
            graph.get(b).add(new Node(c,a));
        }

        for (int i = 1; i <= n; i++) {
            dijkstra(i);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) sb.append("- ");
                else sb.append(result[i][j] + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    static void dijkstra(int start) {

        PriorityQueue<Node> q = new PriorityQueue<>((a,b) -> a.d - b.d);
        boolean[] visited = new boolean[n+1];
        int[] distance = new int[n+1];

        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;
        visited[start] = true;
        q.add(new Node(0, start));

        while (!q.isEmpty()) {

            Node now = q.poll();
            if (distance[now.number] < now.d) continue;
            if (!visited[now.number]) visited[now.number] = true;
            for (Node next : graph.get(now.number)) {

                int cost = now.d + next.d;
                if (!visited[next.number] && cost < distance[next.number]) {
                    distance[next.number] = cost;
                    result[next.number][start] = now.number;
                    q.add(new Node(cost, next.number));
                }
            }
        }
    }
}