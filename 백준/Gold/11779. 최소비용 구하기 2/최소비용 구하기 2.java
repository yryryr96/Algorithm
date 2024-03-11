import java.io.*;
import java.util.*;

public class Main {

    static int n,m;
    static List<List<Node>> edgeInfo = new ArrayList<>();
    static int[] distance, preCity;
    static int s,e;
    static int dist = 0;

    static class Node {
        int num, distance;

        Node (int num, int distance) {
            this.num = num;
            this.distance = distance;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        preCity = new int[n+1];

        for (int i = 0; i < n+1; i++) {
            edgeInfo.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            edgeInfo.get(a).add(new Node(b,d));
        }

        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        dijkstra();

        StringBuilder sb = new StringBuilder();
        sb.append(distance[e]);

        int cnt = 1;
        Stack<Integer> stack = new Stack<>();
        stack.add(e);

        while (preCity[e] != 0) {
            cnt++;
            stack.add(preCity[e]);
            e = preCity[e];
        }

        sb.append("\n" + cnt + "\n");
        while(!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }

        System.out.println(sb.toString());
    }

    static void dijkstra() {

        distance = new int[n+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        PriorityQueue<Node> q = new PriorityQueue<>((a,b) -> a.distance - b.distance);
        q.add(new Node(s,0));
        distance[s] = 0;

        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        while(!q.isEmpty()) {

            Node node = q.poll();

            if (node.distance > distance[node.num]) continue;

            for (Node next : edgeInfo.get(node.num)) {

                int cost = distance[node.num] + next.distance;
                if (cost < distance[next.num]) {
                    distance[next.num] = cost;
                    q.add(new Node(next.num, cost));
                    preCity[next.num] = node.num;
                }
            }
        }
    }
}