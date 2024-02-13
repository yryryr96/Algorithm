import java.util.*;
import java.io.*;

public class Main {

    static StringTokenizer st;
    static StringBuilder sb;
    static int[] visited;
    static int[] parent;
    static int n;
    static int m;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> q = new LinkedList<>();

        st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visited = new int[100001];
        parent = new int[100001];

        bfs(q);

        sb.append((visited[m]-1) + "\n");
        Stack<Integer> st = new Stack<>();
        int node = m;


        while (node != n) {
            st.push(node);
            node = parent[node];
        }
        st.push(node);

        while(!st.isEmpty()) {
            sb.append(st.pop() + " ");
        }

        System.out.println(sb.toString());
    }

    public static void bfs(Queue<Integer> q) {
        q.add(n);
        visited[n] = 1;

        while(!q.isEmpty()) {
            Integer node = q.poll();
            if (node == m) {
                return;
            }

            for (int i : new int[]{node-1, node+1, node*2}) {
                if (0<=i && i <= 100000 && visited[i] == 0) {
                    visited[i] = visited[node] + 1;
                    parent[i] = node;
                    q.add(i);
                }
            }
        }

        return;
    }
}
