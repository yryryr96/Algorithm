import java.io.*;
import java.util.*;

public class Main {

    static int n,m,si,sj;
    static char[][] map;
    static boolean[][][] visited;
    static int[] dy = {0,0,1,-1};
    static int[] dx = {1,-1,0,0};
    static class Node {
        int y,x,cost,key;
        Node(int y, int x, int cost, int key) {
            this.y = y;
            this.x = x;
            this.cost = cost;
            this.key = key;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        visited = new boolean[n][m][64];

        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                if (map[i][j] == '0') {
                    si = i; sj = j;
                }
            }
        }

        System.out.println(bfs());
    }

    static int bfs() {

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(si,sj,0,0));
        visited[si][sj][0] = true;

        while (!q.isEmpty()) {

            Node current = q.poll();
            if (map[current.y][current.x] == '1') return current.cost;

            for (int k = 0; k < 4; k++) {

                int ny = current.y + dy[k];
                int nx = current.x + dx[k];

                if (0 > ny || 0 > nx || ny >= n || nx >= m) continue;
                if (visited[ny][nx][current.key] || map[ny][nx] == '#') continue;

                // 열쇠 칸
                if (map[ny][nx] >= 'a' && map[ny][nx] <= 'f') {
                    int next_key = 1 << (map[ny][nx] - 'a');
                    next_key = current.key | next_key;
                    visited[ny][nx][next_key] = true;
                    q.add(new Node(ny, nx, current.cost + 1, next_key));
                }
                // 문
                else if(map[ny][nx] >= 'A' && map[ny][nx] <= 'F') {
                    if ((current.key & 1 << (map[ny][nx] - 'A')) == (int) Math.pow(2, map[ny][nx] - 'A')) {
                        visited[ny][nx][current.key] = true;
                        q.add(new Node(ny, nx, current.cost + 1, current.key));
                    }
                }
                // 점
                else {
                    visited[ny][nx][current.key] = true;
                    q.add(new Node(ny, nx, current.cost+1, current.key));
                }
            }
        }

        return -1;
    }
}