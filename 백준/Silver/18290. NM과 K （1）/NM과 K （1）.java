import java.util.*;
import java.io.*;

public class Main {

    static int n,m,k;
    static int[][] map;
    static boolean[] visited;
    static int ans = Integer.MIN_VALUE;
    static int[] di = {0,0,1,-1};
    static int[] dj = {1,-1,0,0};
    static ArrayList<int[]> pairs = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n*m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                pairs.add(new int[]{i,j});
            }
        }

        for (int i = 0; i < pairs.size(); i++) {
            int y = pairs.get(i)[0];
            int x = pairs.get(i)[1];

            if (!visited[i]) {
                visited[i] = true;
                dfs(1, map[y][x], i);
                visited[i] = false;
            }
        }

        System.out.println(ans);
    }

    static void dfs(int depth, int v, int idx) {

        if (depth == k) {
            ans = Math.max(ans, v);
            return;
        }

        for (int i = idx; i < pairs.size(); i++) {
            int y = pairs.get(i)[0];
            int x = pairs.get(i)[1];
      
            if (!visited[i] && rangeCheck(y,x)) {
                visited[i] = true;
                dfs(depth+1, v + map[y][x], i);
                visited[i] = false;
            }
        }
    }

    static boolean rangeCheck(int i, int j) {
//        System.out.println("i = " + i + " j = " + j);
        for (int l = 0; l < 4; l++) {
            int ni = i + di[l];
            int nj = j + dj[l];
            if (0 > ni || ni >= n || 0 > nj || nj >= m) continue;
            for (int p = 0; p < pairs.size(); p++) {
                if (visited[p] && pairs.get(p)[0] == ni && pairs.get(p)[1] == nj) {
                    return false;
                }
            }
        }

        return true;
    }
}