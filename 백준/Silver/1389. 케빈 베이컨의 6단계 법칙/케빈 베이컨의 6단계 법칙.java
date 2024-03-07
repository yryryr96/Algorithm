import java.io.*;
import java.util.*;

public class Main {

    static int n,m;
    static boolean[] friends;
    static List<List<Integer>> relation = new ArrayList<>();
    static int ans = 0;
    static int MAX = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()) + 1;
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            relation.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            relation.get(a).add(b);
            relation.get(b).add(a);
        }

        for (int i = 1; i < n; i++) {
            bfs(i);
        }

        System.out.println(ans);
    }

    static void bfs(int num) {

        int total = 0;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(num,0));
        friends = new boolean[n];
        friends[num] = true;

        while (!q.isEmpty()) {

            Pair p = q.poll();
            int number = p.num; int cnt = p.cnt;
            total += cnt;

            for (int i : relation.get(number)) {
                if (!friends[i]) {
                    friends[i] = true;
                    q.add(new Pair(i, cnt+1));
                }
            }
        }

        if (total < MAX) {
            MAX = total;
            ans = num;
        }
    }

    static class Pair {

        int num, cnt;

        Pair(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }
    }
}