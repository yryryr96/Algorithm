import java.io.*;
import java.util.*;

public class Main {

    static int N,K,L;
    static int[][] map;
    static int[] dy = {0,1,0,-1};
    static int[] dx = {1,0,-1,0};
    static class DirectionInfo {
        int time;
        String direction;
        DirectionInfo(int time, String direction) {
            this.time = time;
            this.direction = direction;
        }
    }
    static Deque<DirectionInfo> directionInfos = new ArrayDeque<>();
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a-1][b-1] = 1;
        }

        L = Integer.parseInt(br.readLine());
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            directionInfos.add(new DirectionInfo(Integer.parseInt(st.nextToken()), st.nextToken()));
        }

        System.out.println(simulate());
    }

    static int simulate() {

        Deque<Node> q = new ArrayDeque<>();
        q.add(new Node(0,0,0));
        visited[0][0] = true;

        int t = 0;
        while (!q.isEmpty()) {

            t++;
            Node head = q.peekFirst();
            int ny = head.y + dy[head.d];
            int nx = head.x + dx[head.d];
//            System.out.println("head.y = " + head.y + " head.x = " + head.x + " head.d = " + head.d);
            if (0 > ny || 0 > nx || ny >= N || nx >= N) return t;
            if (visited[ny][nx]) return t;

            visited[ny][nx] = true;
            if (map[ny][nx] == 1) {
                map[ny][nx] = 0;
            } else {
                Node tail = q.pollLast();
                visited[tail.y][tail.x] = false;
            }

            if (!directionInfos.isEmpty() && t == directionInfos.peek().time) {

                DirectionInfo directionInfo = directionInfos.pollFirst();
                if (directionInfo.direction.equals("D")) {
                    q.addFirst(new Node(ny, nx, (head.d + 1) % 4));
                } else {
                    q.addFirst(new Node(ny, nx, head.d == 0 ? 3 : head.d - 1));
                }
            }

            else {
                q.addFirst(new Node(ny, nx, head.d));
            }
        }

        return t;
    }

    static class Node {
        int y,x,d;
        Node(int y, int x, int d) {
            this.y = y;
            this.x = x;
            this.d = d;
        }
    }
}