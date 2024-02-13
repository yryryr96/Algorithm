import java.util.*;
import java.io.*;

public class Main {

    static int n;
    static int[] map;
    static Set<Integer> set;
    static boolean[] visited;
    static int res;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        visited = new boolean[50*20+1];
        map = new int[]{1,5,10,50};
        res = 0;

        dfs(0,0,0);
        System.out.println(res);
    }

    public static void dfs(int cnt, int v, int idx) {

        if (cnt == n) {
            if (!visited[v]) {
                visited[v] = true;
                res++;
            }
            return;
        }

        for (int i = idx; i < 4; i++) {
            dfs(cnt+1, v+map[i], i);
        }
    }
}
