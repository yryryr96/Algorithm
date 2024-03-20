import java.io.*;
import java.util.*;

public class Main {

    static int[] di = {-1,0,1,0};
    static int[] dj = {0,1,0,-1};
    static int[][] type1 = {{0},{1},{2},{3}};
    static int[][] type2 = {{0,2},{1,3}};
    static int[][] type3 = {{0,1},{1,2},{2,3},{3,0}};
    static int[][] type4 = {{0,1,2},{0,1,3},{1,2,3},{0,2,3}};
    static int[][] type5 = {{0,1,2,3}};
    static int n,m;
    static int[][] map;
    static int ans = Integer.MAX_VALUE;
    static class Pair {
        int y,x;
        Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    static List<Pair> cctv = new ArrayList<>();
    static Stack<int[]> stack = new Stack<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] != 0 && map[i][j] != 6) cctv.add(new Pair(i,j));
            }
        }

        simulate(0);
        System.out.println(ans);
    }

    static void simulate(int depth) {

        if (depth == cctv.size()) {

            int[][] temp = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    temp[i][j] = map[i][j];
                }
            }

            for (int i = 0; i < cctv.size(); i++) {

                Pair p = cctv.get(i);
                move(temp, stack.get(i), p.y, p.x);
            }

            ans = Math.min(count(temp), ans);
            return;
        }

        Pair p = cctv.get(depth);
        int[][] dir = getDirection(p.y, p.x);

        for (int[] d : dir) {
            stack.add(d);
            simulate(depth+1);
            stack.pop();
        }
    }

    static int count(int[][] temp) {

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (temp[i][j] == 0) cnt++;
            }
        }

        return cnt;
    }

    static void move(int[][] temp, int[] dir, int y, int x) {

        for (int i = 0; i < dir.length; i++) {
//            System.out.println("i = " + i);
            int ni = y + di[dir[i]]; int nj = x + dj[dir[i]];
//            System.out.println("ni = " + ni + " nj = " + nj);
            while(isRange(ni,nj)) {
                if (map[ni][nj] == 6) break;
                if (map[ni][nj] == 0) temp[ni][nj] = -1;
                ni += di[dir[i]];
                nj += dj[dir[i]];
            }
        }
    }

    static boolean isRange(int i, int j) {
        return 0 <= i && 0 <= j && i < n && j < m;
    }

    static int[][] getDirection(int i, int j) {

        int[][] dir;
        if (map[i][j] == 1) dir = type1;
        else if(map[i][j] == 2) dir = type2;
        else if(map[i][j] == 3) dir = type3;
        else if(map[i][j] == 4) dir = type4;
        else dir = type5;

        return dir;
    }
}