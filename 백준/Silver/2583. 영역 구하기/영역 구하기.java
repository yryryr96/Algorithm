import java.io.*;
import java.util.*;

public class Main{
    static int n;
    static int m;
    static int k;
    static int[][] graph;
    static int[][] visited;
    static int[] di = {1,-1,0,0};
    static int[] dj = {0,0,1,-1};
    static Deque<int[]> q = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        graph = new int[n][m];
        visited = new int[n][m];
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i <k ; i++) {
            st = new StringTokenizer(br.readLine());
            int y1 = Integer.parseInt(st.nextToken());
            int x1 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());

            for (int y = y1; y < y2 ; y++) {
                for (int x = x1; x < x2 ; x++) {
                    graph[y][x] = 1;
                }
            }
        }

        int v = -1;
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <m ; j++) {
                if (graph[i][j] == 0 && visited[i][j] ==0){
                    q = new ArrayDeque<>();
                    q.add(new int[] {i,j});
                    visited[i][j] = 1;
                    graph[i][j] = v;
                    int a = bfs(i,j,v);
                    ans.add(a);
                    v -= 1;
                }
            }
        }

        System.out.println(-v-1);
        Collections.sort(ans);
        for (int i : ans) sb.append(i).append(" ");
        System.out.println(sb);
    }

    public static int bfs(int i, int j, int v) {
        int cnt = 0;
        while(!q.isEmpty()) {
            int[] now = q.removeFirst();
            cnt += 1;
            for (int l = 0; l <4 ; l++) {
                int ni = now[0] + di[l];
                int nj = now[1] + dj[l];
                if (0<=ni && n>ni && 0<=nj && m>nj && visited[ni][nj] == 0 && graph[ni][nj] == 0){
                    graph[ni][nj] = v;
                    visited[ni][nj] = visited[now[0]][now[1]] + 1;
                    q.add(new int[] {ni,nj});
                }
            }
        }
        return cnt;
    }
}