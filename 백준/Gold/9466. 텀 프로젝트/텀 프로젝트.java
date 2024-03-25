import java.io.*;
import java.util.*;

public class Main {

    static int t,n;
    static int[] select;
    static boolean[] visited, finished;
    static int cnt;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {

            n = Integer.parseInt(br.readLine());
            select = new int[n+1];
            visited = new boolean[n+1];
            finished = new boolean[n+1];
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j < n+1; j++) {
                select[j] = Integer.parseInt(st.nextToken());
            }

            cnt = 0;
            for (int j = 1; j < n+1; j++) {
                dfs(j);
            }

            System.out.println(n-cnt);
        }
    }

    static void dfs(int now) {

        if (visited[now]) return;

        visited[now] = true;
        int next = select[now];

        if (!visited[next]) {
            dfs(next);
        } else {
            if (!finished[next]) {
                cnt++;
                for (int i = next; i != now; i = select[i]) cnt++;
            }
        }
        finished[now] = true;
    }
}