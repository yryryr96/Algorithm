import java.io.*;
import java.util.*;

public class Main {

    static int f,s,g,u,d;
    static int[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        f = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        g = Integer.parseInt(st.nextToken());
        u = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        visited = new int[f];
        // 총 f층 현재 s층, 목표 g층
        bfs();
    }

    static void bfs() {


        Queue<Integer> q = new LinkedList<>();
        q.add(s-1);
        visited[s-1] = 1;

        while(!q.isEmpty()) {

            int stair = q.poll();

            if (stair == g-1) {
                System.out.println(visited[stair] - 1);
                return;
            }

            if (stair+u < f && visited[stair+u] == 0) {
                visited[stair+u] = visited[stair] + 1;
                q.add(stair+u);
            }

            if (stair-d >= 0 && visited[stair-d] == 0) {
                visited[stair-d] = visited[stair] + 1;
                q.add(stair-d);
            }
        }

        System.out.println("use the stairs");
        return;
    }
}