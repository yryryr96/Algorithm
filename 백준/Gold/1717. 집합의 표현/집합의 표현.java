import java.io.*;
import java.util.*;

public class Main {

    static int n,m;
    static int[] parent;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        parent = new int[n+1];

        for (int i = 0; i < n+1; i++) {
            parent[i] = i;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (t == 0) {
                union(a,b);
            } else {
                sb.append(isSameParent(a,b) ? "YES" : "NO").append("\n");
            }
        }

        System.out.println(sb.toString());
    }

    static int find(int x) {

        if (parent[x] == x) {
            return x;
        } else {
            parent[x] = find(parent[x]);
            return parent[x];
        }
    }

    static void union(int a, int b) {

        int x = find(a);
        int y = find(b);

        if (x == y) return;

        parent[Math.max(x,y)] = Math.min(x,y);
    }

    static boolean isSameParent(int a, int b) {
        return find(a) == find(b);
    }
}