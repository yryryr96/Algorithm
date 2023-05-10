import java.io.*;
import java.util.*;

public class Main{
    static StringTokenizer st;
    static Deque<int[]> q;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int l = 0; l < T ; l++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int[][] graph = new int[n][m];
            int[][] visited = new int[n][m];

            for (int i = 0; i < k ; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph[a][b] = 1;
            }
            int bug = 0;
            q = new ArrayDeque<>();
            int[] di = {0,0,1,-1};
            int[] dj = {1,-1,0,0};

            for (int i = 0; i <n ; i++) {
                for (int j = 0; j <m ; j++) {
                    if(graph[i][j] == 1 && visited[i][j] == 0 ) {
                        bug += 1;
//                        System.out.println("#" + l);
//                        System.out.println(bug);
                       visited[i][j] = bug;
                       q.push(new int[] {i,j});
                       while (!q.isEmpty()){
                           int[] now = q.removeFirst();
                           int r = now[0];
                           int c = now[1];
//                           System.out.println("!"+r + "," + c);
                           for (int d = 0; d <4 ; d++) {
                               int ni = r+di[d];
                               int nj = c+dj[d];
//                               System.out.println(ni+","+nj);
                               if (0<=ni && ni<n && 0<=nj && nj<m && graph[ni][nj] == 1 && visited[ni][nj] == 0){
                                   visited[ni][nj] = bug;
                                   q.push(new int[] {ni,nj});
                               }
                           }

                       }
                    }
                }
            }
            System.out.println(bug);
        }
    }
}