import java.io.*;
import java.util.*;

public class Main {

    static int n,m;
    static char[][] map;
    static boolean[][] visited;
    static int lamb = 0;
    static int wolf = 0;
    static class Node {
        int y,x;
        Node (int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static int[] dy = {0,0,1,-1};
    static int[] dx = {1,-1,0,0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = stoi(st.nextToken());
        m = stoi(st.nextToken());
        map = new char[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 'v') wolf++;
                else if(map[i][j] == 'k') lamb++;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] != '#' && !visited[i][j]) bfs(i,j);
            }
        }

        System.out.println(lamb + " " + wolf);
    }

    static void bfs(int si, int sj) {

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(si,sj));
        visited[si][sj] = true;

        int l = 0;
        int w = 0;

        while (!q.isEmpty()) {

            Node now = q.poll();

            if (map[now.y][now.x] == 'v') w++;
            else if (map[now.y][now.x] == 'k') l++;

            for (int i = 0; i < 4; i++) {
                int ny = now.y + dy[i];
                int nx = now.x + dx[i];
                if (!isInRange(ny,nx)) continue;
                if (!visited[ny][nx] && map[ny][nx] != '#') {
                    visited[ny][nx] = true;
                    q.add(new Node(ny,nx));
                }
            }
        }

        if (l > w) wolf -= w;
        else lamb -= l;
    }

    static boolean isInRange(int y, int x) {
        return 0 <= y && 0 <= x && y < n && x < m;
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}