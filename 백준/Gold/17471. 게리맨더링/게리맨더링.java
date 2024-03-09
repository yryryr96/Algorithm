import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int[] peopleCnt;
    static List<List<Integer>> nodes = new ArrayList<>();
    static boolean[] selected;
    static int ans = Integer.MAX_VALUE;
    static int total = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        peopleCnt = new int[n+1];
        selected = new boolean[n+1];
        st = new StringTokenizer(br.readLine());

        for (int i = 1; i < n + 1; i++) {
            peopleCnt[i] = Integer.parseInt(st.nextToken());
            total += peopleCnt[i];
            nodes.add(new ArrayList<>());
        }
        nodes.add(new ArrayList<>());


        for (int i = 1; i < n+1; i++) {
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            for (int j = 0; j < cnt; j++) {
                int nn = Integer.parseInt(st.nextToken());
                nodes.get(i).add(nn);
            }
        }

        combination(0, 0, 0);
        ans = ans == Integer.MAX_VALUE ? -1 : ans;
        System.out.println(ans);
    }

    static void combination(int start, int cnt, int sum) {

        if (cnt <= n/2) {
            int gap = Math.abs(sum - (total - sum));
            if (ans > gap) {
                if (bfs(true, cnt) && bfs(false, n - cnt)) {
                    ans = gap;
                }
            }
        }

        if (cnt >= n/2) return;

        for (int i = start+1; i < n+1; i++) {
            if (!selected[i]) {
                selected[i] = true;
                combination(i, cnt+1, sum + peopleCnt[i]);
                selected[i] = false;
            }
        }
    }

    static boolean bfs(boolean team, int cnt) {

        if (cnt == 1) return true;

        boolean[] visited = new boolean[n + 1];
        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i < n+1; i++) {
            if (selected[i] == team) {
                q.add(i);
                visited[i] = true;
                break;
            }
        }

        while(!q.isEmpty()) {
            int i = q.poll();
            cnt--;

            for (int node : nodes.get(i)) {
                if (selected[node] == team && !visited[node]) {
                    visited[node] = true;
                    q.add(node);
                }
            }
        }

        return cnt == 0;
    }
}