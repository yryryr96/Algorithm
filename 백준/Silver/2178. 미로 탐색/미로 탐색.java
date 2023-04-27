import java.io.*;
import java.util.*;

public class Main{
    static StringTokenizer st;
    static char[][] graph;
    static Deque<int[]> q;
    static int[][] visited;
    static int n;
    static int m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        q = new ArrayDeque<>();
        visited = new int[n][m];
        graph = new char[n][m];

        for (int i = 0; i <n ; i++) {
            String hang = br.readLine();
            graph[i] = hang.toCharArray();
        }

        bfs();
        System.out.println(visited[n-1][m-1]);
    }

    public static void bfs() {
        int[] di = {0,0,1,-1};
        int[] dj = {1,-1,0,0};
        visited[0][0] = 1;
        q.add(new int[] {0,0});
        while(!q.isEmpty()) {
            int[] now = q.removeFirst();
            int i = now[0];
            int j = now[1];
            if (i==n-1 && j==m-1) return;

            for (int k = 0; k <4 ; k++) {
                int ni = i +di[k];
                int nj = j +dj[k];
                if (0<=ni && ni<n && 0<=nj && nj<m && visited[ni][nj] == 0 && graph[ni][nj] == '1' ) {
                    q.add(new int[] {ni,nj});
                    visited[ni][nj] = visited[i][j] + 1;
                }
            }

        }
    }
}