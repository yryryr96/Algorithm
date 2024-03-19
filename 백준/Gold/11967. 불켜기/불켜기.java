import java.io.*;
import java.util.*;

public class Main {

    static int n,m;
    static int[] di = {0,0,1,-1};
    static int[] dj = {1,-1,0,0};
    static class Pair {
        int i,j;
        Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    static boolean[][] visited, light;
    static ArrayList<ArrayList<List<Pair>>> relation = new ArrayList<>();
    static Queue<Pair> q;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visited = new boolean[n][n];
        light = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            relation.add(new ArrayList<>());
            for (int j = 0; j < n; j++) {
                relation.get(i).add(new ArrayList<>());
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            relation.get(x-1).get(y-1).add(new Pair(a-1,b-1));
        }

        bfs();
        System.out.println(countLight());

//        for (int i = 0; i < n; i++) {
//            System.out.println(Arrays.toString(light[i]));
//        }
    }

    static int countLight() {

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (light[i][j]) cnt++;
            }
        }

        return cnt;
    }

    static void bfs() {

        q = new LinkedList<>();
        q.add(new Pair(0,0));
        light[0][0] = visited[0][0] = true;
        turnOnLight(0,0);
        ArrayList<Pair> waiting = new ArrayList<>();

        while(!q.isEmpty()) {

            Pair p = q.poll();
            int i = p.i; int j = p.j;

            turnOnLight(i,j);

            for (int k = 0; k < 4; k++) {
                int ni = i + di[k];
                int nj = j + dj[k];
                if (0 > ni || 0 > nj || ni >= n || nj >= n || visited[ni][nj]) continue;
                if (light[ni][nj]) {
                    q.add(new Pair(ni,nj));
                    visited[ni][nj] = true;
                } else {
                    waiting.add(new Pair(ni,nj));
                }
            }

            for (int k = 0; k < waiting.size(); k++) {
                int ni = waiting.get(k).i; int nj = waiting.get(k).j;
                if(light[ni][nj] && !visited[ni][nj]) {
                    visited[ni][nj] = true;
                    q.add(new Pair(ni,nj));
                }
            }
        }
    }

    static void turnOnLight(int i, int j) {

        List<Pair> lights = relation.get(i).get(j);
        for (Pair p : lights) {
            light[p.i][p.j] = true;
        }
    }
}