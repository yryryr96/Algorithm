import java.io.*;
import java.util.*;

public class Main {

    static int A,B,C;
    static class Node {
        int a,b,c;
        Node(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

    static HashSet<Integer> set = new HashSet<>();
    static boolean[][][] visited;
    static List<Integer> ans = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        bfs();
        ans.addAll(set);
        Collections.sort(ans);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ans.size(); i++) {
            sb.append(ans.get(i)).append(" ");
        }

        System.out.println(sb.toString());
    }

    static void bfs() {

        Queue<Node> q = new LinkedList<>();
        visited = new boolean[A+1][B+1][C+1];
        q.add(new Node(0,0,C));
        visited[0][0][C] = true;

        while(!q.isEmpty()) {

            Node node = q.poll();
            if (node.a == 0) set.add(node.c);
            // a -> b
            if (node.a != 0) {
                int v = node.a + node.b;
                if (v <= B && !visited[0][v][node.c]) {
                    visited[0][v][node.c] = true;
                    q.add(new Node(0, v, node.c));
                } else if (v > B && !visited[v - B][B][node.c]) {
                    visited[v - B][B][node.c] = true;
                    q.add(new Node(v - B, B, node.c));
                }
            }

            // a -> c
            if (node.a != 0) {
                int v = node.a + node.c;
                if (v <= C && !visited[0][node.b][v]) {
                    visited[0][node.b][v] = true;
                    q.add(new Node(0, node.b, v));
                } else if (v > C && !visited[v - C][node.b][C]) {
                    visited[v - C][node.b][C] = true;
                    q.add(new Node(v - C, node.b, C));
                }
            }

            // b -> a
            if (node.b != 0) {
                int v = node.b + node.a;
                if (v <= A && !visited[v][0][node.c]) {
                    visited[v][0][node.c] = true;
                    q.add(new Node(v, 0, node.c));
                } else if (v > A && !visited[A][v-A][node.c]) {
                    visited[A][v-A][node.c] = true;
                    q.add(new Node(A, v-A, node.c));
                }
            }

            // b -> c
            if (node.b != 0) {
                int v = node.b + node.c;
                if (v <= C && !visited[node.a][0][v]) {
                    visited[node.a][0][v] = true;
                    q.add(new Node(node.a, 0, v));
                } else if (v > C && !visited[node.a][v-C][C]) {
                    visited[node.a][v-C][C] = true;
                    q.add(new Node(node.a, v-C, C));
                }
            }

            // c -> a
            if (node.c != 0) {
                int v = node.c + node.a;
                if (v <= A && !visited[v][node.b][0]) {
                    visited[v][node.b][0] = true;
                    q.add(new Node(v, node.b, 0));
                } else if (v > A && !visited[A][node.b][v-A]) {
                    visited[A][node.b][v-A] = true;
                    q.add(new Node(A, node.b, v-A));
                }
            }

            // c -> b
            if (node.c != 0) {
                int v = node.c + node.b;
                if (v <= B && !visited[node.a][v][0]) {
                    visited[node.a][v][0] = true;
                    q.add(new Node(node.a, v, 0));
                } else if (v > B && !visited[node.a][B][v-B]) {
                    visited[node.a][B][v-B] = true;
                    q.add(new Node(node.a, B, v-B));
                }
            }
        }
    }
}