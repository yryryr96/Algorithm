import java.io.*;
import java.util.*;

public class Main {

    static int n,m;
    static int totalRooms = 0;
    static int mostWideRoom = 0;
    static int brokenWallWide = 0;

    static int[][] map;
    static int[] di = {0,-1,0,1};
    static int[] dj = {-1,0,1,0};
    static int[] room;
    static int[][] visited;
    static HashMap<Integer, HashSet<Pair>> set = new HashMap<>();

    static class Pair {
        int y,x;
        boolean wall;

        Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }

        Pair (int y, int x, boolean wall) {
            this.y = y;
            this.x = x;
            this.wall = wall;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        room = new int[2501];
        visited = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        totalRoomCount();

        for (int i = 1; i <= totalRooms; i++) {

            int v = room[i];
            HashSet<Pair> pairs = set.getOrDefault(i, new HashSet<>());
            for (Pair p : pairs) {
                int roomNumber = visited[p.y][p.x];
                if (i != roomNumber) brokenWallWide = Math.max(brokenWallWide, room[roomNumber] + v);
            }
        }

        System.out.println(totalRooms);
        System.out.println(mostWideRoom);
        System.out.println(brokenWallWide);
    }

    static void totalRoomCount() {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j] == 0) {
                    totalRooms++;
                    bfs(i,j);
                }
            }
        }
    }

    static void bfs(int i, int j) {

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i,j));
        visited[i][j] = totalRooms;

        int cnt = 0;
        while(!q.isEmpty()) {

            Pair p = q.poll();
            cnt++;
            int y = p.y; int x = p.x;
            List<Integer> dir = getDirection(y,x);
            for (int d = 0; d < 4; d++) {
                int ni = y + di[d]; int nj = x + dj[d];
                if (0 > ni || 0 > nj || ni >= n || nj >= m) continue;
                if (dir.contains(d)) {
                    if (visited[ni][nj] == 0) {
                        visited[ni][nj] = totalRooms;
                        q.add(new Pair(ni,nj));
                    }
                } else {
                    HashSet<Pair> pairs = set.getOrDefault(totalRooms, new HashSet<>());
                    pairs.add(new Pair(ni,nj));
                    set.put(totalRooms, pairs);
                }
            }

        }

        room[totalRooms] = cnt;
        mostWideRoom = Math.max(mostWideRoom, cnt);
    }

    static List<Integer> getDirection(int i, int j) {

        int v = map[i][j];
        List<Integer> directions = new ArrayList<>();
        boolean[] visited = new boolean[4];

        
        for (int k = 3; k >= 0; k--) {
            int value = (int) Math.pow(2,k);
            if (value <= v) {
                visited[k] = true;
                v -= value;                 
            }
            
            if (v <= 0) break;
        }
        

        for (int k = 0; k < visited.length; k++) {
            if (!visited[k]) directions.add(k);
        }

        return directions;
    }
}