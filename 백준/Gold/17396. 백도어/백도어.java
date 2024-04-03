import java.io.*;
import java.util.*;

public class Main {

    static int n,m;
    static boolean[] visited;
    static class Node {
        long d;
        int number;
        Node (long d, int number) {
            this.d = d;
            this.number = number;
        }
    }
    static List<List<Node>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            if (st.nextToken().equals("1")) visited[i] = true;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long t = Long.parseLong(st.nextToken());

            graph.get(a).add(new Node(t,b));
            graph.get(b).add(new Node(t,a));
        }

        System.out.println(dijkstra());
    }

    static long dijkstra() {

        long[] distance = new long[n];
        Arrays.fill(distance, Long.MAX_VALUE);

        PriorityQueue<Node> q = new PriorityQueue<>(Comparator.comparingLong(a -> a.d));
        q.add(new Node(0,0));
        distance[0] = 0;

        while(!q.isEmpty()) {

            Node now = q.poll();

            if (now.number == n-1) return distance[n-1];
            if (distance[now.number] < now.d) continue;

            for (Node next : graph.get(now.number)) {

                long cost = next.d + now.d;
                if (!visited[next.number] && cost < distance[next.number]) {
                    q.add(new Node(cost, next.number));
                    distance[next.number] = cost;
                }

                else if (next.number == n-1 && cost < distance[next.number]) {
                    q.add(new Node(cost, next.number));
                    distance[next.number] = cost;
                }
            }
        }

        return -1;
    }
}