import java.io.*;
import java.util.*;

public class Main {

    static int t,n;
    static int[] parent;
    static int[][] circle;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {

            n = Integer.parseInt(br.readLine());
            parent = new int[n];
            circle = new int[n][3];

            HashSet<Integer> set = new HashSet<>();
            for (int j = 0; j < n; j++) {
                parent[j] = j;
            }

            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                circle[j] = new int[]{a,b,r};
            }

            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (j != k) union(j,k);
                }
            }

            for (int j = 0; j < n; j++) {
                set.add(find(j));
            }

            sb.append(set.size()).append("\n");
        }

        System.out.println(sb.toString());
    }

    static boolean checkDistance(int[] a, int[] b) {

        double realDistance = Math.sqrt(Math.pow(Math.abs(a[0]-b[0]),2) + Math.pow(Math.abs(a[1]-b[1]),2));
//        System.out.println("realDistance = " + realDistance);
        double limitDistance = a[2] + b[2];
        return realDistance <= limitDistance;
    }

    static void union(int x, int y) {

        if (!checkDistance(circle[x], circle[y])) return;

        int a = find(x);
        int b = find(y);

        if (a == b) return;
        parent[Math.max(a,b)] = Math.min(a,b);
    }

    static int find(int x) {

        if (parent[x] == x) return x;
        return find(parent[x]);
    }
}