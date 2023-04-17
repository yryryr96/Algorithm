import java.io.*;
import java.util.*;

public class Main{
    static int n;
    static int m;
    static int[][] graph;
    static int[][] visited;
    static Deque<int[]> q;
    static int ans;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        graph = new int[n][m];
        visited = new int[n][m];

        q = new ArrayDeque<>();
        for (int i = 0; i <n ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <m ; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if (graph[i][j] == 1){
                    q.add(new int[] {i,j});
                    visited[i][j] = 1;
                }

            }
        }

        bfs();
        ans = 0;
        int temp = 1;
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <m ; j++) {
                if (ans < visited[i][j]) ans = visited[i][j];
                if (graph[i][j] == 0 ) temp = 0;
            }
        }

        if (temp == 0 ) System.out.println(-1);
        else System.out.println(ans-1);

    }

    public static void bfs(){

        int[] di = new int[] {1,-1,0,0};
        int[] dj = new int[] {0,0,1,-1};

        while (!q.isEmpty()){

            int[] now = q.removeFirst();
            int i = now[0];
            int j = now[1];
            for (int k = 0; k <4 ; k++) {
                int ni = i+di[k];
                int nj = j+dj[k];
                if (0<=ni && n>ni && 0<=nj && m>nj && visited[ni][nj] == 0) {
                    if (graph[ni][nj] == 0){
                        visited[ni][nj] = visited[i][j] + 1;
                        graph[ni][nj] = 1;
                        q.add(new int[] {ni,nj});
                    }
                }
            }
        }
    }
}