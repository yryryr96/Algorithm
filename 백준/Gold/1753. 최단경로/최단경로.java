import java.io.*;
import java.util.*;

public class Main {

    static int V,E;
    static int K;
    static List<List<Node>> edgeInfo = new ArrayList<>();
    static int[] distance;
    static class Node {
        int num, distance;

        Node (int num, int distance) {
            this.num = num;
            this.distance = distance;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());
        distance = new int[V+1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        for (int i = 0; i < V+1; i++) {
            edgeInfo.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            edgeInfo.get(u).add(new Node(v,w));
        }

        dijkstra();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < V+1; i++) {
            sb.append(distance[i] != Integer.MAX_VALUE ? distance[i] : "INF").append("\n");
        }

        System.out.println(sb.toString());
    }

    static void dijkstra() {

        PriorityQueue<Node> q = new PriorityQueue<>((a,b) -> a.distance - b.distance);
        q.add(new Node(K,0));
        distance[K] = 0;

        while(!q.isEmpty()) {

            Node node = q.poll();
            if (node.distance < distance[node.num]) continue;

            for (Node next : edgeInfo.get(node.num)) {
                int cost = distance[node.num] + next.distance;
                if (distance[next.num] > cost) {
                    q.add(new Node(next.num, cost));
                    distance[next.num] = cost;
                }
            }
        }
    }
}